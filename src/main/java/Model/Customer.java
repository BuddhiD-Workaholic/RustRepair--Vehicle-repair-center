package Model;

public class Customer {

    private int customerID;
    private String Name;
    private String NIC;
    private String address;
    private String Email;

    public Customer(int customerID,String name, String NIC,String Email, String address) {
        this.customerID = customerID;
        this.Name=name;
        this.NIC = NIC;
        this.address = address;
        this.Email = Email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
