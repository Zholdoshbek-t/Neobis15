public class Cake {

    private String name;
    private String size;

    public Cake(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public Cake() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Cake -> Name: %s \n" +
                        "        Size: %s\n",
                this.name, this.size);
    }
}
