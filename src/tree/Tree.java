package tree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode( 20);
        treeNode.insert(10);
        treeNode.insert(30);
        treeNode.insert(15);
        treeNode.insert(25);

        treeNode.printInOrder();
        System.out.println();

        List<List<Integer>> zigZagLevel = printZigZagLevel(treeNode);
        zigZagLevel.forEach(System.out::println);


    }

    private static List<List<Integer>> printZigZagLevel(TreeNode treeNode) {

        List<List<Integer>> result = new ArrayList<>();
        if (treeNode == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        boolean order = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (order) {
                    temp.addLast(currentNode.val);
                } else {
                    temp.addFirst(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(temp);
            order = !order;
        }
        return result;
    }
}
