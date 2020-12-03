package Model;

public class Parts {

    private int partsID;
    private String partName;
    private int SupplierID;
    private int quantity;
    private float price;

    public Parts(int partsID, String partName, int SID,int quantity, float price) {
        this.partsID = partsID;
        this.partName = partName;
        this.SupplierID=SID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPartsID() {
        return partsID;
    }

    public void setPartsID(int partsID) {
        this.partsID = partsID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
