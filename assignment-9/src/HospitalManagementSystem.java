// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class: BasePatient (renamed to avoid duplicate "Patient")
abstract class BasePatient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String[] records = new String[10];
    private int recordCount = 0;

    public BasePatient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Encapsulation: Getters and Setters
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }

    // Interface methods
    @Override
    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        }
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (int i = 0; i < recordCount; i++) {
            System.out.println("- " + records[i]);
        }
    }
}

// Subclass: InPatient
class InPatient extends BasePatient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
}

// Subclass: OutPatient
class OutPatient extends BasePatient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// ✅ Public class for main method
public class HospitalManagementSystem {
    public static void main(String[] args) {
        BasePatient p1 = new InPatient(101, "Shobhit", 25, "Appendicitis", 3, 2000);
        BasePatient p2 = new OutPatient(102, "Harshit", 30, "Migraine", 500);

        p1.addRecord("Admitted for surgery");
        p1.addRecord("Surgery successful");
        p2.addRecord("Prescribed medication");

        System.out.println("🏥 In-Patient Details:");
        p1.getPatientDetails();
        p1.viewRecords();
        System.out.println("Bill: ₹" + p1.calculateBill());

        System.out.println("\n🏥 Out-Patient Details:");
        p2.getPatientDetails();
        p2.viewRecords();
        System.out.println("Bill: ₹" + p2.calculateBill());
    }
}