package modelservices;

import java.time.LocalDate;

import modelentities.Contract;
import modelentities.Installment;

public class ProcessPaymentService {

    private PaymentService paymentService;

    public ProcessPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processInstallments(Contract contract, Integer months) {
        double amountInstallment = contract.getTotalValue() / months;
        
        for (int i = 0; i < months; i++) {
            LocalDate date = contract.getDate().plusMonths(i + 1);
            double amount = paymentService.feeService(amountInstallment, i + 1);

            contract.addInstallment(new Installment(date, amount));
        }
    }
}
