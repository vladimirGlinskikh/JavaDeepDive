package kz.zhelezyaka.patterns.builder;

// Продукт, который мы строим
class HTMLDocument {
    private String header;
    private String body;
    private String footer;

    private HTMLDocument() {
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getFooter() {
        return footer;
    }

    // Строитель для пошагового построения объекта HTMLDocument
    static class HTMLDocumentBuilder {
        private HTMLDocument document;

        HTMLDocumentBuilder() {
            this.document = new HTMLDocument();
        }

        HTMLDocumentBuilder setHeader(String header) {
            this.document.header = header;
            return this;
        }

        HTMLDocumentBuilder setBody(String body) {
            this.document.body = body;
            return this;
        }

        HTMLDocumentBuilder setFooter(String footer) {
            this.document.footer = footer;
            return this;
        }

        HTMLDocument build() {
            return document;
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        HTMLDocument document = new HTMLDocument.HTMLDocumentBuilder()
                .setHeader("<head><title>My HTML Page</title></head>")
                .setBody("<body><h1>Hello, Pattern Builder!</h1></body>")
                .setFooter("<footer>&copy; 2023</footer>")
                .build();

        System.out.println("Header:\n" + document.getHeader());
        System.out.println("\nBody:\n" + document.getBody());
        System.out.println("\nFooter:\n" + document.getFooter());
    }
}
