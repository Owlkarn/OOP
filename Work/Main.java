// Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); 
// Реализовать интерфейсs в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа. 
// Создать два списка в классе main. В кждый из списков добавить по десять экземнляров наследников BaseHero. 
// Удалить ненужные методы из абстрактного класса, если такие есть. 
// В main пройти по спискам и вызвать у всех персонажей getInfo.

import Units.Sniper;
import Units.Spearman;
import Units.Warlock;

import java.util.ArrayList;
import java.util.Random;

import Abstract.BaseHero;
import Units.Crossbowman;
import Units.Monk;
import Units.Peasant;
import Units.Rogue;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> team_1 = new ArrayList<>();
        ArrayList<BaseHero> team_2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team_1.add(new Crossbowman());
                    break;
                case 1:
                    team_1.add(new Monk());
                    break;
                case 2:
                    team_1.add(new Spearman());
                    break;
                default:
                    team_1.add(new Peasant());
                    break;
            }
            switch (new Random().nextInt(4)) {
                case 0:
                    team_2.add(new Sniper());
                    break;
                case 1:
                    team_2.add(new Warlock());
                    break;
                case 2:
                    team_2.add(new Rogue());
                    break;
                default:
                    team_2.add(new Peasant());
                    break;
            }
        }

        System.out.println("Команда 1:");
        for (BaseHero hero : team_1) {
            System.out.println(hero.getInfo());
        }

        System.out.println("Команда 2:");
        for (BaseHero hero : team_2) {
            System.out.println(hero.getInfo());
        }
    }
}
