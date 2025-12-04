package lab3;

/**
 * Enumeration representing common automobile body types.
 * Each enum constant holds a human-readable name that is used when displaying
 * the car information.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public enum BodyType {
    /** Sedan - a passenger car with four doors and a traditional three-box configuration */
    SEDAN("sedan"),

    /** SUV (Sport Utility Vehicle) - a larger vehicle with higher ground clearance */
    SUV("SUV"),

    /** Coupe - a two-door car with a sporty appearance and usually a fixed roof */
    COUPE("coupe");

    /** The display name of the body type */
    private final String name;

    /**
     * Constructs a body type with the specified display name.
     *
     * @param name the name used when printing the body type
     */
    BodyType(String name) {
        this.name = name;
    }

    /**
     * Returns the human-readable name of this body type.
     *
     * @return the display name (e.g., "sedan", "SUV", "coupe")
     */
    public String getName() {
        return name;
    }
}