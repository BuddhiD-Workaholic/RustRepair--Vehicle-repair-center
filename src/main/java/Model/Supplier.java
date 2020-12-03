package Model;

public class Supplier {

    private int supplierID;
    private String supplierName;
    private String Email;
    private String Address;

    public Supplier(int supplierID, String supplierName, String Address, String Email) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.Address = Address;
        this.Email=Email;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

}
