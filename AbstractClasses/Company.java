package AbstractClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class Company {
    private final List<Employee> employees = new ArrayList<>();
    private double income;

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort((e1, e2) -> Double.compare(e2.getMonthSalary(), e1.getMonthSalary()));
        return employees.subList(0, Math.min(count, employees.size()));
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        return employees.subList(0, Math.min(count, employees.size()));
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
