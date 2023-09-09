package kz.zhelezyaka.solid.lsp.withoutLSP;

public class Client {
    public static void main(String[] args) {
        System.out.println("This example without LSP");
        PaymentHelper helper = new PaymentHelper();

        RegisteredUserPayment vladimirPayment =
                new RegisteredUserPayment("Vladimir");
        RegisteredUserPayment svetlanaPayment =
                new RegisteredUserPayment("Svetlana");
        GuestUserPayment guestUser = new GuestUserPayment();

        helper.addUser(vladimirPayment);
        helper.addUser(svetlanaPayment);
        helper.addUser(guestUser);

        helper.showPreviousPayments();
        helper.processNewPayments();
    }
}
