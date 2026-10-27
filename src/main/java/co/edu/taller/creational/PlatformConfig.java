package co.edu.taller.creational;

public final class PlatformConfig {
    private static final PlatformConfig INSTANCE = new PlatformConfig();

    private PlatformConfig() {
    }

    public static PlatformConfig instance() {
        return INSTANCE;
    }

    public String get(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("La clave es obligatoria");
        }
        return "environment".equals(key) ? "production" : null;
    }
}