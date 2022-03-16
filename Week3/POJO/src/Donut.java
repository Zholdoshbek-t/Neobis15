public class Donut {

    private String coating;
    private String topping;
    private String drizzle;

    public Donut(String coating, String topping, String drizzle) {
        this.coating = coating;
        this.topping = topping;
        this.drizzle = drizzle;
    }

    public Donut() {}

    public String getCoating() {
        return coating;
    }

    public void setCoating(String coating) {
        this.coating = coating;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getDrizzle() {
        return drizzle;
    }

    public void setDrizzle(String drizzle) {
        this.drizzle = drizzle;
    }

    @Override
    public String toString() {
        return String.format("Donut -> Coating: %s \n" +
                        "         Topping: %s\n" +
                        "         Drizzle: %s\n",
                this.coating, this.topping, this.drizzle);
    }
}
