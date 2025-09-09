public class Vehicle {
    private String brand;
    private int year;
    private VehicleType type;
    private double price;

    public Vehicle(String brand, int year, VehicleType type, double price) {
        this.brand = brand;
        this.year = year;
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void showDetail() {
        System.out.println("Brand =" + brand);
        System.out.println("Year = " + year);
        System.out.println("Type = " + type);
        System.out.println("Price = " + price);
    }
}