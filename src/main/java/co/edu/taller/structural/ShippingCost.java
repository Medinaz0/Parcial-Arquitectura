package co.edu.taller.structural;

public interface ShippingCost {
    long cost();

    class Standard implements ShippingCost {
        @Override
        public long cost() {
            return 12000;
        }
    }

    class Insurance implements ShippingCost {
        private final ShippingCost wrapped;

        public Insurance(ShippingCost wrapped) {
            if (wrapped == null) {
                throw new IllegalArgumentException("El costo base no puede ser nulo");
            }
            this.wrapped = wrapped;
        }

        @Override
        public long cost() {
            return wrapped.cost() + 2500;
        }
    }

    class Priority implements ShippingCost {
        private final ShippingCost wrapped;

        public Priority(ShippingCost wrapped) {
            if (wrapped == null) {
                throw new IllegalArgumentException("El costo base no puede ser nulo");
            }
            this.wrapped = wrapped;
        }

        @Override
        public long cost() {
            return wrapped.cost() + 7000;
        }
    }
}
