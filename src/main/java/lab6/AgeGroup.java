package lab6;

/**
 * Enumeration representing age suitability categories for toys.
 * Each constant includes a human-readable description of the target age range.
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-13
 */
public enum AgeGroup {
    /** Suitable for babies aged 1–3 years */
    BABY("1-3 years old"),

    /** Suitable for preschool children aged 3–5 years */
    PRESCHOOL("3-5 years old"),

    /** Suitable for school-age children aged 5–12 years */
    SCHOOL("5-12 years old"),

    /** Suitable for teenagers aged 13–18 years */
    TEEN("13-18 years old"),

    /** Suitable for all ages */
    ALL("all");

    /** Human-readable description of the age group */
    private final String description;

    /**
     * Constructs an age group with the specified description.
     *
     * @param description the textual description of the age range
     */
    AgeGroup(String description) {
        this.description = description;
    }

    /**
     * Returns the description of this age group.
     *
     * @return the age range description (e.g., "1-3 years old")
     */
    public String getDescription() {
        return description;
    }
}