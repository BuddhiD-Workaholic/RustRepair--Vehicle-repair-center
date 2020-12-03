package Model;

import java.util.Date;

public class VehicleJob {

    private int jobID;
    float servicecharge;
    private Date startDate;
    private Date dueDate;
    private String JobType;
    private float jobFees;

    public VehicleJob(int jobID, Date startDate, Date dueDate, String type, float fees, float servicecharge) {
        this.jobID = jobID;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.JobType = type;
        this.servicecharge = servicecharge;
    }

    public float getServicecharge() {
        return servicecharge;
    }

    public void setServicecharge(float servicecharge) {
        this.servicecharge = servicecharge;
    }

    public double calculateCost() {
        return 0.01;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String JobType) {
        this.JobType = JobType;
    }

    public float getJobFees() {
        return jobFees;
    }

    public void setJobFees(float jobFees) {
        this.jobFees = jobFees;
    }
}
