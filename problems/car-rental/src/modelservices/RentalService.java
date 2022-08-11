package modelservices;

import java.time.Duration;

import modelentities.CarRental;
import modelentities.Invoice;

public class RentalService {
    
    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService taxService;
    
    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTax(TaxService taxService) {
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        Duration duration = Duration.between(carRental.getStart(), carRental.getFinish());
        double durationInMinutes = duration.toMinutes();
        double basicPayment;
        
        if (durationInMinutes < 720.0) {
            basicPayment = pricePerHour * Math.ceil(durationInMinutes / 60);
        } else {
            basicPayment = pricePerDay * Math.ceil(durationInMinutes / 60 / 24);
        }
        
        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
        
    }

}
