package co.edu.taller.behavioral;

public class RequestLifecycle {
    public enum Status {RECEIVED, IN_REVIEW, APPROVED, REJECTED}

    private Status status = Status.RECEIVED;

    public Status status() {
        return status;
    }

    public void review() {
        if (status != Status.RECEIVED) {
            throw new IllegalStateException("Solo una solicitud recibida puede pasar a revisión");
        }
        status = Status.IN_REVIEW;
    }

    public void approve() {
        if (status != Status.IN_REVIEW) {
            throw new IllegalStateException("Solo una solicitud en revisión puede aprobarse");
        }
        status = Status.APPROVED;
    }

    public void reject() {
        if (status != Status.IN_REVIEW) {
            throw new IllegalStateException("Solo una solicitud en revisión puede rechazarse");
        }
        status = Status.REJECTED;
    }
}