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

    public List<Integer> mergeSort(List<Integer> array) {
        List<Integer> currentSrc = array;
        List<Integer> currentDest = new ArrayList<>(array.size());


        for (int i = 0; i < array.size(); i++) {
            currentDest.add(null);
        }

        int size = 1;

        while (size < array.size()) {

            for (int i = 0; i < array.size(); i += size * 2) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }


            List<Integer> temp = currentSrc;
            currentSrc = currentDest;
            currentDest = temp;

            size *= 2;

        }

        return currentSrc;
    }

    public void merge(List<Integer> src1, int src1Start, List<Integer> src2, int src2Start, List<Integer> dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.size());
        int src2End = Math.min(src2Start + size, src2.size());

        int iterationCount = (src1End - src1Start) + (src2End - src2Start);

        for (int i = 0; i < iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1.get(index1) < src2.get(index2))) {
                dest.set(destStart + i, src1.get(index1));
                index1++;
            } else if (index2 < src2End) {
                dest.set(destStart + i, src2.get(index2));
                index2++;
            }
        }
    }


    public static void main(String[] args) {
        TreeExample tree = new TreeExample(25,
                new TreeExample(12, new TreeExample(10, new TreeExample(2), null), new TreeExample(11,
                        new TreeExample(5), new TreeExample(7))),
                new TreeExample(28, new TreeExample(22), new TreeExample(33)));

        int sumStack = tree.sumStack(tree);
        int sumDeep = tree.sumDeep();
        int sumWide = tree.sumWide(tree);

        System.out.println("sumStack = " + sumStack);
        System.out.println("sumDeep = " + sumDeep);
        System.out.println("sumWide = " + sumWide);

        List<Integer> array = tree.createList();

        tree.quickSort(array, 0, array.size() - 1);
        System.out.println("quickSort = " + array);

        List<Integer> arraySorted = tree.mergeSort(array);
        System.out.println("mergeSort = " + arraySorted);

    }
}
