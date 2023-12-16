package kz.zhelezyaka.core.blockInitializationException;

public class Experiment {
    static {
        // Намеренная ошибка в блоке инициализации
        int result = 1 / 0;
    }

    public static void main(String[] args) {
        try {
            // Попытка создать объект класса (неудачная из-за ошибки в блоке инициализации)
            Experiment obj = new Experiment();
        } catch (ExceptionInInitializerError e) {
            System.err.println("Exception during class initialization: " + e);
        }
    }
}
