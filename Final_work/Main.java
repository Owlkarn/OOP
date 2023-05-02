package Final_work;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static String messageCount = "Укажите количество игрушек %s, которое будет разыграно: ";
    public static String messageChance = "Укажите шанс выпадения игрушки %s: ";
    public static String messageInfo = "id: %d; Имя: %s; Шанс выпадения: %d; Оставшееся количество: %d\n";
    public static List<Toy> gifts = new ArrayList<>();
    public static List<String> prizes = new ArrayList<>();
    public static File file = new File("prizes.txt");

    public static List<String> addToList(int count, List<String> gifts, String toyName) {
        for (int i = 0; i < count; i++) {
            gifts.add(toyName);
        }
        return gifts;
    }

    public static int getNumber(String name, String message) {
        Scanner iScanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.printf(message, name);
            String input = iScanner.nextLine();

            try {
                number = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число, попробуйте еще раз");
            }
        }
        return number;
    }

    public static int getMaxId() {
        int maxId = Collections.max(gifts, new Comparator<Toy>() {
            @Override
            public int compare(Toy toy1, Toy toy2) {
                return Integer.compare(toy1.getId(), toy2.getId());
            }
        }).getId();
        return maxId + 1;
    }

    public static void addNewToy() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Укажите имя игрушки: ");
        String name = iScanner.nextLine();
        int chance = getNumber(name, messageChance);
        int id = getMaxId();
        int count = getNumber(name, messageCount);

        gifts.add(new Toy(id, name, count, chance));
    }

    public static void changeChance() {
        getToysList();
        String messageChangeChance = "У какой игрушки вы хотите изменить шанс выпадения? Укажите %s: \n";
        int id = getNumber("id", messageChangeChance);
        boolean currentId = false;

        do {
            for (Toy gift : gifts) {
                if (id == gift.getId()) {
                    currentId = true;
                    gift.setChance(getNumber(gift.getName(), messageChance));
                    System.out.printf("Шанс выпадения игрушки %s изменен!\n", gift.getName());
                    break;
                }
            }
            if (!currentId) {
                System.out.println("Объект с id " + id + " не найден, попробуйте снова.");
                id = getNumber("id", messageChangeChance);
            }
        } while (!currentId);

    }

    public static int getTotalChance() {
        int totalChance = 0;
        for (Toy toy : gifts) {
            totalChance += toy.getChance();
        }
        return totalChance;
    }

    public static void rafflePrize() {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(getTotalChance()) + 1;
        int currentChance = 0;
        Toy prize;
        for (Toy toy : gifts) {
            currentChance += toy.getChance();
            if (randomNumber <= currentChance) {
                prize = toy;
                prizes.add(prize.getName());
                toy.setCount(toy.getCount() - 1);
                System.out.printf("Разыграна игрушка %s\n", prize.getName());

                if (toy.getCount() == 0)
                    gifts.remove(toy);

                break;
            }
        }
    }

    public static void getToysList() {
        if (gifts.isEmpty())
            System.out.println("Все призы разыграны!");
        else {
            System.out.println("Сейчас в розыгрыше участвуют следующие игрушки:");
            for (Toy toy : gifts) {
                System.out.printf(messageInfo, toy.id, toy.name, toy.chance, toy.count);
            }
        }
    }

    public static void getPrizeList() {
        if (prizes.isEmpty())
            System.out.println("Сейчас нет призов на выдачу");
        else {
            System.out.println("Сейчас готовы к выдаче следующие призы:");
            for (String prize : prizes) {
                System.out.println(prize);
            }
        }
    }

    public static void giveOutPrize() {

        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("Выдан приз " + prizes.get(0) + "\n");
            fw.flush();
            System.out.println("Приз выдан!");
            prizes.remove(0);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + file + ": " + e.getMessage());
        }
    }

    public static void menuSelect() {
        String messageMenu = "Выберите необходимое %s:\n"
                +
                "1 - Вывести список призов\n" +
                "2 - Провести розыгрыш\n" +
                "3 - Выдать приз\n" +
                "4 - Изменить вес(шанс выпадения) приза\n" +
                "5 - Добавить новый приз\n" +
                "6 - Вывести список призов на выдачу\n";
        int action = getNumber("действие", messageMenu);

        switch (action) {
            case 1:
                getToysList();
                break;

            case 2:
                if (gifts.isEmpty())
                    System.out.println("Все призы разыграны!");
                else
                    rafflePrize();
                break;

            case 3:
                if (prizes.isEmpty())
                    System.out.println("Все призы выданы!");
                else
                    giveOutPrize();
                break;

            case 4:
                changeChance();
                break;

            case 5:
                addNewToy();
                break;

            case 6:
                getPrizeList();
                break;

            default:
                System.out.println("Данной команды нет в справочнике.");
        }
    }

    public static void init() {

        gifts.add(new Toy(1, "Bear", getNumber("Bear", messageCount), 6));
        gifts.add(new Toy(2, "Car", getNumber("Car", messageCount), 4));
        gifts.add(new Toy(3, "Doll", getNumber("Doll", messageCount), 3));
        gifts.add(new Toy(4, "Robot", getNumber("Robot", messageCount), 2));

    }

    public static void main(String[] args) {
        init();
        boolean raffle = true;

        if (file.exists()) {
            file.delete();
        }

        while (raffle) {
            menuSelect();

            if (prizes.isEmpty() && gifts.isEmpty())
                raffle = false;
        }

        System.out.println("Все призы разыграны и выданы! Розыгрыш окончен!");
    }
}
