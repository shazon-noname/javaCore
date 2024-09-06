package DynamicProxyExample.testExample;

public class Car implements CarStructure {
    private int speed;

    public Car(int speed) {
        this.speed = speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed(int n) {
        try {
            if (n < 0) {
                throw new IllegalArgumentException("Збільшення швидкості не може бути від'ємним!");
            } else {
                setSpeed(speed + n);
                System.out.println("Швидкість успішно збільшена на " + n + "км/год!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    @Override
    public void reduceSpeed(int n) {
        try {
            if (speed < 0) {
                throw new IllegalArgumentException("Швидкость не може бути від'ємною!");
            } else if (n < 0) {
                throw new IllegalArgumentException("Зменшення швидкості не може бути від'ємним!");
            } else {
                setSpeed(speed - n);
                System.out.println("Швидкість успішно зменшена на " + n + "км/год!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    @Override
    public String displaySpeed() {
        return "Швидкість становить:" + speed + "км/год!" ;
    }
}
