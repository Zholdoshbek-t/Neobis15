public class Laptop {

    private String brand;
    private String model;
    private String size;
    private String cpu;
    private String storageDrive;

    public Laptop(String brand, String model, String size, String cpu, String storageDrive) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.cpu = cpu;
        this.storageDrive = storageDrive;
    }

    public Laptop() {}

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getStorageDrive() {
        return storageDrive;
    }

    public void setStorageDrive(String storageDrive) {
        this.storageDrive = storageDrive;
    }

    @Override
    public String toString() {
        return String.format("Laptop -> Brand: %s \n" +
                "          Model: %s\n" +
                "          Size: %s\n" +
                "          CPU: %s\n" +
                "          Storage Drive: %s\n",
                this.brand, this.model, this.size, this.cpu, this.storageDrive);
    }
}
