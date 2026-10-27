package co.edu.taller.behavioral;

import java.util.*;

public class InventoryAlerts {
    public interface Listener {
        void onLowStock(String sku, int quantity);
    }

    private final int threshold;
    private final List<Listener> listeners = new ArrayList<>();

    public InventoryAlerts(int threshold) {
        this.threshold = threshold;
    }

    public void subscribe(Listener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("El suscriptor no puede ser nulo");
        }
        listeners.add(listener);
    }

    public void update(String sku, int quantity) {
        if (quantity <= threshold) {
            for (Listener listener : listeners) {
                listener.onLowStock(sku, quantity);
            }
        }
    }
}