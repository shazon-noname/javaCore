package AbstractClasses;

class TopManager implements Employee {
    private final double fixedSalary;
    private final double companyIncome;

    public TopManager(double fixedSalary, double companyIncome) {
        this.fixedSalary = fixedSalary;
        this.companyIncome = companyIncome;
    }

    @Override
    public double getMonthSalary() {
        return companyIncome > 10000000 ? fixedSalary + 1.5 * fixedSalary : fixedSalary;
    }
}
