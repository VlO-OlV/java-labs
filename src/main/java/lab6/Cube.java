package lab6;

/**
 * Represents a building cube or block toy.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-13
 */
public class Cube extends Toy {

    public Cube(double price, AgeGroup ageGroup, ToySize size) {
        super("Cube", price, ageGroup, size);
    }

    @Override
    public void describe() {
        System.out.println(getSize().getName() + " cube for " +
                getAgeGroup().getDescription());
    }
}