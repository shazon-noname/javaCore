package algos.Tree;

import java.util.*;

public class TreeExample {
    int value;

    TreeExample left;
    TreeExample right;

    public TreeExample(int value, TreeExample left, TreeExample right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeExample(int value) {
        this.value = value;
    }


    public int sumDeep() {
        int sum = value;
        if (left != null) {
            sum += left.sumDeep();
        }
        if (right != null) {
            sum += right.sumDeep();
        }
        return sum;
    }

    public int sumWide(TreeExample root) {
        Queue<TreeExample> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeExample node = queue.remove();
            sum += node.value;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return sum;
    }

    public int sumStack(TreeExample root) {
        Stack<TreeExample> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeExample node = stack.pop();
            sum += node.value;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return sum;
    }

    public List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(this, list);
        return list;
    }

    public void inOrderTraversal(TreeExample node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.value);
        inOrderTraversal(node.right, list);
    }

    public void quickSort(List<Integer> array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex-1);
            quickSort(array, divideIndex, to);
        }
    }

    public static int partition(List<Integer> array, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        int pivot = array.get((from + to) / 2);
        while (leftIndex <= rightIndex) {
            while (array.get(leftIndex) < pivot) {
                leftIndex++;
            }
            while  (array.get(rightIndex) > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                Collections.swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        TreeExample tree = new TreeExample(25,
                new TreeExample(12, new TreeExample(10, new TreeExample(2), null), new TreeExample(11,
                        new TreeExample(5), new TreeExample(7))),
                new TreeExample(28, new TreeExample(22), new TreeExample(33)));
        int sumStack = tree.sumStack(tree);
        int sumDeep = tree.sumDeep();
        int sumWide = tree.sumWide(tree);
        System.out.println(sumStack);
        System.out.println(sumDeep);
        System.out.println(sumWide);
        List<Integer> array = tree.createList();
        tree.quickSort(array, 0, array.size() - 1);
        System.out.println(array);

    }
}
