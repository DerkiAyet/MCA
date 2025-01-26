interface Command {
    void execute();
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message, User recipient) {
        System.out.println(name + " sends message to " + recipient.getName() + ": " + message);
        recipient.receiveMessage(message, this);
    }

    public void receiveMessage(String message, User sender) {
        System.out.println(name + " received a message from " + sender.getName() + ": " + message);
    }

    public String getName() {
        return name;
    }
}

class ConcreteMessage implements Command {
    private User sender;
    private User recipient;
    private String message;

    public ConcreteMessage(User sender, User recipient, String message) {
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
    private Command command;

    public void setCommand(Command command) {
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

public class CommandPattern {
    public static void main(String[] args) {
       
        User ayet = new User("ayet");
        User narimane = new User("narimane");
        User oumaima = new User("oumaima");

       
        ChatInvoker chatInvoker = new ChatInvoker();

        Command command1 = new ConcreteMessage(ayet, narimane, "Hi narimane!");
        chatInvoker.setCommand(command1);
        chatInvoker.executeCommand();

        Command command2 = new ConcreteMessage(narimane, ayet, "Hello ayet!");
        chatInvoker.setCommand(command2);
        chatInvoker.executeCommand();

        Command command3 = new ConcreteMessage(oumaima, ayet, "Good morning, ayet!");
        chatInvoker.setCommand(command3);
        chatInvoker.executeCommand();
    }
}

