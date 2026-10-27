package co.edu.taller.structural;

public class CheckoutFacade {
    public interface Inventory {
        boolean reserve(String sku, int quantity);
    }

    public interface Payment {
        boolean charge(String orderId, long amount);
    }

    private final Inventory inventory;
    private final Payment payment;

    public CheckoutFacade(Inventory i, Payment p) {
        inventory = i;
        payment = p;
    }

    public String checkout(String orderId, String sku, int quantity, long amount) {
        if (orderId == null || orderId.isBlank() || sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("El pedido y el producto son obligatorios");
        }
    
        if (!inventory.reserve(sku, quantity)) {
            throw new IllegalStateException("No hay inventario disponible");
        }
        if (!payment.charge(orderId, amount)) {
            throw new IllegalStateException("El pago fue rechazado");
        }

        return "CONFIRMED:" + orderId;
    }
}
