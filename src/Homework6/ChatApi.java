package Homework6;

public class ChatApi {
    public static class Message {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
