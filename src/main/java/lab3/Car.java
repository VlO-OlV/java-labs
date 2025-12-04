package lab3;

import java.util.Calendar;

/**
 * Represents a car with basic characteristics such as model, year of manufacture,
 * price, engine volume, and body type.
 *
 * <p>The class performs validation on construction: the release year cannot be
 * in the future or negative, and the engine volume must be in a realistic range
 * (0–30 liters).</p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-05
 */
public class Car {
    private final String model;
    private final int year;
    private final double price;
    private final double engineVolume;
    private final BodyType bodyType;

    /**
     * Creates a new Car instance with the specified parameters.
     *
     * @param model        the car model (e.g., "Toyota Camry")
     * @param year         the year of manufacture
     * @param price        the price of the car in USD
     * @param engineVolume the engine displacement in liters
     * @param bodyType     the body style of the car
     * @throws IllegalArgumentException if the year is in the future,
     *                                   negative, or if the engine volume is invalid
     */
    public Car(String model, int year, double price, double engineVolume, BodyType bodyType) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear) {
            throw new IllegalArgumentException("Release year cannot be in future");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Year must be positive");
        }
        if (engineVolume <= 0 || engineVolume > 30) {
            throw new IllegalArgumentException("Engine volume is incorrect (must be > 0 and ≤ 30 liters)");
        }

        this.model = model;
        this.year = year;
        this.price = price;
        this.engineVolume = engineVolume;
        this.bodyType = bodyType;
    }

    /** @return the model name of the car */
    public String getModel() { return model; }

    /** @return the year of manufacture */
    public int getYear() { return year; }

    /** @return the price in USD */
    public double getPrice() { return price; }

    /** @return the engine displacement in liters */
    public double getEngineVolume() { return engineVolume; }

    /** @return the body type of the car */
    public BodyType getBodyType() { return bodyType; }

    /**
     * Returns a formatted string representation of the car suitable for tabular display.
     *
     * @return a string containing model, year, price, engine volume, and body type
     */
    @Override
    public String toString() {
        return String.format("%-18s | %d | $%-6.0f | %.1fl | %s",
                model, year, price, engineVolume, bodyType.getName());
    }

    /**
     * Indicates whether some other object is equal to this car.
     * Two cars are considered equal if all their fields have identical values.
     *
     * @param o the reference object with which to compare
     * @return true if this car is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year &&
                Double.compare(car.price, price) == 0 &&
                Double.compare(car.engineVolume, engineVolume) == 0 &&
                model.equals(car.model) &&
                bodyType == car.bodyType;
    }
}