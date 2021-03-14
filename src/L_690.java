import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_690 {
// Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public static void main(String[] args) {

    }


//    public int getImportance(List<Employee> employees, int id) {
//
//        Map<Integer, Employee> map = new HashMap<>();
//        for (Employee employee : employees) {
//            map.put(employee.id, employee);
//        }
//
//        return method(map, id);
//
//    }
//
//    public int method(Map<Integer, Employee> map, int id) {
//        Employee emp = map.get(id);
//        int sum = emp.importance;
//        for (Integer integer : emp.subordinates) {
//            sum += method(map, integer);
//        }
//
//        return sum;
//    }
}
