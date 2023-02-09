import hospitalsystem.HospitalDriver;

/**
 * @author Mahmoud Gadallah
 */
public class Main {
    /**
     * @param args the command line argument -unused
     */
    public static void main(String[] args) {

        HospitalDriver hospital = new HospitalDriver();

        while (true) {      //keep running until user exit it
         hospital.run();
        }
    }
}