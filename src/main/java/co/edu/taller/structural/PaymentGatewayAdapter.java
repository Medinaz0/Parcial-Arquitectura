package co.edu.taller.structural;

public class PaymentGatewayAdapter {
    public interface PaymentPort {
        String charge(String orderId, long pesos);
    }

    public static class LegacyGateway {
        public String chargeInCents(String id, long cents) {
            return "LEGACY:" + id + ":" + cents;
        }
    }

    private final LegacyGateway legacy;

    public PaymentGatewayAdapter(LegacyGateway legacy) {
        this.legacy = legacy;
    }

    public String charge(String orderId, long pesos) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("El identificador del pedido es obligatorio");
        }
        if (pesos <= 0) {
            throw new IllegalArgumentException("El importe debe ser positivo");
        }

        long cents = pesos * 100;
        return legacy.chargeInCents(orderId, cents);
    }
}