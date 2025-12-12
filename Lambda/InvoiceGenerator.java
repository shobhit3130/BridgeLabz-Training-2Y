package lambda;

import java.util.*;
import java.util.function.Function;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice for Transaction: " + transactionId;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        // Use constructor reference to create Invoice objects
        Function<String, Invoice> invoiceCreator = Invoice::new;

        List<Invoice> invoices = transactionIds.stream()
                .map(invoiceCreator)
                .toList();

        invoices.forEach(System.out::println);
    }
}