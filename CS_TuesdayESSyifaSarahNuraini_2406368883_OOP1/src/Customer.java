public class Customer {
    private String Name;
    private Vehicle  vehicle;

    public Customer(String name, Vehicle vehicle) {
        this.Name = name;
        this.vehicle = vehicle;
    }

    public double getTotalPrice() {
        return vehicle.getPrice();
    }

    public void showDetails() {
        System.out.println("Name: " + Name);
        System.out.println("Vehicle: ");
        vehicle.showDetail();
        System.out.println("Total Price: " + vehicle.getPrice());
    }
}
