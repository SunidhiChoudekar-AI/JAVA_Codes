import java.util.Scanner;

class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void DisplaySalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    void CalculateSalary() {
        System.out.println("\n--- Full Time Employee ---");
        System.out.println("Salary Before Hike:");
        DisplaySalary();

        salary = salary + (salary * 0.50);

        System.out.println("Salary After 50% Hike:");
        DisplaySalary();
    }
}

class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    void CalculateSalary() {
        System.out.println("\n--- Intern Employee ---");
        System.out.println("Salary Before Hike:");
        DisplaySalary();

        salary = salary + (salary * 0.25);

        System.out.println("Salary After 25% Hike:");
        DisplaySalary();
    }
}

public class Inheritance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String fname = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double fsalary = sc.nextDouble();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Employee 2 Name: ");
        String iname = sc.nextLine();

        System.out.print("Enter Employee 2 Salary: ");
        double isalary = sc.nextDouble();

        FullTimeEmployee f1 = new FullTimeEmployee(fname, fsalary);
        InternEmployee i1 = new InternEmployee(iname, isalary);

        f1.CalculateSalary();
        i1.CalculateSalary();

        sc.close();
    }
}