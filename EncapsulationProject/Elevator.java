package EncapsulationProject;

import java.util.Scanner;

public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public static void main(String[] args) {
        Elevator elevator = new Elevator(0, 25);
        elevator.move();
    }

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor--;
    }

    public void moveUp() {
        currentFloor++;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        int floor = -1;

        while (floor < currentFloor || floor > maxFloor) {
            System.out.println("Enter the floor from " + minFloor + " to " + maxFloor);
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number between " + minFloor + " and " + maxFloor);
                scanner.next();
            }
            floor = scanner.nextInt();

            if (floor < minFloor || floor > maxFloor) {
                System.out.println("Invalid floor");
            }
        }

        while (currentFloor != floor) {
            if (currentFloor < floor) {
                moveUp();
                System.out.println("went up on the " + currentFloor + " floor");
            } else {
                moveDown();
                System.out.println("went down on the " + currentFloor + " floor");
            }
        }
        System.out.println("The elevator has reached the " + currentFloor + " floor");
        scanner.close();
    }
}
