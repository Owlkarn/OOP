// Создать класс с описанием координат, x и y.
// Добавить в абстрактный класс порле с координатами и пробросить его инициализацию до конструкторов персонажей. 
// Farmer farmer = new Farmer(getName(), x, y);
// Реализовать метод step() лучников. 
// 3.1 Если жизнь равна нулю или стрел нет, завершить оьработку. 
// 3.2 Поиск среди противников наиболее приближённого. 
// 3.3 Нанести среднее повреждение найденному противнику. 
// 3.4 Найти среди своих крестьянина. 
// 3.5 Если найден завершить метод иначе уменьшить запас стрел на одну.

import Units.Sniper;
import Units.Spearman;
import Units.Warlock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import Abstract.BaseHero;
import Interface.Coordinates;
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
        int xTeam1 = 1;
        int yTeam1 = 1;
        int xTeam2 = 10;
        int yTeam2 = 1;

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team_1.add(new Crossbowman(getName(), Coordinates(xTeam1, yTeam1)));
                    break;
                case 1:
                    team_1.add(new Monk(getName()));
                    break;
                case 2:
                    team_1.add(new Spearman(getName()));
                    break;
                default:
                    Peasant peasant = new Peasant(getName());
                    peasant.setInfo("Peasant team 1");
                    team_1.add(peasant);
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
                    Peasant peasant = new Peasant(getName());
                    peasant.setInfo("Peasant team 2");
                    team_2.add(peasant);
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
        // System.out.println(hero.getInfo());
        // }
        // System.out.println();

        // System.out.println("Команда 2:");
        // for (BaseHero hero : team_2) {
        // System.out.println(hero.getInfo());
        // }
        // System.out.println();

        // System.out.println("Сортировка:");
        // for (BaseHero hero : stepTurnList) {
        //     System.out.println(hero.getInfo() + " " + hero.getName());
        // }
        team_1.forEach(u -> u.Step(team_2, team_1));
    }
}
