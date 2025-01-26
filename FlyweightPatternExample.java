import java.util.HashMap;
import java.util.Map;

class BookType {   // this is the shared data between the books
    private String type;
    private String distributor;
    private String otherData;

    public BookType(String type, String distributor, String otherData) {
        this.type = type;
        this.distributor = distributor;
        this.otherData = otherData;
    }

    public void display() {
        System.out.println("Type: " + type + ", Distributor: " + distributor + ", Other Data: " + otherData);
    }

    public String getType() {
        return type;
    }

    public String getDistributor() {
        return distributor;
    }

    public String getOtherData() {
        return otherData;
    }
}

class Book {    //this the original or the main class that has an attributes of the shared class
    private String name;
    private double price;
    private BookType bookType;  // Reference to shared state

    public Book(String name, double price, BookType bookType) {
        this.name = name;
        this.price = price;
        this.bookType = bookType;
    }

    public void display() {
        System.out.println("Book Name: " + name + ", Price: " + price);
        bookType.display();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public BookType getBookType() {
        return bookType;
    }
}

class BookFactory {    /* the Flyweight class this is used whenever a new groupe of(type, distrubutor, otherData) appear 
    than it create a new instance showing this is a new groupe else it will not because the group already exists */ 
    private static Map<String, BookType> bookTypeMap = new HashMap<>();

    public static BookType getBookType(String type, String distributor, String otherData) {
        String key = type + distributor + otherData;
        BookType bookType = bookTypeMap.get(key);
        if (bookType == null) {
            bookType = new BookType(type, distributor, otherData);
            bookTypeMap.put(key, bookType);
            System.out.println("Creating new BookType: " + type + " " + distributor + " " + otherData);
        }
        return bookTypeMap.get(key);
    }
}


public class FlyweightPatternExample {
    public static void main(String[] args) {
        
        BookType book1Type = BookFactory.getBookType("Fiction", "PublisherA", "Bestseller");
        Book book1 = new Book("Book One", 19.99, book1Type);
        book1.display();

        BookType book2Type = BookFactory.getBookType("Fiction", "PublisherA", "Bestseller");
        Book book2 = new Book("Book Two", 29.99, book2Type);
        book2.display();

        BookType book3Type = BookFactory.getBookType("Non-Fiction", "PublisherB", "New Release");
        Book book3 = new Book("Book Three", 39.99, book3Type);
        book3.display();
    }
}
