package AbstractClasses;

class Manager implements Employee {
    private final double fixedSalary;
    private final double companyIncome;

    public Manager(double fixedSalary, double companyIncome) {
        this.fixedSalary = fixedSalary;
        this.companyIncome = companyIncome;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + 0.05 * companyIncome;
    }
}
