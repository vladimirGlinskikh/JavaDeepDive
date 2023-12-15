package kz.zhelezyaka.patterns.decorator;

// Интерфейс для текста
interface Text {
    String getContent();
}

// Конкретная реализация компонента (базового текста)
class SimpleText implements Text {
    private String content;

    public SimpleText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

// Абстрактный декоратор
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String getContent() {
        return decoratedText.getContent();
    }
}

// Конкретный декоратор для жирного форматирования
class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}

// Конкретный декоратор для курсивного форматирования
class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getContent() {
        return "<i>" + super.getContent() + "</i>";
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем базовый текст
        Text simpleText = new SimpleText("Hello, pattern Decorator!");

        // Декорируем текст жирным форматированием
        Text boldText = new BoldDecorator(simpleText);
        System.out.println(boldText.getContent());  // Вывод: <b>Hello, pattern Decorator!</b>

        // Декорируем текст курсивным форматированием
        Text italicText = new ItalicDecorator(simpleText);
        System.out.println(italicText.getContent());  // Вывод: <i>Hello, pattern Decorator!</i>

        // Комбинированный декоратор (жирный и курсивный)
        Text boldItalicText = new BoldDecorator(new ItalicDecorator(simpleText));
        System.out.println(boldItalicText.getContent());  // Вывод: <b><i>Hello, pattern Decorator!</i></b>
    }
}
