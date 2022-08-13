package entities;

public class Product implements Comparable<Product> {
    
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setprice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + String.format("%.2f%n", this.getPrice());
    }

    @Override
    public int compareTo(Product other) {
        return this.getPrice().compareTo(other.getPrice());
    }

    
}
