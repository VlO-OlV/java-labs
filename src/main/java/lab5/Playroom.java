package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a playroom with a fixed maximum number of toys and a budget limit.
 * <p>
 * Toys can be added as long as there is space and sufficient funds.
 * Supports sorting by price and searching within a price range.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Playroom {
    private final Toy[] toys;
    private final int maxToys;
    private final double budget;
    private double currentCost = 0.0;
    private int toyCount = 0;

    /**
     * Creates a new playroom with the specified capacity and budget.
     *
     * @param maxToys the maximum number of toys allowed
     * @param budget  the total available budget
     * @throws IllegalArgumentException if maxToys or budget is negative
     */
    public Playroom(int maxToys, double budget) {
        if (maxToys < 0) throw new IllegalArgumentException("Number of toys can't be negative");
        if (budget < 0) throw new IllegalArgumentException("Budget can't be negative");

        this.maxToys = maxToys;
        this.budget = budget;
        this.toys = new Toy[maxToys];
    }

    /**
     * Adds a toy to the playroom if space and budget allow.
     *
     * @param toy the toy to add
     * @throws IllegalStateException if the playroom is full or budget is exceeded
     */
    public void addToy(Toy toy) {
        if (toyCount >= maxToys) {
            throw new IllegalStateException("You can't add more toys — playroom is full");
        }
        if (currentCost + toy.getPrice() > budget) {
            throw new IllegalStateException("Insufficient funds to buy this toy");
        }

        toys[toyCount++] = toy;
        currentCost += toy.getPrice();
    }

    /**
     * Sorts the current toys by price in ascending order.
     */
    public void sortByPrice() {
        Arrays.sort(toys, 0, toyCount, Comparator.comparingDouble(Toy::getPrice));
    }

    /**
     * Finds all toys whose price falls within the specified range (inclusive).
     *
     * @param minPrice minimum price (must be non-negative)
     * @param maxPrice maximum price (must be >= minPrice)
     * @return list of toys in the price range
     * @throws IllegalArgumentException if the range is invalid
     */
    public List<Toy> findByPriceRange(double minPrice, double maxPrice) {
        if (minPrice < 0 || maxPrice < minPrice) {
            throw new IllegalArgumentException("Invalid price range");
        }

        List<Toy> result = new ArrayList<>();
        for (int i = 0; i < toyCount; i++) {
            double price = toys[i].getPrice();
            if (price >= minPrice && price <= maxPrice) {
                result.add(toys[i]);
            }
        }
        return result;
    }

    /**
     * Displays all toys currently in the playroom.
     */
    public void displayToys() {
        for (int i = 0; i < toyCount; i++) {
            System.out.println(toys[i]);
        }
    }

    /**
     * Returns the total cost of all toys currently in the playroom.
     *
     * @return the current spent amount
     */
    public double getCurrentCost() {
        return currentCost;
    }

    /** @return the maximum number of toys this playroom can hold */
    public int getMaxToys() { return maxToys; }

    /** @return the total budget of the playroom */
    public double getBudget() { return budget; }
}