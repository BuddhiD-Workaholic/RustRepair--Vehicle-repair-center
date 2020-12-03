package Model;

import java.util.Date;

public class Manager extends Employee {

    private String managerID;

    public Manager(String managerID, String empID, String empName, String address, float payrate, String Email, String DOB) {
        super(empID, empName, address, payrate, Email, DOB);
        this.managerID = managerID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

}
