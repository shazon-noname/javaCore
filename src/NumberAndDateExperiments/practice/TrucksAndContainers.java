package src.NumberAndDateExperiments.practice;

import java.util.Scanner;

public class TrucksAndContainers {
    public static void main(String[] args) {
        firstCalculateMethod();
//        secondCalculateMethod();
    }

    private static void secondCalculateMethod() {
        int boxes = getBoxes();

        final int CONTAINERS_PER_TRUCK = 12;
        final int BOXES_PER_CONTAINER = 27;

        int totalContainers = (int) Math.ceil((double) boxes / BOXES_PER_CONTAINER);
        int totalTrucks = (int) Math.ceil((double) boxes / CONTAINERS_PER_TRUCK);

        int numberBox = 1;

        for (int truck = 1; truck <= totalTrucks; truck++) {
            if (numberBox > boxes) break;
            System.out.println("Truck " + truck);

            for (int container = 1; container <= CONTAINERS_PER_TRUCK; container++) {
                if (numberBox > boxes) break;
                System.out.println("\tContainer " + container);

                for (int box = 1; box <= BOXES_PER_CONTAINER; box++) {
                    if (numberBox > boxes) break;
                    System.out.println("\t\tBox number " + numberBox++);
                }
            }
        }
        System.out.println("Need: " );
        System.out.println("Trucks - " + totalTrucks);
        System.out.println("Containers - " + totalContainers);
    }

    private static void firstCalculateMethod() {
        int boxes = getBoxes();

        final int CONTAINERS_PER_TRUCK = 12;
        final int BOXES_PER_CONTAINER = 27;

        int boxNumber = 1;
        int containerCount = 0;
        int truckCount = 0;

        while (boxes >= boxNumber) {
            if (containerCount % CONTAINERS_PER_TRUCK == 0) {
                truckCount++;
                System.out.println("Trucks " + truckCount);
            }

            containerCount++;
            System.out.println("\t Containers " + containerCount);

            for (int box = 1; box <= BOXES_PER_CONTAINER; box++) {
                if (boxNumber > boxes) {
                    break;
                }
                System.out.println("\t\tBox Number " + boxNumber++);
            }
        }
        System.out.println("Need: " );
        System.out.println("Trucks - " + truckCount);
        System.out.println("Containers - " + containerCount);
    }

    private static int getBoxes() {
        Scanner scanner = new Scanner(System.in);

        int boxes = scanner.nextInt();
        scanner.close();

        return boxes;
    }

}
