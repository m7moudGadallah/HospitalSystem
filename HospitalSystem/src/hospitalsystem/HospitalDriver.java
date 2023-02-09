package hospitalsystem;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * HospitalDriver Class represent our system functionality as running system or
 * @author Mahmoud Gadallah
 */
public class HospitalDriver {
    String [] specializations;      //contains all hospital specialization
    ArrayDeque<Reservatoin>[] reservations;     //all reservation and it's size the same as specialization

    public HospitalDriver() {
        //adding hospital specialization
        specializations = new String[] {"Cardiology", "Neurology", "Orthopedics", "Oncology", "Pediatrics",
        "Obstetrics and Gynecology", "Gastroenterology", "Dermatology", "Ophthalmology", "Anesthesiology",
        "Radiology", "Physical Medicine and Rehabilitation", "Pulmonology", "Psychiatry", "Rheumatology",
        "Infectious Diseases", "Endocrinology", "Hematology", "Urology", "Allergy and Immunology"};

        reservations = new ArrayDeque [20];
        for (int i = 0; i < 20; ++i)
                reservations[i] = new ArrayDeque<Reservatoin>();
    }

    /**
     * just display specialization of hospital
     */
    private void displaySpecializations() {
        for (int i = 0; i <20; ++i) {
            System.out.println("[" + i + "] " + specializations[i]);
        }
    }

    /**
     * Summary: show menu for user
     * Details:
     * in this method we ask user to input his choice to exist system , adding new patient, print all patient,
     *      get next patient
     *
     * @exception
     * if user input invalid input
     *
     * @return  choice that user choose from menu
     */

    private int menu() {
        System.out.println("Menu");
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("[0] Add new patient\n" +
                "[1] Print all Patient\n" +
                "[2] Get next patient\n" +
                "[-1] Exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int choice;
        while (true) {
            try {
                while (true) {
                    System.out.print("Choice [-1-->2]: ");
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();      //take user choice

                    if (choice < -1 || choice > 2) {    //if not valid choice
                        System.out.println("Invalid Input, you choice should be from -1 to 2");
                    }
                    else
                        break;
                }

                break;
            }
            catch (Exception e) {       //if choice isn't int
                System.out.println(e + ", Invalid Input, please try again");
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return choice;      //return user choice
    }

    /**
     * Summary: used to add a new reservation
     * Details:
     * this function Ask user to choose Specialization who need to reserve in and then checking if this reservation
     * is already has an empty place as each specialization can only have 5 reservations if this specialization already
     * have place ,so we will ask user about his name and status (urgent, regular) then we add
     * this reservation to the dequeue of this specialization
     *
     * @exception
     * if user input invalid input
     */
    private void addPatient() {
        displaySpecializations();
        System.out.println("[-1] Back to Menu");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int choice;
        while (true) {      //keep repeating this process until user input a valid input
            try {
                while (true) {
                    System.out.print("Choice [-1-->19]: ");
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();  //take specialization choice from user

                    if (choice < -1 || choice > 19) {   // if this input is invalid
                        System.out.println("Invalid Input, you choice should be from -1 to 19");
                    }
                    else
                        break;
                }

                break;
            }
            catch (Exception e) {       //if user input isn't int
                System.out.println(e + ", Invalid Input, please try again");
            }
        }
        if (choice != -1) {     //if user doesn't want to go back to menu
            if (reservations[choice].size() >= 5) { // if this specialization already doesn't have a place for new reservation
                System.out.println("Sorry, " + specializations[choice] + " hasn't available reservation now");
            }
            else {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter patient name: ");
                String name = sc.next();        //take patient name
                System.out.print("Choose Status ([0]regular, [1] urgent): ");
                int status = sc.nextInt();      //take status

                Reservatoin reservatoin = new Reservatoin(name, specializations[choice]);
                if (status == 0) {      //if normal so we add reservation at the end of the dequeue
                    reservations[choice].addLast(reservatoin);
                }
                else {      //if urgent we add reservation at the front of the dequeue
                    reservations[choice].addFirst(reservatoin);
                }

                System.out.println("Patient reservatoin added successfully");
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     *  displayPatients is used to display all reservation in each specialization
     */
    private void displayPatients() {
        for (int i = 0; i < 20; i++) {
            System.out.println("[" + i + "] " + specializations[i]);
            System.out.println("~~~~~~~~~~~~~");
            for (Reservatoin reservatoin : reservations[i])
                System.out.println(reservatoin);
        }
    }

    /**
     * Description:
     * getNextPatient method uses for taking Specialization id then pop reservation or patient from the top of
     * the reservation queue of this specialization and return this reservation
     *
     * @exception
     * it also handel some cases if this Specialization is already has no reservation and also
     * if user input invalid input
     */
    private void getNextPatient() {
        displaySpecializations();
        System.out.println("[-1] Back to Menu");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int choice;
        while (true) {
            try {
                while (true) {
                    System.out.print("Choice [0-->3]: ");
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();          //get choice from user

                    if (choice < -1 || choice > 19) {       //if input isn't valid
                        System.out.println("Invalid Input, you choice should be from -1 to 19");
                    }
                    else
                        break;
                }

                break;
            }
            catch (Exception e) {           //if input isn't integer will throw this exception
                System.out.println(e + ", Invalid Input, please try again");
            }
        }
        if (choice != -1) {     //if choice is -1 that means he wants to cancel and back to menu
            if (reservations[choice].isEmpty()) {   //if this Specialization hasn't any reservations
                System.out.println(specializations[choice] + " has no patients");
            }
            else {
                //remove reservation from the top of dequeue and return it
                System.out.println(reservations[choice].pop());
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * run method it's the function which we use to run system so in this function we call `menu` method
     * and based on user choice we take action
     */
    public void run() {
        int choice = menu();        //show menu and take choice from user

        switch (choice) {
            case 0:
                addPatient();
                break;
            case 1:
                displayPatients();
                break;
            case 2:
                getNextPatient();
                break;
            case -1:
                System.exit(0);
        }
    }
}
