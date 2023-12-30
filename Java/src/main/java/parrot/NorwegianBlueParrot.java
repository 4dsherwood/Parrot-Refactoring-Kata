package parrot;

public class NorwegianBlueParrot {
    public NorwegianBlueParrot() {
    }

    public String getNorwegianBlueCry(double voltage) {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}