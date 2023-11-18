package ru.fsv67;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
Создать свой Java Maven/Gradle проект;
Реализовать прикладную задачу - приложение для демонстрации парадокса Монти Холла;
Можно добавить любые библиотеки которые считают необходимыми
Результаты должны быть сохранены в HashMap (шаг цикла -> результат)
Необходимо вывести статистику по результату - количество позитивных и негативных результатов, процент от общего количества шагов цикла.
 */

public class Main {
    static int quantityDoors = 3;
    static int quantityIteration = 1000;

    public static void main(String[] args) {
        int countWinner = 0;
        int countLoser = 0;
        for (int i = 0; i < processingGame().size(); i++) {
            if (processingGame().get(i + 1)) {
                countWinner++;
            } else {
                countLoser++;
            }
        }
        System.out.println("Выигрышных комбинаций: " + countWinner + "\nПроигрышных комбинаций: " + countLoser);

        double percentWinner = (double) (countWinner * 100) / quantityIteration;
        double percentLoser = (double) (countLoser * 100) / quantityIteration;
        System.out.println("% выигрышных комбинаций: " + percentWinner + "\n% проигрышных комбинаций: " + percentLoser);
    }

    /**
     * Метод получения парадокс Монти Холла
     *
     * @return коллекция результатов комбинаций
     */
    public static Map<Integer, Boolean> processingGame() {
        int counterIteration = 0;
        Map<Integer, Boolean> result = new HashMap<>();
        while (counterIteration < quantityIteration) {
            int winningDoor = new Random().nextInt(quantityDoors) + 1;
            int selectedDoor = new Random().nextInt(quantityDoors) + 1;
            result.put(counterIteration + 1, resultGame(winningDoor, selectedDoor));
            counterIteration++;
        }
        return result;
    }

    /**
     * Метод получения результата за один проход
     *
     * @param winningDoor  Дверь с выигрышем
     * @param selectedDoor Выбранная дверь
     * @return true если выбранная дверь оказалась выигрышной
     */
    public static boolean resultGame(int winningDoor, int selectedDoor) {
        int setNewDoor = new Random().nextInt(2); // Смена решения выбора: если 0 то не меняем, если 1 меняем
        if (winningDoor == selectedDoor) {
            return setNewDoor == 0;
        }
        return setNewDoor == 1;
    }
}
