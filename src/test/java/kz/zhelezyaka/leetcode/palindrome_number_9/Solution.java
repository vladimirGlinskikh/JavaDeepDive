package kz.zhelezyaka.leetcode.palindrome_number_9;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        String stringValue = String.valueOf(x);
        List<Character> list = new LinkedList<>();

        for (char ch : stringValue.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseIterator = list.listIterator(list.size());

        while (iterator.hasNext() && reverseIterator.hasPrevious()) {
            if (iterator.next() != reverseIterator.previous()) {
                return false;
            }
        }
        return true;
    }
}
