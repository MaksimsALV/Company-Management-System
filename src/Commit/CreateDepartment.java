package Commit;

import Storage.Departments;
import Interface.Interface;

import java.util.Scanner;

public class CreateDepartment {
    public static void createDepartment() {
        Scanner cd = new Scanner(System.in);

        System.out.println("Enter Department name");
        System.out.print("Input: ");
        String departmentName = cd.nextLine();

        int departmentID = Departments.getDepartments().size() + 1; //start adding values from 1.
        Departments.getDepartments().put(departmentID, departmentName);
        System.out.println(departmentName + " is added to the Company");

        System.out.println("Add more? 1=yes | 0=no");
        System.out.print("Input: ");
        int choice = cd.nextInt();
        if (choice == 1) {
            createDepartment();
        }
        if (choice == 0) {
            Interface.mainMenu();
        }
    }
}
