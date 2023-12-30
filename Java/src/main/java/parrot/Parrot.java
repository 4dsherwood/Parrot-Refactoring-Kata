package parrot;

public class Parrot {

    // create a new class that inherits from Parrot named NorwegianBlue

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;
    private final EuropeanParrot europeanParrot = new EuropeanParrot();
    private final AfricanParrot africanParrot = new AfricanParrot();

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> europeanParrot.getEuropeanCry();
            case AFRICAN -> africanParrot.getAfricanCry();
            case NORWEGIAN_BLUE -> getNorwegianBlueCry(voltage);
        };
    }

    private String getNorwegianBlueCry(double voltage) {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }

    public double getSpeed() {
        // code smell: switch by type
        return switch (type) {
            case EUROPEAN -> europeanParrot.getEuropeanBaseSpeed();
            case AFRICAN -> Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
            case NORWEGIAN_BLUE -> (isNailed) ? 0 : getBaseSpeed(voltage);
        };
    }

    private double getBaseSpeed() {
        return 12.0;
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    private double getLoadFactor() {
        return 9.0;
    }
}
