package domain;

public class Dog {
    private String name;
    private Float weight;

    public Dog(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }

    public void isSomething() {
        if (weight > 5.0F) {
            System.out.println();
        }
    }
}
