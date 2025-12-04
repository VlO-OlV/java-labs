package lab5;

import java.util.List;

/**
 * Demonstrates the playroom management system.
 * <p>
 * Creates a playroom with a fixed capacity and budget, adds various toys,
 * displays them, sorts by price, and searches within a price range.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int maxToys = 10;
        double budget = 500.0;

        Playroom playroom = new Playroom(maxToys, budget);

        // Adding various toys
        playroom.addToy(new Car(10.0, AgeGroup.SCHOOL, ToySize.SMALL));
        playroom.addToy(new Car(20.0, AgeGroup.PRESCHOOL, ToySize.LARGE));
        playroom.addToy(new Car(50.0, AgeGroup.ALL, ToySize.SMALL));
        playroom.addToy(new Car(15.0, AgeGroup.TEEN, ToySize.MEDIUM));
        playroom.addToy(new Doll(7.0, AgeGroup.SCHOOL, ToySize.SMALL));
        playroom.addToy(new Doll(12.0, AgeGroup.PRESCHOOL, ToySize.LARGE));
        playroom.addToy(new Ball(4.0, AgeGroup.BABY, ToySize.SMALL));
        playroom.addToy(new Ball(13.0, AgeGroup.TEEN, ToySize.LARGE));
        playroom.addToy(new Cube(9.0, AgeGroup.BABY, ToySize.LARGE));
        playroom.addToy(new Cube(18.0, AgeGroup.ALL, ToySize.MEDIUM));

        System.out.println("Toys in playroom:");
        playroom.displayToys();
        System.out.println("\nTotal price: " + playroom.getCurrentCost());

        playroom.sortByPrice();
        System.out.println("\nToys sorted by price:");
        playroom.displayToys();

        double min = 10.0;
        double max = 20.0;
        List<Toy> found = playroom.findByPriceRange(min, max);
        System.out.printf("\nToys in price range %.1f - %.1f:%n", min, max);
        for (Toy toy : found) {
            toy.describe();
        }
    }
}