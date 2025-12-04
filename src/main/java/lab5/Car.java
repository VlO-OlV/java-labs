package lab5;

/**
 * Represents a toy car.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Car extends Toy {

    /**
     * Creates a new toy car.
     *
     * @param price     the price of the car
     * @param ageGroup  the recommended age group
     * @param size      the physical size
     */
    public Car(double price, AgeGroup ageGroup, ToySize size) {
        super("Car", price, ageGroup, size);
    }

    @Override
    public void describe() {
        System.out.println(getSize().getName() + " car for " +
                getAgeGroup().getDescription());
    }
}