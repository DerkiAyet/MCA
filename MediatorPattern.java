import java.util.HashMap;
import java.util.Map;

interface Mediator {
    void sendMessage(String message, String fromUser, String toUser);
    void registerUser(User user);
}

class ChatMediator implements Mediator {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void sendMessage(String message, String fromUser, String toUser) {
        User recipient = users.get(toUser);
        if (recipient != null) {
            recipient.receive(message, fromUser);
        } else {
            System.out.println("Error: User " + toUser + " is not registered.");
        }
    }

    @Override
    public void registerUser(User user) {
        users.put(user.getName(), user);
    }
}

abstract class User {
    protected Mediator mediator;
    protected String name;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public abstract void send(String message, String toUser);
    public abstract void receive(String message, String fromUser);
}

class ChatUser extends User {
    public ChatUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message, String toUser) {
        System.out.println(name + " sends: " + message + " to " + toUser);
        mediator.sendMessage(message, name, toUser);
    }

    @Override
    public void receive(String message, String fromUser) {
        System.out.println(name + " receives: " + message + " from " + fromUser);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator chatMediator = new ChatMediator();
        
        User alice = new ChatUser(chatMediator, "Alice");
        User bob = new ChatUser(chatMediator, "Bob");
        User charlie = new ChatUser(chatMediator, "Charlie");

        alice.send("Hello, Bob!", "Bob");
        bob.send("Hi, Alice!", "Alice");
        charlie.send("Hey, Bob!", "Bob");
        alice.send("Hi, Dave!", "Dave");
    }
}
