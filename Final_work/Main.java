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

    public static String MESSAGE_COUNT = "Укажите количество игрушек %s, которое будет разыграно: ";
    public static String MESSAGE_CHANCE = "Укажите шанс выпадения игрушки %s: ";
    public static String MESSAGE_INFO = "id: %d; Имя: %s; Шанс выпадения: %d; Оставшееся количество: %d\n";
    public static String MESSAGE_GET_NAME = "Укажите имя игрушки: ";
    public static String MESSAGE_CHANGE_CHANCE = "У какой игрушки вы хотите изменить шанс выпадения? Укажите %s: \n";
    public static String MESSAGE_CHANGE_CHANCE_SUCCESS = "Шанс выпадения игрушки %s изменен!\n";
    public static String MESSAGE_FIND_ID_ERROR = "Объект с id %d не найден, попробуйте снова.\n";
    public static String MESSAGE_RAFFLE_PRIZE = "Разыграна игрушка %s\n";
    public static String MESSAGE_EMPTY_GIFTS_LIST = "Все призы разыграны!";
    public static String MESSAGE_IN_GIFTS_LIST = "Сейчас в розыгрыше участвуют следующие игрушки:";
    public static String MESSAGE_EMPTY_PRIZES_LIST = "Сейчас нет призов на выдачу";
    public static String MESSAGE_IN_PRIZES_LIST = "Сейчас готовы к выдаче следующие призы:";
    public static String MESSAGE_PRIZE_GIVE_OUT = "Приз выдан!";
    public static String MESSAGE_EXCEPTION_NUMBER = "Ошибка: введено не число, попробуйте еще раз";
    public static String MESSAGE_NO_COMMAND_ERROR = "Данной команды нет в справочнике.";
    public static String MESSAGE_END = "Все призы разыграны и выданы! Розыгрыш окончен!";

    public static List<Toy> GIFTS = new ArrayList<>();
    public static List<String> PRIZES = new ArrayList<>();
    public static File FILE = new File("PRIZES.txt");

    public static List<String> addToList(int count, List<String> GIFTS, String toyName) {
        for (int i = 0; i < count; i++) {
            GIFTS.add(toyName);
        }
        return GIFTS;
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
                System.out.println(MESSAGE_EXCEPTION_NUMBER);
            }
        }
        return number;
    }

    public static int getMaxId() {
        int maxId = Collections.max(GIFTS, new Comparator<Toy>() {
            @Override
            public int compare(Toy toy1, Toy toy2) {
                return Integer.compare(toy1.getId(), toy2.getId());
            }
        }).getId();
        return maxId + 1;
    }

    public static void addNewToy() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println(MESSAGE_GET_NAME);
        String name = iScanner.nextLine();
        int chance = getNumber(name, MESSAGE_CHANCE);
        int id = getMaxId();
        int count = getNumber(name, MESSAGE_COUNT);

        GIFTS.add(new Toy(id, name, count, chance));
    }

    public static void changeChance() {
        getToysList();
        int id = getNumber("id", MESSAGE_CHANGE_CHANCE);
        boolean currentId = false;

        do {
            for (Toy gift : GIFTS) {
                if (id == gift.getId()) {
                    currentId = true;
                    gift.setChance(getNumber(gift.getName(), MESSAGE_CHANCE));
                    System.out.printf(MESSAGE_CHANGE_CHANCE_SUCCESS, gift.getName());
                    break;
                }
            }
            if (!currentId) {
                System.out.printf(MESSAGE_FIND_ID_ERROR, id);
                id = getNumber("id", MESSAGE_CHANGE_CHANCE);
            }
        } while (!currentId);

    }

    public static int getTotalChance() {
        int totalChance = 0;
        for (Toy toy : GIFTS) {
            totalChance += toy.getChance();
        }
        return totalChance;
    }

    public static void rafflePrize() {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(getTotalChance()) + 1;
        int currentChance = 0;
        Toy prize;
        for (Toy toy : GIFTS) {
            currentChance += toy.getChance();
            if (randomNumber <= currentChance) {
                prize = toy;
                PRIZES.add(prize.getName());
                toy.setCount(toy.getCount() - 1);
                System.out.printf(MESSAGE_RAFFLE_PRIZE, prize.getName());

                if (toy.getCount() == 0)
                    GIFTS.remove(toy);

                break;
            }
        }
    }

    public static void getToysList() {
        if (GIFTS.isEmpty())
            System.out.println(MESSAGE_EMPTY_GIFTS_LIST);
        else {
            System.out.println(MESSAGE_IN_GIFTS_LIST);
            for (Toy toy : GIFTS) {
                System.out.printf(MESSAGE_INFO, toy.getId(), toy.getName(), toy.getChance(), toy.getCount());
            }
        }
    }

    public static void getPrizeList() {
        if (PRIZES.isEmpty())
            System.out.println(MESSAGE_EMPTY_PRIZES_LIST);
        else {
            System.out.println(MESSAGE_IN_PRIZES_LIST);
            for (String prize : PRIZES) {
                System.out.println(prize);
            }
        }
    }

    public static void giveOutPrize() {

        try {
            FileWriter fw = new FileWriter(FILE, true);
            fw.write("Выдан приз " + PRIZES.get(0) + "\n");
            fw.flush();
            System.out.println(MESSAGE_PRIZE_GIVE_OUT);
            PRIZES.remove(0);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + FILE + ": " + e.getMessage());
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
                if (GIFTS.isEmpty())
                    System.out.println(MESSAGE_EMPTY_GIFTS_LIST);
                else
                    rafflePrize();
                break;

            case 3:
                if (PRIZES.isEmpty())
                    System.out.println(MESSAGE_EMPTY_PRIZES_LIST);
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
                System.out.println(MESSAGE_NO_COMMAND_ERROR);
        }
    }

    public static void init() {

        GIFTS.add(new Toy(1, "Bear", getNumber("Bear", MESSAGE_COUNT), 6));
        GIFTS.add(new Toy(2, "Car", getNumber("Car", MESSAGE_COUNT), 4));
        GIFTS.add(new Toy(3, "Doll", getNumber("Doll", MESSAGE_COUNT), 3));
        GIFTS.add(new Toy(4, "Robot", getNumber("Robot", MESSAGE_COUNT), 2));

    }

    public static void main(String[] args) {
        init();
        boolean raffle = true;

        if (FILE.exists()) {
            FILE.delete();
        }

        while (raffle) {
            menuSelect();

            if (PRIZES.isEmpty() && GIFTS.isEmpty())
                raffle = false;
        }

        System.out.println(MESSAGE_END);
    }
}
