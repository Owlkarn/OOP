// Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); 
// Реализовать интерфейсs в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа. 
// Создать два списка в классе main. В кждый из списков добавить по десять экземнляров наследников BaseHero. 
// Удалить ненужные методы из абстрактного класса, если такие есть. 
// В main пройти по спискам и вызвать у всех персонажей getInfo.

import Units.Sniper;
import Units.Spearman;
import Units.Warlock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import Abstract.BaseHero;
import Interface.Names;
import Units.Crossbowman;
import Units.Monk;
import Units.Peasant;
import Units.Rogue;

public class Main {

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    public static void main(String[] args) {
        ArrayList<BaseHero> team_1 = new ArrayList<>();
        ArrayList<BaseHero> team_2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team_1.add(new Crossbowman(getName()));
                    break;
                case 1:
                    team_1.add(new Monk(getName()));
                    break;
                case 2:
                    team_1.add(new Spearman(getName()));
                    break;
                default:
                    team_1.add(new Peasant(getName()));
                    break;
            }
            switch (new Random().nextInt(4)) {
                case 0:
                    team_2.add(new Sniper(getName()));
                    break;
                case 1:
                    team_2.add(new Warlock(getName()));
                    break;
                case 2:
                    team_2.add(new Rogue(getName()));
                    break;
                default:
                    team_2.add(new Peasant(getName()));
                    break;
            }
        }

        ArrayList<BaseHero> stepTurnList = new ArrayList<>();

        stepTurnList.addAll(team_1);
        stepTurnList.addAll(team_2);
        stepTurnList.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u1.getSpeed() > u2.getSpeed())
                    return -1;
                else if (u1.getSpeed() < u2.getSpeed())
                    return 1;
                else
                    return 0;
            }
        });

        // System.out.println("Команда 1:");
        // for (BaseHero hero : team_1) {
        //     System.out.println(hero.getInfo());
        // }

        // System.out.println("Команда 2:");
        // for (BaseHero hero : team_2) {
        //     System.out.println(hero.getInfo());
        // }

        System.out.println("Сортировка:");
        for (BaseHero hero : stepTurnList) {
            System.out.println(hero.getInfo() + " " + hero.getName());
        }
    }
}
