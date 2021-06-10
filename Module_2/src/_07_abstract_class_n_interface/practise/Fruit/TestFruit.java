package _07_abstract_class_n_interface.practise.Fruit;

import _07_abstract_class_n_interface.practise.Fruit.Apple;
import _07_abstract_class_n_interface.practise.Fruit.Fruit;
import _07_abstract_class_n_interface.practise.Fruit.Orange;
import _07_abstract_class_n_interface.practise.edible.Edible;

public class TestFruit {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();

        for (Fruit fruit : fruits){
            System.out.println(fruit);
            if (fruit instanceof Orange){
                Edible orange = (Orange) fruit;
                System.out.println(orange.howToEat());
            } else if (fruit instanceof Apple){
                Edible apple = (Apple) fruit;
                System.out.println(apple.howToEat());
            }
        }
    }
}
