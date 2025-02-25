package Commit;

import Storage.Departments;
import Interface.Interface;
import java.util.Scanner;

public class AddDepartment {
    public static void addDepartment() {
        Scanner cd = new Scanner(System.in);

        System.out.println("Enter Department name");
        System.out.print("Input: ");
        String departmentName = cd.nextLine();

        int departmentID = Departments.getDepartments().size() + 1; //start adding values from 1.
        Departments.getDepartments().put(departmentID, departmentName);
        System.out.println(departmentName + " is added to the Company");

        while (true) {
            try {
                System.out.println("\n1. Add more departments");
                System.out.println("0. Return back to main menu");
                System.out.print("Input: ");
                int choice = Integer.parseInt(cd.nextLine()); //need to parse else entering Strings brick whole process
                if (choice == 1) {
                    addDepartment();
                    return; //clean relaunch of method. closes previous method opens new one.
                }
                if (choice == 0) {
                    Interface.mainMenu();
                    return;
                }
                System.out.println("Only 1 or 0 is allowed here!");

            } catch (NumberFormatException inputValidation) {
                System.out.println("Only numbers are allowed here!");
            }
        }
    }
}
