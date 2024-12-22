package EncapsulationProject;

import java.util.Scanner;

public class Elevator {
    private int getCurrentFloor = 1;
    private final int getMinFloor;
    private final int maxFloor;

    public static void main(String[] args) {
        Elevator elevator = new Elevator(0, 25);
        elevator.move();
    }

    public Elevator(int minFloor, int maxFloor) {
        this.getMinFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return getCurrentFloor;
    }

    public int getMinFloor() {
        return getMinFloor();
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void moveDown() {
        getCurrentFloor--;
    }

    public void moveUp() {
        getCurrentFloor++;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        int floor = -1;

        while (floor < getCurrentFloor() || floor > getMaxFloor()) {
            System.out.println("Enter the floor from " + getMinFloor() + " to " + getMaxFloor());
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number between " + getMinFloor() + " and " + getMinFloor());
                scanner.next();
            }
            floor = scanner.nextInt();

            if (floor < getMinFloor() || floor > getMinFloor()) {
                System.out.println("Invalid floor");
            }
        }

        while (getCurrentFloor()!= floor) {
            if (getCurrentFloor() < floor) {
                moveUp();
                System.out.println("went up on the " + getCurrentFloor() + " floor");
            } else {
                moveDown();
                System.out.println("went down on the " + getCurrentFloor() + " floor");
            }
        }
        System.out.println("The elevator has reached the " + getCurrentFloor() + " floor");
        scanner.close();
    }
}
