package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType;

    DinnerConstructor() {
        dishesByType = new HashMap<>();
    }

    void addNewDish(String type, String dish) {
        if (!dishesByType.containsKey(type)) {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dish);
            dishesByType.put(type, dishes);
        } else {
            ArrayList<String> dishes = dishesByType.get(type);
            if (dishes.contains(dish)) {
                System.out.printf("Блюдо уже присутствует в меню под категорией '%s'!\n", type);
                return;
            }
            dishes.add(dish);
        }
    }

    ArrayList<String> generateDishCombo(ArrayList<String> dishTypes) {
        ArrayList<String> combo = new ArrayList<>();
        Random random = new Random();
        for (String dishType : dishTypes) {
            ArrayList<String> dishes = dishesByType.get(dishType);
            int randomIndex = random.nextInt(dishes.size());
            combo.add(dishes.get(randomIndex));
        }
        return combo;
    }

    boolean checkType(String type) {
        return dishesByType.containsKey(type);
    }

}
