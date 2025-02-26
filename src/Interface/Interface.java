package Interface;

import Commit.AddDepartment;
import Commit.AddEmployee;
import Storage.Departments;
import Storage.Employees;
import Storage.Mapping;

import java.util.Scanner;

public class Interface {
    public static void mainMenu() {
        Scanner mms = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nWelcome to the Main Menu");
                System.out.println("1. Add Department");
                System.out.println("2. Add Employee to the Department");
                System.out.println("3. Display Company Structure");
                System.out.println("0. Exit");
                System.out.print("Input: ");

                int choice = Integer.parseInt(mms.nextLine()); //need to parse else entering Strings brick whole process

                if (choice == 1) {
                    AddDepartment.addDepartment();
                    return; //clean relaunch of method. closes previous one and opens new one.
                }
                if (choice == 2) {
                    AddEmployee.addEmployee();
                    return; //clean relaunch of method. closes previous one and opens new one.
                }
                if (choice == 3) {
                    viewCompanyStructure();
                    return; //clean relaunch of method. closes previous one and opens new one.
                }
                if (choice == 0) {
                    System.exit(0);
                }
                System.out.println("ERROR: Invalid input (Only mentioned numerical choices allowed here!)");

            } catch (NumberFormatException inputValidation) {
                System.out.println("ERROR: Invalid input (Only numbers are allowed here!)");
            }
        }
    }


    public static void viewCompanyStructure() {
        Scanner vcs = new Scanner(System.in);

        if (Departments.getDepartments().isEmpty()) {
            System.out.println("This company has no departments, type 0 to return back to the main menu");
        } else {
            System.out.println("Welcome to the Display Company Structure");
            System.out.println("This is our Company Structure:");
            System.out.println("Departments");
            System.out.println("-----------------------");


            /* 1. I call departments via getDepartments and return departmentID and departmentName in BE
               2. Then I only print out departmentName in FE
               3. Then I call employeeDepartmentMap list via getEmployeeDepartmentMap and return mappingEmployeeName and mappingDepartmentID in BE in preparation of matching validation
               4. I proceed with matching validation, if mappingDepartmentID equals departmentID(from getDepartments) then all good, and then I print employee assigned to own department
             */
            Departments.getDepartments().forEach((departmentID, departmentName) -> {
                System.out.println(departmentName);
                Mapping.getEmployeeDepartmentMap().forEach((mappingEmployeeName, mappingDepartmentID) -> {
                    if (mappingDepartmentID.equals(departmentID)) {
                        System.out.println(Employees.getEmployees().get(mappingEmployeeName));
                    }
                });
                System.out.println("-----------------------");
            });
            System.out.println("Type 0 to return back to the main menu");
        }

        while (true) {
            try {
                System.out.print("Input: ");
                int choice = Integer.parseInt(vcs.nextLine()); //need to parse else entering Strings brick whole process
                if (choice == 0) {
                    Interface.mainMenu();
                    return; //to exit this method entirelly
                } else {
                    System.out.println("ERROR: Invalid input (Only 0 is allowed here!)");
                }
            } catch (NumberFormatException inputValidation) {
                System.out.println("ERROR: Invalid input (Only numbers are allowed here!)");
            }
        }
    }
}