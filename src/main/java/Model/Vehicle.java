package Model;


public class Vehicle {

    private String VehicleNo;
    private String engineData;
    private String model;
    private int Cus_ID;
    private String manufactureDate;

    public Vehicle(String VehicleNo,String ModelName, String engineData, int Cus_ID, String manufactureDate) {
        this.VehicleNo = VehicleNo;
        this.engineData = engineData;
        this.model = ModelName;
        this.Cus_ID=Cus_ID;
        this.manufactureDate = manufactureDate;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String VehicleNo) {
        this.VehicleNo = VehicleNo;
    }

    public String getEngineData() {
        return engineData;
    }

    public void setEngineData(String engineData) {
        this.engineData = engineData;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(int Cus_ID) {
        this.Cus_ID = Cus_ID;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

}
