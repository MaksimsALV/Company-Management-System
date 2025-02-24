package Commit;

import Interface.Interface;
import Storage.Departments;
import Storage.Employees;
import Storage.Mapping;

import java.util.Scanner;

public class AddEmployee {
    public static void addEmployee() {
        Scanner ae = new Scanner(System.in);

        //here we put employee into our employee DB
        System.out.println("Enter Employee name");
        System.out.print("Input: ");
        String employeeName = ae.nextLine();

        System.out.println("Enter Employee ID");
        System.out.print("Input: ");
        int employeeID = ae.nextInt();

        Employees.getEmployees().put(employeeID, employeeName);

        //here we are getting the departments list from department DB in preparation to merging within employeeDepartmentMap DB
        System.out.println("Assign Employee to Department by typing number");
        Departments.getDepartments().forEach((departmentID, departmentName) ->
                System.out.println(departmentID + "." + departmentName)
        );
        System.out.print("Input: ");
        int assign = ae.nextInt();

        //here we are .putting our employee into employeeDepartmentMap DB by calling .assign() method from Mapping class and storing employeeID AND departmentID into selected department via int assign = ae.nextInt();
        Mapping.assign(employeeID, assign);
        String departmentName = Departments.getDepartments().get(assign); //retrieves department names, using assigned ID by ID understands departmentName...
        System.out.println(employeeName + " is assigned to selected department: " + departmentName);

        System.out.println("Add more? 1=yes | 0=no");
        System.out.print("Input: ");
        int choice = ae.nextInt();
        ae.nextLine();
        if (choice == 1) {
            addEmployee();
        }
        if (choice == 0) {
            Interface.mainMenu();
        }
    }
}
