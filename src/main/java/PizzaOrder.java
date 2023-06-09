public class PizzaOrder {

    private String crust;
    private String sauce;
    private String size;
    private String[] topping;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PizzaOrder(){}

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getTopping() {
        return topping;
    }

    public void setTopping(String[] topping) {
        this.topping = topping;
    }

    public PizzaOrder(String crust, String sauce, String size, String[] topping, String address) {
        this.crust = crust;
        this.sauce = sauce;
        this.size = size;
        this.topping = topping;
        this.address = address;
    }
}
