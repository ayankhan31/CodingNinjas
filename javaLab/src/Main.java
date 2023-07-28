import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Member {
    String name;
    int age;
    String phone;
    String address;
    double salary;

    public Member(String name, int age, String phone, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }
}

class Employee extends Member {
    String specialization;

    public Employee(String name, int age, String phone, String address, double salary, String specialization) {
        super(name, age, phone, address, salary);
        this.specialization = specialization;
    }
}

class Manager extends Member {
    String department;

    public Manager(String name, int age, String phone, String address, double salary, String department) {
        super(name, age, phone, address, salary);
        this.department = department;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Member[] members = new Member[2];

        for (int i = 0; i < members.length; i++) {
            System.out.println("Enter member details: ");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            if (i == 0) {
                System.out.print("Specialization: ");
                String specialization = scanner.nextLine();
                members[i] = new Employee(name, age, phone, address, salary, specialization);
            } else {
                System.out.print("Department: ");
                String department = scanner.nextLine();
                members[i] = new Manager(name, age, phone, address, salary, department);
            }
        }

        Arrays.sort(members, Comparator.comparingDouble(member -> member.salary));

        System.out.println("Members sorted by salary:");
        for (Member member : members) {
            System.out.println("Name: " + member.name);
            System.out.println("Age: " + member.age);
            System.out.println("Phone: " + member.phone);
            System.out.println("Address: " + member.address);
            member.printSalary();

            if (member instanceof Employee) {
                System.out.println("Specialization: " + ((Employee) member).specialization);
            } else if (member instanceof Manager) {
                System.out.println("Department: " + ((Manager) member).department);
            }

            System.out.println();
        }
    }
}
