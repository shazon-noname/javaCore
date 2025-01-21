package AbstractClasses;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.setIncome(12000000);

        // Hire employees
        for (int i = 0; i < 180; i++) company.hire(new Operator(40000));
        for (int i = 0; i < 80; i++) company.hire(new Manager(50000, company.getIncome()));
        for (int i = 0; i < 10; i++) company.hire(new TopManager(70000, company.getIncome()));

        // Print top 10 salaries
        System.out.println("Top 10 Salaries:");
        company.getTopSalaryStaff(10).forEach(e -> System.out.println(e.getMonthSalary()));

        // Print lowest 30 salaries
        System.out.println("Lowest 30 Salaries:");
        company.getLowestSalaryStaff(30).forEach(e -> System.out.println(e.getMonthSalary()));

        // Fire half of the employees
        company.fire(company.getTopSalaryStaff(50).get(0));

        // Print top 10 salaries again
        System.out.println("Top 10 Salaries after firing:");
        company.getTopSalaryStaff(10).forEach(e -> System.out.println(e.getMonthSalary()));

        // Print lowest 30 salaries again
        System.out.println("Lowest 30 Salaries after firing:");
        company.getLowestSalaryStaff(30).forEach(e -> System.out.println(e.getMonthSalary()));
    }
}
