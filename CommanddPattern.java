interface Commandd {
    void execute();
}

class User1 {
    private String name;

    public User1(String name) {
        this.name = name;
    }

    public void sendMessage(String message, User1 recipient) {
        System.out.println(name + " sends message to " + recipient.getName() + ": " + message);
        recipient.receiveMessage(message, this);
    }

    public void receiveMessage(String message, User1 sender) {
        System.out.println(name + " received a message from " + sender.getName() + ": " + message);
    }

    public String getName() {
        return name;
    }
}

class ConcreteMessage implements Commandd {
    private User1 sender;
    private User1 recipient;
    private String message;

    public ConcreteMessage(User1 sender, User1 recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void execute() {
        sender.sendMessage(message, recipient);
    }
}

class ChatInvoker {
    private Commandd command;

    public void setCommand(Commandd command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}

public class CommanddPattern {
    public static void main(String[] args) {
       
        User1 ayet = new User1("ayet");
        User1 narimane = new User1("narimane");
        User1 oumaima = new User1("oumaima");

       
        ChatInvoker chatInvoker = new ChatInvoker();

        Commandd commandd1 = new ConcreteMessage(ayet, narimane, "Hi narimane!");
        chatInvoker.setCommand(commandd1);
        chatInvoker.executeCommand();

        Commandd Commandd2 = new ConcreteMessage(narimane, ayet, "Hello ayet!");
        chatInvoker.setCommand(Commandd2);
        chatInvoker.executeCommand();

        Commandd Commandd3 = new ConcreteMessage(oumaima, ayet, "Good morning, ayet!");
        chatInvoker.setCommand(Commandd3);
        chatInvoker.executeCommand();
    }
}

