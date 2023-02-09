package hospitalsystem;

/**
 * @author Mahmoud Gadallah
 */
public class Reservatoin {
    String patientName;
    String specialization;

    /**
     * default constructor
     */
    public Reservatoin(){}

    /**
     * parameterized constructor
     * @param patientName
     * @param specialization
     */
    public Reservatoin(String patientName, String specialization) {
        this.patientName = patientName;
        this.specialization = specialization;
    }

    /**
     * setPatientName used to set value of patientName attribute
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * setSpecialization used to set specialization attribute
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * getPatientName it used to get value of patientName
     * @return patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * getSpecialization it used to get value of specialization
     * @return specialization
     */

    public String getSpecialization() {
        return specialization;
    }

    /**
     *  Returns a string representation of the Reservation object.
     * @return a string representation of the Reservation object.
     */
    @Override
    public String toString() {
        return "Reservatoin{" +
                "patientName='" + patientName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
