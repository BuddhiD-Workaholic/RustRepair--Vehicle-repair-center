package Model;


public class Employee {

    private String empID;
    private String empName;
    private String address;
    private String DOB;
    private String Email;
    private float payrate;

    public Employee(String empID, String empName, String address,float payrate,  String Email, String DOB ) {
        this.empID = empID;
        this.empName = empName;
        this.address = address;
        this.DOB = DOB;
        this.Email = Email;
        this.payrate = payrate;
    }

    public float getPayrate() {
        return payrate;
    }

    public void setPayrate(float payrate) {
        this.payrate = payrate;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
