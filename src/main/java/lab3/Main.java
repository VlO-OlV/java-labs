package lab3;

import java.util.Arrays;

/**
 * Demonstrates sorting and binary search on an array of {@link Car} objects.
 *
 * <p>The program creates an array of cars, prints it, sorts the array first by
 * year (ascending) and then by price (descending) for cars of the same year,
 * and finally performs a custom binary search for a specific car.</p>
 *
 * @author Ivan Linichenko IP_31
 * @version 1.0
 * @since 2025-12-05
 */
public class Main {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Car[] cars = new Car[6];

        cars[0] = new Car("Toyota Camry", 2020, 25000, 2.5, BodyType.SEDAN);
        cars[1] = new Car("BMW X5", 2022, 65000, 3.0, BodyType.SUV);
        cars[2] = new Car("Honda Civic", 2019, 18000, 1.8, BodyType.SEDAN);
        cars[3] = new Car("Audi A5", 2021, 42000, 2.0, BodyType.COUPE);
        cars[4] = new Car("Kia Sportage", 2023, 32000, 2.4, BodyType.SUV);
        cars[5] = new Car("Mercedes SL-Class", 2020, 48000, 2.0, BodyType.COUPE);

        System.out.println("Initial array:");
        printCars(cars);

        sortCars(cars);
        System.out.println("\nArray sorted by year (asc) and price (desc):");
        printCars(cars);

        Car targetCar = new Car("Audi A5", 2021, 42000, 2.0, BodyType.COUPE);
        System.out.println("\nSearching car: " + targetCar);
        int targetIndex = carBinarySearch(cars, targetCar);
        System.out.println(targetIndex > -1 ? "Found car at index: " + targetIndex
                : "Car not found");
    }

    /**
     * Prints all cars in the given array, one per line, using each car's
     * {@link Car#toString()} representation.
     *
     * @param cars the array of cars to print
     */
    public static void printCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    /**
     * Sorts the array of cars using Bubble Sort.
     * Primary key: year of manufacture (ascending).
     * Secondary key (for equal years): price (descending).
     *
     * @param cars the array to be sorted in-place
     */
    public static void sortCars(Car[] cars) {
        for (int i = 0; i < cars.length - 1; i++) {
            for (int j = 0; j < cars.length - i - 1; j++) {
                int yearComparison = Integer.compare(cars[j].getYear(), cars[j + 1].getYear());
                if (yearComparison > 0 ||
                        (yearComparison == 0 && cars[j].getPrice() < cars[j + 1].getPrice())) {
                    Car temp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Performs a recursive binary search for the target car in a <strong>sorted</strong> array.
     * The array must be sorted by year (ascending) and within the same year by price (descending).
     *
     * @param cars       the sorted array of cars
     * @param targetCar  the car to search for
     * @return           the index of the found car, or -1 if not present
     */
    public static int carBinarySearch(Car[] cars, Car targetCar) {
        if (cars.length == 0) return -1;
        if (cars.length == 1) {
            return cars[0].equals(targetCar) ? 0 : -1;
        }

        int pivot = cars.length / 2;
        Car pivotCar = cars[pivot];

        int yearComp = Integer.compare(pivotCar.getYear(), targetCar.getYear());

        if (yearComp > 0) {
            // Target is in the left half
            int found = carBinarySearch(Arrays.copyOfRange(cars, 0, pivot), targetCar);
            return found;
        } else if (yearComp < 0) {
            // Target is in the right half
            int found = carBinarySearch(Arrays.copyOfRange(cars, pivot + 1, cars.length), targetCar);
            return found >= 0 ? pivot + 1 + found : -1;
        } else {
            // Same year → compare price (descending order)
            if (Double.compare(pivotCar.getPrice(), targetCar.getPrice()) < 0) {
                // Target price is higher → look left
                int found = carBinarySearch(Arrays.copyOfRange(cars, 0, pivot), targetCar);
                return found;
            } else {
                // Look right (including pivot)
                int found = carBinarySearch(Arrays.copyOfRange(cars, pivot, cars.length), targetCar);
                return found >= 0 ? pivot + found : -1;
            }
        }
    }
}