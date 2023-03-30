// Реализовать псевдо графику используя приложенные в документах занятия файлы. 
// Распределить функционал основной программы по методам в соответствии с SOLID. 
// Используя класс сканер реализовать повторение хода в основной программе.

import Units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Abstract.*;
import Interface.*;

public class Main {

    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide = new ArrayList<>();
    public static ArrayList<BaseHero> darkSide = new ArrayList<>();
    public static ArrayList<BaseHero> allUnits = new ArrayList<>();

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public static void init() {
        int xWhiteSide = 1;
        int yWhiteSide = 1;
        int xDarkSide = 10;
        int yDarkSide = 1;

        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    whiteSide.add(new Crossbowman(getName(), new Coordinates(xWhiteSide, yWhiteSide)));
                    break;
                case 1:
                    whiteSide.add(new Monk(getName(), new Coordinates(xWhiteSide, yWhiteSide)));
                    break;
                case 2:
                    whiteSide.add(new Spearman(getName(), new Coordinates(xWhiteSide, yWhiteSide)));
                    break;
                default:
                    Peasant peasant = new Peasant(getName(), new Coordinates(xWhiteSide, yWhiteSide));
                    Peasant.setType("Peasant team 1");
                    whiteSide.add(peasant);
                    break;
            }
            yWhiteSide++;
            switch (new Random().nextInt(4)) {
                case 0:
                    darkSide.add(new Sniper(getName(), new Coordinates(xDarkSide, yDarkSide)));
                    break;
                case 1:
                    darkSide.add(new Warlock(getName(), new Coordinates(xDarkSide, yDarkSide)));
                    break;
                case 2:
                    darkSide.add(new Rogue(getName(), new Coordinates(xDarkSide, yDarkSide)));
                    break;
                default:
                    Peasant peasant = new Peasant(getName(), new Coordinates(xDarkSide, yDarkSide));
                    Peasant.setType("Peasant team 2");
                    darkSide.add(peasant);
                    break;
            }
            yDarkSide++;
        }

        allUnits.addAll(whiteSide);
        allUnits.addAll(darkSide);
        allUnits.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u1.getSpeed() == u2.getSpeed()) {
                    if (u1.getAttack() > u2.getAttack())
                        return -1;
                    else if (u1.getAttack() < u2.getAttack())
                        return 1;
                    else
                        return 0;
                } else if (u1.getSpeed() < u2.getSpeed())
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void makeStep() {

        // for (BaseHero baseHero : allUnits) {
        // System.out.println(allUnits.indexOf(baseHero) + " " + baseHero.getInfo() + "
        // " + baseHero.position.getX()+ " " + baseHero.position.getY());
        // }
        //System.out.println(allUnits);

        for (BaseHero unit : allUnits) {
            if (darkSide.contains(unit))
                unit.Step(whiteSide, darkSide);
            else
                unit.Step(darkSide, whiteSide);
        }
        gameOver();
    }

    public static boolean isAlive(ArrayList<BaseHero> team) {
        for (BaseHero hero : team) {
            if (hero.getHp() > 0)
                return true;
        }
        return false;
    }

    public static void gameOver() {
        if (!isAlive(whiteSide)) {
            ConsoleView.view();
            System.out.println("DarkSide Win");
            System.exit(0);
        }
        if (!isAlive(darkSide)) {
            ConsoleView.view();
            System.out.println("WhiteSide Win");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        ConsoleView.view();
        scanner.nextLine();

        while (true) {
            makeStep();
            ConsoleView.view();            
            scanner.nextLine();
        }
    }
}
