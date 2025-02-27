package Commit;

import Interface.Interface;
import Storage.Departments;
import Storage.Employees;
import Storage.Mapping;
import java.util.Scanner;

//todo when there is no departments, then addEmployee shouldn't be available
//todo something bricks here, process exists
public class AddEmployee {
    public static void addEmployee() {
        Scanner ae = new Scanner(System.in);

        if (Departments.getDepartments().isEmpty()) {
            while (true) {
                try {
                System.out.println("\nERROR: No Departments (This company has no departments! Add Department first!");
                System.out.println("Type 0 to return back to the main menu");
                System.out.print("Input: ");
                int choice = Integer.parseInt(ae.nextLine()); //need to parse else entering Strings brick whole process
                if (choice == 0) {
                    Interface.mainMenu();
                    return;
                }
                System.out.println("ERROR: Invalid input (Only 0 is allowed here!)");

            } catch (NumberFormatException inputValidation) {
                    System.out.println("ERROR: Invalid input (Only numbers are allowed here!)");
                }
            }
        } else {
            //here we put employee into our employee DB if we have at least 1 department in
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
            ae.nextLine(); //starting new scanner line

            while (true) {
                try {
                    System.out.println("\n1. Add more employees");
                    System.out.println("0. Return back to main menu");
                    System.out.print("Input: ");

                    int choice = Integer.parseInt(ae.nextLine()); //need to parse else entering Strings brick whole process
                    if (choice == 1) {
                        addEmployee();
                        return; //clean relaunch of method. closes previous method opens new one.
                    }
                    if (choice == 0) {
                        Interface.mainMenu();
                        return;
                    }
                    System.out.println("ERROR: Invalid input (Only 1 or 0 is allowed here!)");

                } catch (NumberFormatException inputValidation) {
                    System.out.println("ERROR: Invalid input (Only numbers are allowed here!)");
                }
            }
        }
    }
}
