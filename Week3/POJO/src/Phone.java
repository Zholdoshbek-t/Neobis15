public class Phone {

    private String brand;
    private String model;
    private String phoneMemory;

    public Phone(String brand, String model, String phoneMemory) {
        this.brand = brand;
        this.model = model;
        this.phoneMemory = phoneMemory;
    }

    public Phone() {}

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

    public String getPhoneMemory() {
        return phoneMemory;
    }

    public void setPhoneMemory(String phoneMemory) {
        this.phoneMemory = phoneMemory;
    }

    @Override
    public String toString() {
        return String.format("Phone -> Brand: %s \n" +
                "         Model: %s\n" +
                "         Phone memory: %s\n",
                this.brand, this.model, this.phoneMemory);
    }
}
