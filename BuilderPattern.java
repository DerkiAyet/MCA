import java.util.Arrays;
import java.util.List;

interface Builder {
    public Dog build();
}

class Dog {
    private String name;
    private String type;
    private Integer age;
    private List<String> toys;

    private Dog(DogBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.age = builder.age;
        this.toys = builder.toys;
    }

    public static class DogBuilder implements Builder {
        private String name;
        private String type;
        private Integer age;
        private List<String> toys;

        public DogBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public DogBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public DogBuilder setToys(List<String> toys) {
            this.toys = toys;
            return this;
        }

        @Override
        public Dog build() {
            return new Dog(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getToys() {
        return toys;
    }

    @Override
    public String toString() {
        return "Dog { " +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", toys=" + toys +
                " }";
    }
}




public class BuilderPattern {
    public static void main(String[] args) {

        Dog dog = new Dog.DogBuilder()
                .setName("Lamia")
                .setType("sauvage")
                .setAge(21)
                .setToys(Arrays.asList("rjal"))
                .build();

        System.out.println(dog);
    }
}
