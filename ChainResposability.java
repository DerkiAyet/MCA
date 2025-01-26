abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handlePayment(double amount);
}

class BankHandler extends Handler {
    @Override
    public void handlePayment(double amount) {
        if (amount <= 500) {
            System.out.println("Bank processed payment of " + amount);
        } else if (nextHandler != null) {
            nextHandler.handlePayment(amount);
        }
    }
}

class CardHandler extends Handler {
    @Override
    public void handlePayment(double amount) {
        if (amount < 1000) {
            System.out.println("Card processed payment of " + amount);
        } else if (nextHandler != null) {
            nextHandler.handlePayment(amount);
        }
    }
}

class PayPalHandler extends Handler {
    @Override
    public void handlePayment(double amount) {
        if (amount < 1500) {
            System.out.println("PayPal processed payment of " + amount);
        } else {
            System.out.println("Amount exceeds all available payment methods.");
        }
    }
}

public class ChainResposability {
    public static void main(String[] args) {
       
        Handler bankHandler = new BankHandler();
        Handler cardHandler = new CardHandler();
        Handler payPalHandler = new PayPalHandler();

        bankHandler.setNextHandler(cardHandler);
        cardHandler.setNextHandler(payPalHandler);

        double amount = 1300;  
        System.out.println("\nProcessing payment of " + amount);
        bankHandler.handlePayment(amount);
        
    }
}
