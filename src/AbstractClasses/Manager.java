package src.AbstractClasses;

class Manager implements Employee {
    private final double fixedSalary;
    private final double bonus;

    public Manager(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        this.bonus = Math.random() * (140_000 - 115_000) + 115_000;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + 0.05 * bonus;
    }
}
