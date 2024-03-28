package org.example.second;

import org.example.second.tree.RedBlackTree;

public class SecondMain {

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree(Integer.MIN_VALUE);

        redBlackTree.insertNewNode(45);
        redBlackTree.insertNewNode(23);
        redBlackTree.insertNewNode(7);

        System.out.println(redBlackTree.postorderTraversal());
        System.out.println(redBlackTree.preorderTraversal());
        System.out.println(redBlackTree.inorderTraversal());

        System.out.println(redBlackTree.searchNode(7));
        System.out.println(redBlackTree.searchNode(8));
        System.out.println(redBlackTree.nodesInTree());
        System.out.println(redBlackTree.checkEmpty());

        redBlackTree.removeAll();

        System.out.println(redBlackTree.checkEmpty());
    }

}
