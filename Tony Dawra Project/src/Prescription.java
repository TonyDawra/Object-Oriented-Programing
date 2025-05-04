public class Prescription extends Medicine {
    //data fields
    private String doctorspecialization;

    //constructors
    public Prescription(String name, String composition, int dose, String doctorspecialization) {
        super(name, composition, dose);
        setdoctorspecialization(doctorspecialization);
        //this.doctorspecialization = doctorspecialization;
    }

    public Prescription(String name, String composition, int dose, double price, int quantity, String doctorspecialization) {
        super(name, composition, dose, price, quantity);
        setdoctorspecialization(doctorspecialization);
        //this.doctorspecialization = doctorspecialization;
    }

    //setters
    public void setdoctorspecialization(String doctorspecialization) {
        this.doctorspecialization = doctorspecialization;
    }

    //getters
    public String getdoctorspecialization() {
        return doctorspecialization;
    }

    //method to String
    public String toString() {
        return "-Prescription: \n" + super.toString() +
                "\ndoctorspecialization: " + getdoctorspecialization();
    }

}
