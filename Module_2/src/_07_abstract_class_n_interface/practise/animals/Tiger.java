package _07_abstract_class_n_interface.practise.animals;

import _07_abstract_class_n_interface.practise.edible.Edible;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger: gau gau";
    }

    @Override
    public String howToEat() {
        return "Maybe we are their food";
    }
}
