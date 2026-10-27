package co.edu.taller.behavioral;

public class ShippingRateStrategy {
    public interface Rate {
        long calculate(long base);
    }

    public enum Mode {STANDARD, EXPRESS, NIGHT}

    private static final Rate STANDARD_RATE = base -> base;
    private static final Rate EXPRESS_RATE = base -> base  + 8000;
    private static final Rate NIGHT_RATE = base -> 0;

    public long quote(Mode mode, long base) {
        if (mode == null || base <= 0) {
            throw new IllegalArgumentException("El modo y una tarifa base positiva son obligatorios");
        }

        Rate selected = switch (mode) {
            case STANDARD -> STANDARD_RATE;
            case EXPRESS -> EXPRESS_RATE;
            case NIGHT -> NIGHT_RATE;
        };
        return selected.calculate(base);
    }
}
