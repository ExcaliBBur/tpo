package org.example.second.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RedBlackTreeTest {

    private final RedBlackTree redBlackTree = new RedBlackTree(Integer.MIN_VALUE);

    @BeforeEach
    public void fillTree() {
        redBlackTree.insertNewNode(45);
        redBlackTree.insertNewNode(23);
        redBlackTree.insertNewNode(7);
    }

    @AfterEach
    public void clearTree() {
        redBlackTree.removeAll();
    }

    @Test
    public void postOrderCorrect() {
        Assertions.assertEquals("23R 45R 7B ", redBlackTree.postorderTraversal());
    }

    @Test
    public void preOrderCorrect() {
        Assertions.assertEquals("7B 45R 23R ", redBlackTree.preorderTraversal());
    }

    @Test
    public void inOrderCorrect() {
        Assertions.assertEquals("7B 23R 45R ", redBlackTree.inorderTraversal());
    }

    @Test
    public void searchNodeTrue() {
        Assertions.assertTrue(redBlackTree.searchNode(7));
    }

    @Test
    public void searchNodeFalse() {
        Assertions.assertFalse(redBlackTree.searchNode(8));
    }

    @Test
    public void nodesInTree() {
        Assertions.assertEquals(3, redBlackTree.nodesInTree());
    }

    @Test
    public void checkEmpty() {
        Assertions.assertFalse(redBlackTree.checkEmpty());
    }

    @Test
    public void checkRemove() {
        redBlackTree.removeAll();
        Assertions.assertTrue(redBlackTree.checkEmpty());
    }

    @Test
    public void rotationWithRight() {
        redBlackTree.insertNewNode(46);
        Assertions.assertEquals(2, redBlackTree.nodesInTree());
    }
}
