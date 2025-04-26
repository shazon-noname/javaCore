package src.algos.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecursiveTraversalInDepth {
    public static void main(String[] args) {
        Tree root = new Tree(20, new Tree(7, new Tree(4, null, new Tree(6)),
                new Tree(9)), new Tree(35, new Tree(31, new Tree(28), null),
                new Tree(40, new Tree(38), new Tree(52))));
        System.out.println("sum recursive = " + root.recursiveSumValueTree());
        System.out.println("sum stack = " + root.sumDeep(root));
        System.out.println("sum queue = " + root.sumWide(root));
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int recursiveSumValueTree() {
            int sum = value;
            if (left != null) {
                sum += left.recursiveSumValueTree();
            }
            if (right != null) {
                sum += right.recursiveSumValueTree();
            }
            return sum;
        }

        public int sumDeep(Tree root) {
            Stack<Tree> stack = new Stack<>();
            stack.push(root);

            int sum = 0;

            while (!stack.isEmpty()) {
                Tree node = stack.pop();
                System.out.println(node.value); //Перегляд послідовності елементів
                sum += node.value;

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return sum;
        }

        public int sumWide(Tree root) {
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);

            int sum = 0;

            while (!queue.isEmpty()) {
                Tree node = queue.remove();
                System.out.println(node.value); //Перегляд послідовності елементів
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
    }
}


