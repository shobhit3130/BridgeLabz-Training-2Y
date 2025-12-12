import java.util.*;

public class HospitalApp {

    // Patient class
    static class Patient {
        private String name;
        private List<Doctor> consultedDoctors;

        public Patient(String name) {
            this.name = name;
            this.consultedDoctors = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addDoctor(Doctor doctor) {
            if (!consultedDoctors.contains(doctor)) {
                consultedDoctors.add(doctor);
            }
        }

        public void viewDoctors() {
            System.out.println("Patient: " + name + " has consulted:");
            for (Doctor doc : consultedDoctors) {
                System.out.println("  - Dr. " + doc.getName());
            }
        }
    }

    // Doctor class
    static class Doctor {
        private String name;
        private String specialty;
        private List<Patient> patients;

        public Doctor(String name, String specialty) {
            this.name = name;
            this.specialty = specialty;
            this.patients = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void consult(Patient patient) {
            System.out.println("Dr. " + name + " (" + specialty + ") is consulting patient " + patient.getName());
            if (!patients.contains(patient)) {
                patients.add(patient);
                patient.addDoctor(this); // maintain bidirectional association
            }
        }

        public void viewPatients() {
            System.out.println("Dr. " + name + " has consulted:");
            for (Patient p : patients) {
                System.out.println("  - " + p.getName());
            }
        }
    }

    // Hospital class
    static class Hospital {
        private String name;
        private List<Doctor> doctors;
        private List<Patient> patients;

        public Hospital(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
            this.patients = new ArrayList<>();
        }

        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public void showStaffAndPatients() {
            System.out.println("Hospital: " + name);
            System.out.println("Doctors:");
            for (Doctor doc : doctors) {
                System.out.println("  - Dr. " + doc.getName() + " (" + doc.specialty + ")");
            }
            System.out.println("Patients:");
            for (Patient pat : patients) {
                System.out.println("  - " + pat.getName());
            }
        }
    }

    // Main method to demonstrate association and communication
    public static void main(String[] args) {
        Hospital cityHospital = new Hospital("City Hospital");

        Doctor drSmith = new Doctor("Smith", "Cardiology");
        Doctor drLee = new Doctor("Lee", "Neurology");

        Patient john = new Patient("John");
        Patient emma = new Patient("Emma");

        cityHospital.addDoctor(drSmith);
        cityHospital.addDoctor(drLee);
        cityHospital.addPatient(john);
        cityHospital.addPatient(emma);

        // Consultations (communication + association)
        drSmith.consult(john);
        drSmith.consult(emma);
        drLee.consult(john);

        // Display hospital structure
        System.out.println();
        cityHospital.showStaffAndPatients();

        System.out.println();
        drSmith.viewPatients();
        drLee.viewPatients();

        System.out.println();
        john.viewDoctors();
        emma.viewDoctors();
    }
}