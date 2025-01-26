import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(double newPrice);
}

interface Publisher {
    void ajouter(Observer observer);
    void supprimer(Observer observer);
    void notifyAllObservers(double newPrice, Observer excludingBidder);
}

class Auctioneer implements Publisher {
    private double currentPrice;
    private List<Observer> bidders = new ArrayList<>();

    public Auctioneer(double initialPrice) {
        this.currentPrice = initialPrice;
    }

    public void ajouter(Observer observer) {
        bidders.add(observer);
    }

    public void supprimer(Observer observer) {
        bidders.remove(observer);
    }

    public void notifyAllObservers(double newPrice, Observer excludingBidder) {
        for (Observer bidder : bidders) {
            if (bidder != excludingBidder) {
                bidder.update(newPrice);
            }
        }
    }

    public void acceptBid(double bidAmount, Observer bidder) {
        if (bidAmount > currentPrice) {
            currentPrice = bidAmount;
            System.out.println("New bid accepted: " + bidAmount);
            notifyAllObservers(bidAmount, bidder);
           
        } else {
            System.out.println("Bid rejected. Current price: " + currentPrice);
        }
    }
}

class Bidder implements Observer {
    private String name;

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void update(double newPrice) {
        System.out.println(name + " Confirmation of The Price " + newPrice);
    }

    public void placeBid(double amount, Auctioneer auctioneer) {
        System.out.println(name + " places bid: " + amount);
        auctioneer.acceptBid(amount, this);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        
        Auctioneer auctioneer = new Auctioneer(100);

        Bidder bidder1 = new Bidder("Bidder 1");
        Bidder bidder2 = new Bidder("Bidder 2");
        Bidder bidder3 = new Bidder("Bidder 3");

        auctioneer.ajouter(bidder1);
        auctioneer.ajouter(bidder2);
        auctioneer.ajouter(bidder3);

        bidder1.placeBid(120, auctioneer);
        bidder2.placeBid(130, auctioneer);
        bidder3.placeBid(125, auctioneer);
        bidder1.placeBid(140, auctioneer);
    }
}


