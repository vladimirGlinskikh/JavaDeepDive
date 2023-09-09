package kz.zhelezyaka.solid.lsp.lsp;

public class Client {
    public static void main(String[] args) {
        System.out.println("This example with LSP principal");
        PaymentHelper helper = new PaymentHelper();

        RegisteredUserPayment vladimirPayment =
                new RegisteredUserPayment("Vladimir");
        RegisteredUserPayment svetlanaPayment =
                new RegisteredUserPayment("Svetlana");
        GuestUserPayment guestUser = new GuestUserPayment();

        helper.addPreviousPayment(vladimirPayment);
        helper.addPreviousPayment(svetlanaPayment);

        helper.addNewPayment(vladimirPayment);
        helper.addNewPayment(svetlanaPayment);
        helper.addNewPayment(guestUser);

        helper.showPreviousPayments();
        helper.processNewPayments();
    }
}
