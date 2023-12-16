package kz.zhelezyaka.core.staticExperiments.overload;

class Experiment {
    static void myMethod(int x) {
        System.out.println("Static method with int parameter: " + x);
    }

    static void myMethod(int x, double y) {
        System.out.println("Static method with int and double parameters: " +
                x + " and " + y);
    }

    void myMethod(String s) {
        System.out.println("Instance method with String parameter: " + s);
    }
}

public class Main {
    public static void main(String[] args) {
        Experiment obj = new Experiment();

        Experiment.myMethod(10);
        Experiment.myMethod(10, 3.4);

        obj.myMethod("We can Overload Static methods");
    }
}