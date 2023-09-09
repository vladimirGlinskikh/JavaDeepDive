package kz.zhelezyaka.solid.lsp.lsp;

public class RegisteredUserPayment implements NewPayment, PreviousPayment {
    String name;

    public RegisteredUserPayment(String name) {
        this.name = name;
    }

    @Override
    public void newPayment() {
        System.out.println("Processing " + name + "'s current payment request.");
    }

    @Override
    public void previousPaymentInfo() {
        System.out.println("Retrieving " + name + "'s last payment details.");
    }
}
