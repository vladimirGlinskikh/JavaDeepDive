package kz.zhelezyaka.leetcode.same_tree_100;

import kz.zhelezyaka.leetcode.algorithms.same_tree_100.Solution;
import kz.zhelezyaka.leetcode.algorithms.same_tree_100.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void shouldIsSameTree() {
        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertTrue(solution.isSameTree(node1, node2));
    }

    @Test
    void shouldNotIsTheSameTree() {
        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node2 = new TreeNode(2, new TreeNode(2), new TreeNode(3));

        assertFalse(solution.isSameTree(node1, node2));
    }


    @Test
    void shouldHandleEmptyTrees() {
        assertTrue(solution.isSameTree(null, null));

        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertFalse(solution.isSameTree(node1, null));
        assertFalse(solution.isSameTree(null, node1));
    }
}