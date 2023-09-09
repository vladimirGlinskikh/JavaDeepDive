package kz.zhelezyaka.solid.lsp.lsp;

import java.util.ArrayList;
import java.util.List;

public class PaymentHelper {
    List<PreviousPayment> previousPayments = new ArrayList<>();

    List<NewPayment> newPayments = new ArrayList<>();

    public void addPreviousPayment(PreviousPayment previousPayment) {
        previousPayments.add(previousPayment);
    }

    public void addNewPayment(NewPayment newPaymentRequest) {
        newPayments.add(newPaymentRequest);
    }

    public void showPreviousPayments() {
        for (PreviousPayment payment : previousPayments) {
            payment.previousPaymentInfo();
            System.out.println("-----------");
        }
    }

    public void processNewPayments() {
        for (NewPayment payment : newPayments) {
            payment.newPayment();
            System.out.println("------------");
        }
    }
}
