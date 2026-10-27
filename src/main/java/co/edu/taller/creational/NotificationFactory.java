package co.edu.taller.creational;

public class NotificationFactory {
    public interface Notifier {
        String send(String recipient, String message);
    }

    public enum Channel {EMAIL, SMS}

    public Notifier create(Channel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("El canal es obligatorio");
        }

        return switch (channel) {
            case EMAIL -> new EmailNotifier();
            case SMS -> new SmsNotifier();
        };
    }

    private static class EmailNotifier implements Notifier {
        @Override
        public String send(String recipient, String message) {
            return "EMAIL:" + recipient + ":" + message;
        }
    }

    private static class SmsNotifier implements Notifier {
        @Override
        public String send(String recipient, String message) {
            return "SMS:" + recipient + ":" + message;
        }
    }
}
