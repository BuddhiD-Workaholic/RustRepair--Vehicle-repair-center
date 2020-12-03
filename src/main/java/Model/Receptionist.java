package Model;

public class Receptionist extends Employee {

    private String receptionistID;

    public Receptionist(String receptionistID, String empID, String empName, String address, float payrate, String Email, String DOB) {
        super(empID, empName, address, payrate, Email, DOB);
        this.receptionistID = receptionistID;
    }
    
    public String getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }


}
