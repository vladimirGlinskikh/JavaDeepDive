package kz.zhelezyaka.life;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Solution3Test {
    @Test
    void testAddTwoNumbers() {
        // Создаем список l1: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Создаем список l2: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution3 solution = new Solution3();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Ожидаемый результат: 7 -> 0 -> 8
        ListNode expected = new ListNode(7);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(8);

        // Проверяем, что результат совпадает с ожидаемым результатом
        while (result != null && expected != null) {
            assertEquals(expected.val, result.val);
            result = result.next;
            expected = expected.next;
        }

        // Проверяем, что оба списка полностью пройдены
        assertNull(result);
        assertNull(expected);
    }
}