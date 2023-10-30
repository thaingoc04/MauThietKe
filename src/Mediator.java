import java.util.ArrayList;
import java.util.List;
public class Mediator {
    // Mediator interface
    interface ChatMediator {
        void sendMessage(String message, User user);
    }

    // Concrete Mediator
    static class ChatRoom implements ChatMediator {
        private List<User> users;

        public ChatRoom() {
            this.users = new ArrayList<>();
        }

        public void addUser(User user) {
            users.add(user);
        }

        @Override
        public void sendMessage(String message, User user) {
            for (User u : users) {
                // Send the message to all users except the sender
                if (u != user) {
                    u.receiveMessage(message);
                }
            }
        }
    }

    // Colleague
    static class User {
        private String name;
        private ChatMediator mediator;

        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public void sendMessage(String message) {
            System.out.println(name + " sends: " + message);
            mediator.sendMessage(message, this);
        }

        public void receiveMessage(String message) {
            System.out.println(name + " receives: " + message);
        }
    }


        public static void main(String[] args) {
            ChatMediator chatRoom = new ChatRoom();

            User user1 = new User("Alice", chatRoom);
            User user2 = new User("Bob", chatRoom);
            User user3 = new User("Charlie", chatRoom);

            ((ChatRoom) chatRoom).addUser(user1);
            ((ChatRoom) chatRoom).addUser(user2);
            ((ChatRoom) chatRoom).addUser(user3);

            user1.sendMessage("Hello, everyone!");
            user2.sendMessage("Hi, Alice!");
        }


}