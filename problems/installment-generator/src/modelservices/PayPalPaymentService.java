package modelservices;

public class PayPalPaymentService implements PaymentService {
    
    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public double feeService(double amount, int month) {
        double simpleInterest = amount + amount * MONTHLY_INTEREST * month;
        double totalWithFees =  simpleInterest * (1.0 + PAYMENT_FEE);
        return totalWithFees; 
    }
}
