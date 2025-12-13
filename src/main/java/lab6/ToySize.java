package lab6;

/**
 * Enumeration representing physical size categories of toys.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-31
 */
public enum ToySize {
    /** Small-sized toy */
    SMALL("small"),

    /** Medium-sized toy */
    MEDIUM("medium"),

    /** Large-sized toy */
    LARGE("large");

    /** String representation of the size */
    private final String name;

    /**
     * Constructs a toy size with the given name.
     *
     * @param name the display name of the size
     */
    ToySize(String name) {
        this.name = name;
    }

    /**
     * Returns the display name of this size.
     *
     * @return "small", "medium", or "large"
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}