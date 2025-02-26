package Storage;

import java.util.HashMap;

public class Mapping {
    public static HashMap<Integer, Integer> getEmployeeDepartmentMap() {
        return Storage.employeeDepartmentMap;
    }

    public static void assign(int employeeID, int departmentID) {
        Storage.employeeDepartmentMap.put(employeeID, departmentID);
    }
}
