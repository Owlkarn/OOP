package Final_work;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {
    
    public static String messageCount = "Укажите количество игрушек %s, которое будет разыграно: ";
    public static String messageChance = "Укажите шанс выпадения игрушки %s: ";
    public static List<Toy> gifts = new ArrayList<>();

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
        iScanner.close();
        return number;
    }
    
    public static int getMaxId (List<Toy> gifts) {
        int maxId = Collections.max(gifts, new Comparator<Toy>() {
            @Override
            public int compare(Toy toy1, Toy toy2) {
                return Integer.compare(toy1.getId(), toy2.getId());
            }
        }).getId();
        return maxId + 1;
    }

    public static List<Toy> addNewToy(List<Toy> gifts){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Укажите имя игрушки: ");
        String name = iScanner.nextLine();
        int chance = getNumber(name, messageChance);
        int id = getMaxId(gifts);
        int count = getNumber(name, messageCount);

        gifts.add(new Toy(id, name, count, chance));
        iScanner.close();
        return gifts;
    }

    public static void changeChance(List<Toy> gifts) {
        System.out.println("Сейчас в розыгрыше участвуют следующие игрушки:");
        for (Toy toy : gifts) {
            System.out.printf("id: %d; Имя: %s; Шанс выпадения: %d; Оставшееся количество: %d\n", toy.id, toy.name, toy.chance, toy.count);
        }
        String messageChangeChance = "У какой игрушки вы хотите изменить шанс выпадения? Укажите %s.";
        int id = getNumber("id", messageChangeChance);
        boolean currentId = false;

        do{
            for (Toy gift : gifts) {
                if (gift.getId() == id)
                currentId = true;
                gift.setChance(getNumber(gift.getName(), messageChance));
            }
            if (!currentId) {
                System.out.println("Объект с id " + id + " не найден, попробуйте снова.");
                id = getNumber("id", messageChangeChance);
            }
        } while (!currentId);

    }
    
    public static void raffle() {
        
    }

    public static void init() {

        
        gifts = List.of(
            new Toy(1, "Bear", getNumber("Bear", messageCount), 60),
            new Toy(2, "Car", getNumber("Car", messageCount), 40),
            new Toy(3, "Doll", getNumber("Doll", messageCount), 30),
            new Toy(4, "Robot", getNumber("Robot", messageCount), 20)
        );
        
        // System.out.println("Введите номера параметров для фильтрации через пробел:\n" +
        //         "1 - производитель\n" +
        //         "2 - объем жесткого диска\n" +
        //         "3 - оперативная память\n" +
        //         "4 - операционная система\n" +
        //         "5 - цвет\n" +
        //         "6 - процессор");

        
        
}
}
