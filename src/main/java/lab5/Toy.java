package lab5;

/**
 * Abstract base class representing a generic toy in a playroom.
 * <p>
 * All toys have a name, price, recommended age group, and physical size.
 * Concrete toy types must implement the {@link #describe()} method.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public abstract class Toy {
    private final String name;
    private final double price;
    private final AgeGroup ageGroup;
    private final ToySize size;

    /**
     * Constructs a new toy with the specified attributes.
     *
     * @param name      the name/type of the toy (e.g., "Car", "Doll")
     * @param price     the price of the toy in currency units
     * @param ageGroup  the recommended age group
     * @param size      the physical size of the toy
     * @throws IllegalArgumentException if price is zero or negative
     */
    public Toy(String name, double price, AgeGroup ageGroup, ToySize size) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
        this.size = size;
    }

    /** @return the name/type of the toy */
    public String getName() { return name; }

    /** @return the price of the toy */
    public double getPrice() { return price; }

    /** @return the recommended age group */
    public AgeGroup getAgeGroup() { return ageGroup; }

    /** @return the physical size of the toy */
    public ToySize getSize() { return size; }

    /**
     * Provides a detailed description of this toy.
     * Implementations should print information about size and age group.
     */
    public abstract void describe();

    /**
     * Returns a string representation of the toy suitable for listing.
     *
     * @return formatted string with name, price, and age group
     */
    @Override
    public String toString() {
        return String.format("%s (Price: %.1f, Age group: %s, Size: %s)",
                name, price, ageGroup.getDescription(), size.getName());
    }
}