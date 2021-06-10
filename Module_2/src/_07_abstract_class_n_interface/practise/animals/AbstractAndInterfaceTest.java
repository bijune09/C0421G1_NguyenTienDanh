package _07_abstract_class_n_interface.practise.animals;

import _07_abstract_class_n_interface.practise.edible.Edible;

public class AbstractAndInterfaceTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal);

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            } else if (animal instanceof Tiger){
                Edible edibler = (Tiger) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
