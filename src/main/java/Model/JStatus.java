
package Model;


public class JStatus {
    
    private int MechanicID;
    private int JobID;
    private String Status;
    private float Extraservice_charges;

    public JStatus(int MechanicID, int JobID, String Status, float Extraservice_charges) {
        this.MechanicID = MechanicID;
        this.JobID = JobID;
        this.Status = Status;
        this.Extraservice_charges = Extraservice_charges;
    }

    public int getMechanicID() {
        return MechanicID;
    }

    public void setMechanicID(int MechanicID) {
        this.MechanicID = MechanicID;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public float getExtraservice_charges() {
        return Extraservice_charges;
    }

    public void setExtraservice_charges(float Extraservice_charges) {
        this.Extraservice_charges = Extraservice_charges;
    }
}
