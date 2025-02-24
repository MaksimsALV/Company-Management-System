package Commit;

import Storage.Departments;
import Interface.Interface;
import java.util.Scanner;

//todo add validation to number imputs
public class AddDepartment {
    public static void addDepartment() {
        Scanner cd = new Scanner(System.in);

        System.out.println("Enter Department name");
        System.out.print("Input: ");
        String departmentName = cd.nextLine();

        int departmentID = Departments.getDepartments().size() + 1; //start adding values from 1.
        Departments.getDepartments().put(departmentID, departmentName);
        System.out.println(departmentName + " is added to the Company\n");
        System.out.println("1. Add more departments");
        System.out.println("0. Return back to main menu");
        System.out.print("Input: ");
        int choice = cd.nextInt();
        if (choice == 1) {
            addDepartment();
        }
        if (choice == 0) {
            Interface.mainMenu();
        }
    }
}
