package util;

import model.Employee;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Manager;

// Util methods to map users from MySQL database to User model classes
public class UserMappers {

    public static List<Manager> mapManagers(List<Map<String, Object>> resultList) {
        List<Manager> managers = new ArrayList<>();

        for (int i = 0; i < resultList.size(); i++) {
            managers.add(new Manager(Integer.parseInt(resultList.get(i).get("manager_id").toString()),
                    resultList.get(i).get("manager_fname").toString(),
                    resultList.get(i).get("manager_lname").toString(),
                    resultList.get(i).get("manager_phone").toString(),
                    resultList.get(i).get("manager_email").toString(),
                    resultList.get(i).get("manager_password").toString(),
                    Double.parseDouble(resultList.get(i).get("manager_salary").toString()),
                    Integer.parseInt(resultList.get(0).get("manager_ssn").toString()),
                    resultList.get(0).get("manager_address").toString(),
                    resultList.get(0).get("manager_city").toString(),
                    resultList.get(0).get("manager_state").toString()));
        }
        return managers;
    }

    public static List<Employee> mapEmployees(List<Map<String, Object>> resultList) {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < resultList.size(); i++) {
            employees.add(new Employee(Integer.parseInt(resultList.get(i).get("employee_id").toString()),
                    resultList.get(i).get("employee_fname").toString(),
                    resultList.get(i).get("employee_lname").toString(),
                    resultList.get(i).get("employee_phone").toString(),
                    resultList.get(i).get("employee_email").toString(),
                    resultList.get(i).get("employee_password").toString(),
                    Double.parseDouble(resultList.get(i).get("employee_salary").toString()),
                    Integer.parseInt(resultList.get(0).get("employee_ssn").toString()),
                    resultList.get(0).get("employee_address").toString(),
                    resultList.get(0).get("employee_city").toString(),
                    resultList.get(0).get("employee_state").toString()));
        }
        return employees;
    }

    public static List<Student> mapStudents(List<Map<String, Object>> resultList) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < resultList.size(); i++) {
            students.add(new Student(Integer.parseInt(resultList.get(i).get("student_id").toString()),
                    resultList.get(i).get("student_fname").toString(),
                    resultList.get(i).get("student_lname").toString(),
                    resultList.get(i).get("student_phone").toString(),
                    resultList.get(i).get("student_email").toString(),
                    resultList.get(i).get("student_password").toString(),
                    resultList.get(i).get("date_created").toString(),
                    Integer.parseInt(resultList.get(0).get("student_ssn").toString()),
                    resultList.get(0).get("student_address").toString(),
                    resultList.get(0).get("student_city").toString(),
                    resultList.get(0).get("student_state").toString()));
        }
        return students;
    }
}
