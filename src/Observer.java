import java.util.ArrayList;
import java.util.List;
public class Observer {
    // Subject (Observable)
    public static class Blog {
        private List<Subscriber> subscribers = new ArrayList<>();
        private String latestPost;

        public void addObserver(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        public void removeObserver(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        public void createNewPost(String post) {
            latestPost = post;
            notifySubscribers();
        }

        private void notifySubscribers() {
            for (Subscriber subscriber : subscribers) {
                subscriber.update(latestPost);
            }
        }
    }

    // Observer (Subscriber)
    public static class Subscriber {
        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        public void update(String latestPost) {
            System.out.println(name + " received an update: " + latestPost);
        }
    }


    public static void main(String[] args) {
        Blog blog = new Blog();

        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        blog.addObserver(subscriber1);
        blog.addObserver(subscriber2);

        blog.createNewPost("New blog post: Design Patterns in Java"); // This will notify subscribers
        blog.createNewPost("Another post: Object-Oriented Programming Concepts"); // This will also notify subscribers
    }


}