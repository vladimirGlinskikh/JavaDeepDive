package kz.zhelezyaka.patterns.creational.factory;

public class JavaScriptDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaScriptDeveloper();
    }
}
