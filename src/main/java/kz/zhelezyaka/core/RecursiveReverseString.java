package kz.zhelezyaka.core;
/*
* Инвертирование строки при помощи рекурсии.
*
* Если длина входной строки input меньше или равна 1,
* возвращается исходная строка.
* Это базовый случай, который завершает рекурсию.
*
* Если длина входной строки больше 1,
* метод вызывает сам себя с аргументом input.substring(1),
* что означает подстроку, начиная с первого символа и до конца строки.
* К результату рекурсивного вызова добавляется первый символ
* исходной строки (input.charAt(0)).
*
* Пример выполнения:
* reverseString("input") вызывает reverseString("nput") + "i".
* reverseString("nput") вызывает reverseString("put") + "n".
* reverseString("put") вызывает reverseString("ut") + "p".
* reverseString("ut") вызывает reverseString("t") + "u".
* reverseString("t") возвращает "t" (базовый случай).
*
* Затем результаты объединяются:
* "t" + "u" = "tu"
* "tu" + "p" = "tup"
* "tup" + "n" = "tupn"
* "tupn" + "i" = "tupni"
*
* */

public class RecursiveReverseString {
    public String reverseString(final String input) {
        return input.length() <= 1 ? input :
                reverseString(input.substring(1)) + input.charAt(0);
    }
}
