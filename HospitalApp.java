import java.util.Scanner;

// Patient Class
class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Disease    : " + disease);
    }
}


// Doctor Class
class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("\n--- Doctor Details ---");
        System.out.println("Doctor ID      : " + id);
        System.out.println("Doctor Name    : " + name);
        System.out.println("Specialization : " + specialization);
    }
}


// Appointment Class
class Appointment {
    int id;
    Patient patient;
    Doctor doctor;
    String date;

    Appointment(int id, Patient patient, Doctor doctor, String date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    void display() {
        System.out.println("\n--- Appointment Details ---");
        System.out.println("Appointment ID : " + id);
        System.out.println("Patient        : " + patient.name);
        System.out.println("Doctor         : " + doctor.name);
        System.out.println("Date           : " + date);
    }
}


// Hospital Class
class Hospital {

    Patient patient;
    Doctor doctor;
    Appointment appointment;

    void registerPatient(Patient p) {
        patient = p;
        System.out.println("\nPatient registered successfully!");
    }

    void addDoctor(Doctor d) {
        doctor = d;
        System.out.println("\nDoctor added successfully!");
    }

    void bookAppointment(Appointment a) {
        appointment = a;
        System.out.println("\nAppointment booked successfully!");
    }

    void showPatient() {
        if (patient != null) {
            patient.display();
        } else {
            System.out.println("\nNo patient registered.");
        }
    }

    void showDoctor() {
        if (doctor != null) {
            doctor.display();
        } else {
            System.out.println("\nNo doctor registered.");
        }
    }

    void showAppointment() {
        if (appointment != null) {
            appointment.display();
        } else {
            System.out.println("\nNo appointment booked.");
        }
    }

    void displayAll() {
        System.out.println("\n================================");
        System.out.println("       HOSPITAL DETAILS");
        System.out.println("================================");

        showPatient();
        showDoctor();
        showAppointment();
    }
}


// Main Class
public class HospitalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hospital hospital = new Hospital();

        int choice;

        do {

            System.out.println("\n\n================================");
            System.out.println("    HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patient Details");
            System.out.println("5. View Doctor Details");
            System.out.println("6. View Appointment");
            System.out.println("7. View All Details");
            System.out.println("8. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

                case 1:

                    System.out.println("\n===== PATIENT REGISTRATION =====");

                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Patient Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    Patient p = new Patient(
                            patientId,
                            patientName,
                            age,
                            disease
                    );

                    hospital.registerPatient(p);

                    break;


                case 2:

                    System.out.println("\n===== DOCTOR REGISTRATION =====");

                    System.out.print("Enter Doctor ID: ");
                    int doctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    Doctor d = new Doctor(
                            doctorId,
                            doctorName,
                            specialization
                    );

                    hospital.addDoctor(d);

                    break;


                case 3:

                    if (hospital.patient == null) {
                        System.out.println("\nPlease register a patient first.");
                        break;
                    }

                    if (hospital.doctor == null) {
                        System.out.println("\nPlease add a doctor first.");
                        break;
                    }

                    System.out.println("\n===== BOOK APPOINTMENT =====");

                    System.out.print("Enter Appointment ID: ");
                    int appointmentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Appointment Date: ");
                    String date = sc.nextLine();

                    Appointment a = new Appointment(
                            appointmentId,
                            hospital.patient,
                            hospital.doctor,
                            date
                    );

                    hospital.bookAppointment(a);

                    break;


                case 4:

                    hospital.showPatient();

                    break;


                case 5:

                    hospital.showDoctor();

                    break;


                case 6:

                    hospital.showAppointment();

                    break;


                case 7:

                    hospital.displayAll();

                    break;


                case 8:

                    System.out.println("\nThank you for using Hospital Management System!");

                    break;


                default:

                    System.out.println("\nInvalid choice! Please enter 1 to 8.");
            }

        } while (choice != 8);

        sc.close();
    }
}
