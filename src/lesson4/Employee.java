package lesson4;

public class Employee {
    String fullName;
    String jobTitle;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Employee(String fullName, String jobTitle, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployeeInfo () {
        System.out.println("ФИО : " + fullName);
        System.out.println("Должность : " + jobTitle);
        System.out.println("Email : " + email);
        System.out.println("Номер телефона : " + phoneNumber);
        System.out.println("Зарплата : " + salary);
        System.out.println("Возраст : " + age);
        System.out.println();
    }

    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        employeesArray[1] = new Employee("Employee2", "Job title 2",
                "Employee2@mail.box", "82222222222", 20000, 20);
        employeesArray[2] = new Employee("Employee3", "Job title 3",
                "Employee3@mail.box", "83333333333", 25000, 25);
        employeesArray[3] = new Employee("Employee4", "Job title 4",
                "Employee4@mail.box", "84444444444", 35000, 50);
        employeesArray[4] = new Employee("Employee5", "Job title 5",
                "Employee5@mail.box", "85555555555", 15000, 18);

        //Этого не было в дз, но я решил оставить для наглядности

        for (Employee employee : employeesArray) {
            employee.printEmployeeInfo();
        }
    }
}
