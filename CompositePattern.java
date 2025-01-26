import java.util.ArrayList;
import java.util.List;

interface Component {
    public int getWeight();
}

class TrailerTruck implements Component {
    private int weight;

    public TrailerTruck(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}

class Tractor implements Component {
    private int weight;

    public Tractor(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}

class Truck implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public List<Component> getChildren() {
        return components;
    }

    @Override
    public int getWeight() {
        int totalWeight = 0;
        for (Component component : components) {
            totalWeight += component.getWeight();
        }
        return totalWeight;
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        TrailerTruck trailer = new TrailerTruck(10);
        Tractor tractor = new Tractor(8);

        Truck semiTrailer = new Truck();
        semiTrailer.add(trailer);
        semiTrailer.add(tractor);

        System.out.println("The weight of my trailer is " + trailer.getWeight() + " tons");
        System.out.println("The weight of my tractor is " + tractor.getWeight() + " tons");
        System.out.println("The weight of my semi-trailer is " + semiTrailer.getWeight() + " tons");
    }
}

