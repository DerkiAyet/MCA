interface Builde{
    public House build();
}

class House {
    private String floor;
    private String walls;
    private String roof;
    private String door;
    private String windows;
    private boolean hasSwimmingPool;
    private boolean hasGarden;
    private boolean hasHeatingSystem;
    private boolean hasPlumbing;

    private House(HouseBuilder builder) {
        this.floor = builder.floor;
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.door = builder.door;
        this.windows = builder.windows;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
        this.hasHeatingSystem = builder.hasHeatingSystem;
        this.hasPlumbing = builder.hasPlumbing;
    }
    
    public static class HouseBuilder implements Builde {
        // Mandatory fields
        private String floor;
        private String walls;
        private String roof;
        private String door;
        private String windows;

        // Optional fields
        private boolean hasSwimmingPool;
        private boolean hasGarden;
        private boolean hasHeatingSystem;
        private boolean hasPlumbing;

        public HouseBuilder(String floor, String walls, String roof, String door, String windows) {
            this.floor = floor;
            this.walls = walls;
            this.roof = roof;
            this.door = door;
            this.windows = windows;
        }

        public HouseBuilder withSwimmingPool() {
            this.hasSwimmingPool = true;
            return this;
        }

        public HouseBuilder withGarden() {
            this.hasGarden = true;
            return this;
        }

        public HouseBuilder withHeatingSystem() {
            this.hasHeatingSystem = true;
            return this;
        }

        public HouseBuilder withPlumbing() {
            this.hasPlumbing = true;
            return this;
        }

        @Override
        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", walls='" + walls + '\'' +
                ", roof='" + roof + '\'' +
                ", door='" + door + '\'' +
                ", windows='" + windows + '\'' +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden +
                ", hasHeatingSystem=" + hasHeatingSystem +
                ", hasPlumbing=" + hasPlumbing +
                '}';
    }
}

// Client code to build a house
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Simple house with basic features
        House simpleHouse = new House.HouseBuilder("Wooden", "Brick", "Tiled", "Wooden Door", "Glass")
                .build();
        System.out.println(simpleHouse);

        // Bigger house with extra features like a pool, garden, and heating system
        House luxuryHouse = new House.HouseBuilder("Marble", "Concrete", "Metal", "Steel Door", "Double Glazed")
                .withSwimmingPool()
                .withGarden()
                .withHeatingSystem()
                .withPlumbing()
                .build();
        System.out.println(luxuryHouse);
    }
}
