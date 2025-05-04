import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    //data fields
    private String name;
    private Medicine[] medicine;
    private int overthecounterquantity;
    private int prescriptionquantity;
    private int numberofmedicine;
    private static int maxnumberofmedicine = 100;

    //constructor
    public Pharmacy(String name) {
        this.name = name;
        this.medicine = new Medicine[maxnumberofmedicine];
        this.overthecounterquantity = 0;
        this.prescriptionquantity = 0;
        this.numberofmedicine = 0;
    }

    //method add medicine
    public void addMedicine(Medicine newMedicine) {
        if (numberofmedicine == maxnumberofmedicine) {
            System.out.println("Pharmacy is full.");
        }
        for (int i = 0; i < numberofmedicine; i++) {

            if (medicine[i].getname().equals(name)) {
                System.out.println("Medicine already exists.");
            }
        }

        medicine[numberofmedicine] = newMedicine;
        numberofmedicine++;

        if (newMedicine instanceof OverTheCounter) {
            overthecounterquantity += newMedicine.getquantity();
        } else {
            prescriptionquantity += newMedicine.getquantity();
        }
    }

    // methode to raise prices
    public void raisePrices(double percentage) {
        for (int i = 0; i < numberofmedicine; i++) {

            double currentPrice = medicine[i].getprice();
            double newPrice = currentPrice * (1 + (percentage / 100));

            medicine[i].setprice(newPrice);
        }
    }

    // method to search medicine by name
    public int[] searchByName(String name) {
        int[] indices = new int[numberofmedicine];
        int count = 0;

        for (int i = 0; i < numberofmedicine; i++) {

            if (medicine[i].getname().contains(name)) {
                indices[count] = i;
                count++;
            }
        }

        int[] result = new int[count];
        System.arraycopy(indices, 0, result, 0, count);

        return result;
    }

    //methode to search medicine by name and dose
    public int searchByNameAndDose(String name, int dose) {
        List<Medicine> foundMedicine = new ArrayList<>();

        for (int i = 0; i < numberofmedicine; i++) {

            if (medicine[i].getname().contains(name) && medicine[i].getdose() == dose) {
                foundMedicine.add(medicine[i]);
                return i;
            }
        }

        return -1;
    }

    // method to search medicine by composition
    public int[] searchByComposition(String composition) {
        int[] indices = new int[numberofmedicine];
        int count = 0;

        for (int i = 0; i < numberofmedicine; i++) {

            if (medicine[i].getcomposition().contains(composition)) {
                indices[count] = i;
                count++;
            }
        }

        int[] result = new int[count];
        System.arraycopy(indices, 0, result, 0, count);

        return result;
    }

    // method to sell medicine
    public void sellMedicine(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);

        if (index == -1) {
            System.out.println("Medicine not found");

        } else if (medicine[index].getquantity() < quantity) {
            System.out.println("Available quantity is not enough.");

        } else {
            medicine[index].setquantity(medicine[index].getquantity() - quantity);

            if (medicine[index] instanceof OverTheCounter) {
                overthecounterquantity -= quantity;
            } else {
                prescriptionquantity -= quantity;
            }
            System.out.println("Selling successful.");

        }
    }

    //method to restock medicine
    public boolean restock(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);
        if (index != -1) {
            medicine[index].setquantity(medicine[index].getquantity() + quantity);
            return true;
        }
        return false;
    }

    //getters
    public String getName() {
        return name;
    }

    public Medicine[] getMedicine() {
        return medicine;
    }

    public int getPrescriptionQuantity() {
        return prescriptionquantity;
    }

    public int getOverTheCounterQuantity() {
        return overthecounterquantity;
    }

    public int getNumberOfMedicine() {
        return numberofmedicine;
    }

    public static int getmaxnumberofmedicine() {
        return maxnumberofmedicine;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public static void setMaxNumberOfMedicine(int Maxnumberofmedicine) {
        maxnumberofmedicine = Maxnumberofmedicine;
    }

    //method to String
    public String toString() {
        return "Pharmacy: " + getName() +
                "\nNumber of Medicines: " + getNumberOfMedicine() +
                "\nOver the counter quantity: " + getOverTheCounterQuantity() +
                "\nPrescription quantity: " + getPrescriptionQuantity();
    }
}
