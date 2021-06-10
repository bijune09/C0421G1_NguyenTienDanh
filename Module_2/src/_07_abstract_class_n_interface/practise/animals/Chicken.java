package _07_abstract_class_n_interface.practise.animals;

import _07_abstract_class_n_interface.practise.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: meow meow";
    }

    @Override
    public String howToEat() {
        return "No Way Out!!";
    }
}
