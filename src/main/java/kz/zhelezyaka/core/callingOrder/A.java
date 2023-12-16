package kz.zhelezyaka.core.callingOrder;

class A {
    static {
        System.out.println("Static block A");
    }

    {
        System.out.println("Instance block A");
    }

    public A() {
        System.out.println("Constructor A");
    }
}

class B extends A {
    static {
        System.out.println("Static block B");
    }

    {
        System.out.println("Instance block B");
    }

    public B() {
        System.out.println("Constructor B");
    }
}

class Main {
    public static void main(String[] args) {
        B obj = new B();
    }
}
