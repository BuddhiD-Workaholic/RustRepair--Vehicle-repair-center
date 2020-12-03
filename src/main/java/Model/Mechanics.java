package Model;
import java.util.Date;

public class Mechanics extends Employee {

    private String mechanicID;

    public Mechanics(String mechanicID, String empID, String empName, String address, float payrate, String Email, String DOB) {
        super(empID, empName, address, payrate, Email, DOB);
        this.mechanicID = mechanicID;
    }

    public String getMechanicID() {
        return mechanicID;
    }

    public void setMechanicID(String mechanicID) {
        this.mechanicID = mechanicID;
    }

}
