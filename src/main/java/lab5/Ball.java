package lab5;

/**
 * Represents a ball toy.
 * Inherits common toy properties and provides a specific description.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Ball extends Toy {

    /**
     * Creates a new ball toy.
     *
     * @param price     the price of the ball
     * @param ageGroup  the recommended age group
     * @param size      the physical size (small/medium/large)
     */
    public Ball(double price, AgeGroup ageGroup, ToySize size) {
        super("Ball", price, ageGroup, size);
    }

    /**
     * Prints a description of this ball, mentioning its size and target age group.
     */
    @Override
    public void describe() {
        System.out.println(getSize().getName() + " ball for " +
                getAgeGroup().getDescription());
    }
}