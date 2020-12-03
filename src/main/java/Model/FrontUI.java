package Model;

public class FrontUI {

    private String vehicleNo;
    private String ModelName;
    private String Engine_Details;
    private int Cus_ID;
    private String ManufactureDate;
    private int JobID;
    private String StartDate;
    private String DueDate;
    private String JobType;
    private String Details;
    private int MechanicID;
    private float ServiceCharger;

    public FrontUI(String vehicleNo, String ModelName, String Engine_Details, int Cus_ID, String ManufactureDate, int JobID, String StartDate, String DueDate, String JobType, String Details, int MechanicID, float ServiceCharger) {
        this.vehicleNo = vehicleNo;
        this.ModelName = ModelName;
        this.Engine_Details = Engine_Details;
        this.Cus_ID = Cus_ID;
        this.ManufactureDate = ManufactureDate;
        this.JobID = JobID;
        this.StartDate = StartDate;
        this.DueDate = DueDate;
        this.JobType = JobType;
        this.Details = Details;
        this.MechanicID = MechanicID;
        this.ServiceCharger = ServiceCharger;
    }

    public float getServiceCharger() {
        return ServiceCharger;
    }

    public void setServiceCharger(float ServiceCharger) {
        this.ServiceCharger = ServiceCharger;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getEngine_Details() {
        return Engine_Details;
    }

    public void setEngine_Details(String Engine_Details) {
        this.Engine_Details = Engine_Details;
    }

    public int getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(int Cus_ID) {
        this.Cus_ID = Cus_ID;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String JobType) {
        this.JobType = JobType;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public int getMechanicID() {
        return MechanicID;
    }

    public void setMechanicID(int MechanicID) {
        this.MechanicID = MechanicID;
    }

}
