
import java.util.Scanner;

public class Main {

    private static Pharmacy pharmacy = new Pharmacy("PharmaTony");

    public static void main(String[] args) {

        int choice;

        do {
            choice = menu();
            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    searchByName(pharmacy);
                    break;
                case 3:
                    searchByComposition(pharmacy);
                    break;
                case 4:
                    sellMedicine(pharmacy);
                    break;
                case 5:
                    restock(pharmacy);
                    break;
                case 6:
                    displayAllMedicines();
                    break;
                case 7:
                    displayInformation(pharmacy);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 8);
    }

    //method menu displays all option that the user can select
    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPharmacy Menu\n");
        System.out.println("1- Add a new medicine");
        System.out.println("2- Search for a medicine by name");
        System.out.println("3- Search for a medicine by composition");
        System.out.println("4- Sell a medicine");
        System.out.println("5- Restock a medicine");
        System.out.println("6- Display all medicines");
        System.out.println("7- Display information");
        System.out.println("8- Exit");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

    //if the user selects to add medicine it will take him to method addmedicine in pharmacy and to
    //add it over the counter or to add it in prescription
    public static void addMedicine() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter o for over the counter and p for prescription: ");
        char choice = input.nextLine().charAt(0);

        choice = Character.toLowerCase(choice);

        System.out.print("Enter the name of the medicine: ");
        String name = input.nextLine();

        System.out.print("Enter the composition of the medicine: ");
        String composition = input.nextLine();

        System.out.print("Enter the dose of the medicine: ");
        int dose = input.nextInt();

        System.out.print("Enter the price of the medicine: ");
        double price = input.nextDouble();

        System.out.print("Enter the quantity of the medicine: ");
        int quantity = input.nextInt();

        if (choice == 'p') {
            System.out.print("Enter doctor specialization: ");
            String doctorspecialization = input.next();

            Prescription medicine1 = new Prescription(name, composition, dose, price, quantity, doctorspecialization);
            pharmacy.addMedicine(medicine1);

        } else {
            System.out.print("Enter min age: ");
            int minage = input.nextInt();

            OverTheCounter medicine2 = new OverTheCounter(name, composition, dose, price, quantity, minage);
            pharmacy.addMedicine(medicine2);
        }
        System.out.println("New medicine is added Successfully");
    }

    //if the user selects to search medicine by name it will take him to method searchbyname in pharmacy
    public static void searchByName(Pharmacy pharmacy) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the medicine: ");
        String name = input.nextLine();

        int[] result = pharmacy.searchByName(name);
        for (int i = 0; i < result.length; i++) {

            System.out.print(i + 1+ pharmacy.getMedicine()[result[i]].toString()+"\n");
        }
    }

    //if the user selects to search by composition it will take him to method searchbycomposition in pharmacy
    public static void searchByComposition(Pharmacy pharmacy) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the composition of the medicine: ");
        String composition = input.nextLine();

        int [] result=pharmacy.searchByComposition(composition);
        for (int i = 0; i < result.length; i++) {

            System.out.print(i + 1 + pharmacy.getMedicine()[result[i]].toString()+"\n");
        }
    }

    //if the user selects to sell medicine it will take him to method sellmedicine in pharmacy
    public static void sellMedicine(Pharmacy pharmacy) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the medicine you want to sell:");
        String name = input.nextLine();

        System.out.println("Enter dose you want to sell");
        int dose = input.nextInt();

        System.out.println("Enter the quantity you want to sell:");
        int quantity = input.nextInt();

        pharmacy.sellMedicine(name, dose, quantity);
    }

    //if the user selects to restock medicine it will take him to method restock in pharmacy
    public static void restock(Pharmacy pharmacy) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter medicine name:");
        String name = input.nextLine();

        System.out.println("Enter dose:");
        int dose = input.nextInt();

        System.out.println("Enter quantity:");
        int quantity = input.nextInt();

        boolean result = pharmacy.restock(name, dose, quantity);

        if (result) {
            System.out.println("Medicine restocked successfully!");
        } else {
            System.out.println("Medicine not found.");
        }
    }

    //method to show all medicine
    public static void displayAllMedicines() {

        for (int i = 0; i < pharmacy.getNumberOfMedicine(); i++) {

            System.out.println(i + 1 + "-" + pharmacy.getMedicine()[i].toString());
        }
    }

    //method to show the details of the pharmacy
    public static void displayInformation(Pharmacy pharmacy) {
        System.out.println(pharmacy.toString());

    }
}
