public class Medicine {
    //data fields
    private String name;
    private String composition;
    private int dose = 1000;
    private double price;
    private int quantity;

    //constructors
    public Medicine(String name, String composition, int dose) {
        this(name, composition, dose, 10.0, 0);
    }

    public Medicine(String name, String composition, int dose, double price, int quantity) {
        setmedicine(name, composition, dose, price, quantity);

    }

    //setters
    public void setmedicine(String name, String composition, int dose, double price, int quantity) {
        setname(name);
        setcomposition(composition);
        setdose(dose);
        setprice(price);
        setquantity(quantity);
    }

    public void setname(String name) {
        this.name = name.toLowerCase();
    }

    public void setcomposition(String composition) {
        this.composition = composition.toLowerCase();
    }

    public void setdose(int dose) {
        this.dose = dose;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    //getters
    public String getname() {
        return name;
    }

    public String getcomposition() {
        return composition;
    }

    public int getdose() {
        return dose;
    }

    public double getprice() {
        return price;
    }

    public int getquantity() {
        return quantity;
    }

    //to String method
    public String toString() {
        return "name: " + getname() +
                "\ncomposition: " + getcomposition() +
                "\ndose: " + getdose() +
                "\nprice: " + getprice() +
                "\nquantity: " + getquantity();
    }

    // method equals
    public boolean equal(String name, int dose) {
        if (getname().equals(name) && getdose() == dose)
            return true;
        return false;
    }

}
