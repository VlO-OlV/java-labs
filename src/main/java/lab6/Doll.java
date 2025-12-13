package lab6;

/**
 * Represents a doll toy.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-13
 */
public class Doll extends Toy {

    public Doll(double price, AgeGroup ageGroup, ToySize size) {
        super("Doll", price, ageGroup, size);
    }

    @Override
    public void describe() {
        System.out.println(getSize().getName() + " doll for " +
                getAgeGroup().getDescription());
    }
}