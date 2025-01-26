
interface Coffee {
    double cost();
    String description();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;  // The Coffee object being decorated

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();  // Delegating cost to the wrapped Coffee object
    }

    @Override
    public String description() {
        return coffee.description();  // Delegating description to the wrapped Coffee object
    }
}

// Concrete Decorator 1: Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);  // Passing the base coffee object to the decorator
    }

    @Override
    public double cost() {
        return super.cost() + 1.5;  // Adding cost for milk
    }

    @Override
    public String description() {
        return super.description() + " + Milk";  // Adding milk to the description
    }
}

// Concrete Decorator 2: Sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);  // Passing the base coffee object to the decorator
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;  // Adding cost for sugar
    }

    @Override
    public String description() {
        return super.description() + " + Sugar";  // Adding sugar to the description
    }
}

// Concrete Decorator 3: Whipped Cream
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);  // Passing the base coffee object to the decorator
    }

    @Override
    public double cost() {
        return super.cost() + 2.0;  // Adding cost for whipped cream
    }

    @Override
    public String description() {
        return super.description() + " + Whipped Cream";  // Adding whipped cream to the description
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " | Cost: " + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + " | Cost: " + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.description() + " | Cost: " + coffee.cost());

        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.description() + " | Cost: " + coffee.cost());
    }
}
