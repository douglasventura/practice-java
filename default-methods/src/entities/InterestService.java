package entities;

public interface InterestService {
    
    public double getInterestRate();

    default double payment(double amount, int months) {
        double total = amount * Math.pow((1 + (getInterestRate() / 100)), months);
        return total;
    }
}
