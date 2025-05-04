public class OverTheCounter extends Medicine {
    //data field
    private int minage;

    //constructors
    public OverTheCounter(String name, String composition, int dose, int minage) {
        super(name, composition, dose);
        setminage(minage);
        //this.minage = minage;
    }

    public OverTheCounter(String name, String composition, int dose, double price, int quantity, int minage) {
        super(name, composition, dose, price, quantity);
        setminage(minage);
        //this.minage = minage;
    }

    //setters
    public void setminage(int minage) {
        if (minage > 0)
            this.minage = minage;
        else
            this.minage = 18;
    }

    //getters
    public int getminage() {
        return minage;
    }

    //method to string
    public String toString() {
        return "-Overthecounter: \n" + super.toString() +
                "\nminimum age: " + getminage();
    }


}
