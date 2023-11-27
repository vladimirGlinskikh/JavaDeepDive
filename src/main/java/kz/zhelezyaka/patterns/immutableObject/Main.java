package kz.zhelezyaka.patterns.immutableObject;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //нарушаем инкапсуляцию
        caseMutableConstructor();
        caseMutableSubclass();
        caseMutableAnonymousSubclass();
        caseMutableSetter();
        caseMutableGetter();
        caseMutableReflection();

        printBreak();

        caseImmutableConstructor();
//        caseImmutableSubclass();
//        caseImmutableAnonymousSubclass();
//        caseImmutableSetter();
        caseImmutableGetter();
        caseImmutableReflection();
    }

    private static void printBreak() {
        System.out.println("-----------------------");
    }

    private static void caseMutableConstructor() {
        List<String> list = new LinkedList<>();
        Mutable mutable = new Mutable(list);
        list.add("fail_1");
        System.out.println(mutable);
    }

    static class NewMutable extends Mutable {

        public NewMutable(List<String> data) {
            super(data);
            //и теперь меняем protected поле
            data.add("fail_2");
        }
    }

    private static void caseMutableSubclass() {
        List<String> list = new LinkedList<>();
        //и пользуемся новым классом под видом родителя
        Mutable mutable = new Mutable(list);
        System.out.println(mutable);
    }

    private static void caseMutableAnonymousSubclass() {
        List<String> list = new LinkedList<>();
        //анонимная реализация с блоком инициализации
        Mutable mutable = new Mutable(list) {
            {
                data.add("fail_3");
            }
        };
        System.out.println(mutable);
    }

    private static void caseMutableSetter() {
        List<String> list = new LinkedList<>();
        Mutable mutable = new Mutable(list);

        List<String> newList = new LinkedList<>();
        newList.add("fail_4");
        mutable.setData(newList);
        newList.add("fail_4_1");
        System.out.println(mutable);
    }

    private static void caseMutableGetter() {
        List<String> list = new LinkedList<>();
        Mutable mutable = new Mutable(list);
        mutable.getData().add("fail_5");
        System.out.println(mutable);
    }

    private static void caseMutableReflection() {
        List<String> list = new LinkedList<>();
        Mutable mutable = new Mutable(list);
        try {
            Field data = mutable.getClass().getDeclaredField("data");
            data.setAccessible(true);
            data.set(mutable, Arrays.asList("fail_6"));
            data.setAccessible(false);
        } catch (Exception e) {
        }
        System.out.println(mutable);
    }

    private static void caseImmutableConstructor() {
        List<String> list = new LinkedList<>();
        Immutable immutable = new Immutable(list);
        list.add("fail_1");
        System.out.println(immutable);
    }

    private static void caseImmutableGetter() {
        List<String> list = new LinkedList<>();
        Immutable immutable = new Immutable(list);
        immutable.getData().add("fail_5");
        System.out.println(immutable);
    }

    private static void caseImmutableReflection() {
        List<String> list = new LinkedList<>();
        Immutable immutable = new Immutable(list);
        try {
            Field data = immutable.getClass().getDeclaredField("data");
            data.setAccessible(true);
            data.set(immutable, Arrays.asList("fail_6"));
            data.setAccessible(false);
        } catch (Exception e) {
        }
        System.out.println(immutable);
    }
}
