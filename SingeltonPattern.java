class Logging {

    private static Logging instance;

    private Logging() {};

    public static Logging getInstance() {
        if (instance == null) {
            instance = new Logging();
        }
        return instance;
    }

    public void message(String msg) {
        System.out.println("error:" + msg);
    }

}


class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void despositMoney(double money) {
        if (money > 0) {
            this.balance += money;
            Logging.getInstance().message("balance incremented to" + balance);
        } else {
            Logging.getInstance().message("Failed to desposit");
        }
    }

    public void withdrawMoney(double money){
        if(money > 0 && balance >= money){
            balance -= money;
            Logging.getInstance().message("balance decrement to" + balance);
        }else{
            Logging.getInstance().message("Process can't be done" + balance);
        }
    }

}

public class SingeltonPattern{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.despositMoney(500);
        account.despositMoney(-200);

        account.withdrawMoney(300);
        account.withdrawMoney(1500);
    }
}
