package lab6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates the functionality of the {@link ToysList} class through various operations
 * such as adding, removing, iterating, and growing the list with different {@link Toy} instances.
 * <p>
 * This class creates sample toys (cars, balls, cubes), populates lists, performs insertions
 * and deletions, iterates over elements, and tests the list's dynamic resizing capability.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-13
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Car firstCar = new Car(10.0, AgeGroup.SCHOOL, ToySize.SMALL);
        Car secondCar = new Car(20.0, AgeGroup.PRESCHOOL, ToySize.LARGE);
        Car thirdCar = new Car(50.0, AgeGroup.ALL, ToySize.SMALL);
        Ball ball = new Ball(13.0, AgeGroup.TEEN, ToySize.LARGE);
        Cube cube = new Cube(18.0, AgeGroup.ALL, ToySize.MEDIUM);

        ToysList firstList = new ToysList();
        firstList.add(firstCar);
        firstList.add(secondCar);
        System.out.println("Size: " + firstList.size());
        System.out.println("First element: " + firstList.get(0));
        System.out.println("Second element: " + firstList.get(1));

        List<Toy> inputList = Arrays.asList(thirdCar, ball, cube);
        ToysList thirdList = new ToysList(inputList);
        System.out.println("Size: " + thirdList.size());
        for (Toy toy : thirdList) {
            System.out.println(toy);
        }

        thirdList.add(0, firstCar);
        System.out.println("Inserted at index 0: " + thirdList.get(0));
        thirdList.remove(1);
        System.out.println("Size after removal: " + thirdList.size());

        Iterator<Toy> iter = thirdList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        ToysList growList = new ToysList();
        for (int i = 0; i < 20; i++) {
            growList.add(new Ball(4.0, AgeGroup.BABY, ToySize.SMALL));
        }
        System.out.println("Size after expansion: " + growList.size());
    }
}