package kz.zhelezyaka.patterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createSpecificSpecialist("Kotlin");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createSpecificSpecialist(String specific) {
        if (specific.equalsIgnoreCase("kotlin")) {
            return new KotlinDeveloperFactory();
        } else if (specific.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specific.equalsIgnoreCase("js")) {
            return new JavaScriptDeveloperFactory();
        } else {
            throw new RuntimeException("This " + specific + " is not supported.");
        }
    }
}
