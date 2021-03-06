public class Car {

    private String brand;
    private String model;
    private String year;
    private String color;

    public Car(String brand, String model, String year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Car() {}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Car -> Brand: %s \n" +
                        "       Model: %s\n" +
                        "       Year: %s\n" +
                        "       Color: %s\n",
                this.brand, this.model, this.year, this.color);
    }
}
