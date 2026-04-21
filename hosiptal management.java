import java.util.Scanner;

interface HospitalOperations {
    void showRole();
}

class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

class Doctor extends Person implements HospitalOperations {
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public void showRole() {
        System.out.println("Role: Doctor");
    }

    public void display() {
        super.display();
        showRole();
        System.out.println("Specialization: " + specialization);
    }
}

class Patient extends Person implements HospitalOperations {
    private String disease;

    public Patient(int id, String name, String disease) {
        super(id, name);
        this.disease = disease;
    }

    public void showRole() {
        System.out.println("Role: Patient");
    }

    public void display() {
        super.display();
        showRole();
        System.out.println("Disease: " + disease);
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Doctor");
        System.out.println("2. Patient");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        Person p;

        if (choice == 1) {
            System.out.print("Enter Specialization: ");
            String spec = sc.nextLine();
            p = new Doctor(id, name, spec);
        } else {
            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();
            p = new Patient(id, name, disease);
        }

        System.out.println("\n--- Details ---");
        p.display();

        ((HospitalOperations) p).showRole();

        sc.close();
    }
}