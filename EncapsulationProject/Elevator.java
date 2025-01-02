package EncapsulationProject;

import java.util.Scanner;

public class Elevator {
    private int currentFloor = 0;
    private final int minFloor;
    private final int maxFloor;

    public static void main() {
        Elevator elevator = new Elevator(-5, 25);
        elevator.move();
    }

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void moveDown() {
        currentFloor--;
    }

    public void moveUp() {
        currentFloor++;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        long floor;
        System.out.println("Enter the floor from " + getMinFloor() + " to " + getMaxFloor());
        floor = scanner.nextLong();
        while (floor < getMinFloor() || floor > getMaxFloor()) {
            System.out.println("Invalid floor");
            System.out.println("Enter the floor from " + getMinFloor() + " to " + getMaxFloor());
            floor = scanner.nextLong();
        }
        while (getCurrentFloor() != floor) {
            if (getCurrentFloor() < floor) {
                moveUp();
                System.out.println("went up on the " + getCurrentFloor() + " floor");
            } else {
                moveDown();
                System.out.println("went down on the " + getCurrentFloor() + " floor");
            }
        }
        System.out.println("    The elevator has reached the " + getCurrentFloor() + " floor");
        scanner.close();
    }
}
