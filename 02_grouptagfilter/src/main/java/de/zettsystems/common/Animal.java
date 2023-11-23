package de.zettsystems.common;

import static de.zettsystems.common.AnimalType.CAT;
import static de.zettsystems.common.AnimalType.DOG;

public class Animal {
    private String animal;
    private AnimalType animalType;

    public Animal(String animal, AnimalType animalType) {
        this.animal = animal;
        this.animalType = animalType;
    }

    public String getAnimal() {
        return animal;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public String talk() {
        if (DOG == animalType) {
            return "Wau";
        } else if (CAT == animalType) {
            return "Miau";
        } else {
            return "?";
        }
    }
}
