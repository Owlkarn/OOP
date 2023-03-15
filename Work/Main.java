// Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); 
// Реализовать интерфейсs в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа. 
// Создать два списка в классе main. В кждый из списков добавить по десять экземнляров наследников BaseHero. 
// Удалить ненужные методы из абстрактного класса, если такие есть. 
// В main пройти по спискам и вызвать у всех персонажей getInfo.

import Units.Sniper;
import Units.Spearman;
import Units.Warlock;
import Units.Crossbowman;
import Units.Monk;
import Units.Peasant;
import Units.Rogue;

public class Main {
    public static void main(String[] args) {
        Sniper sniper = new Sniper(40, 60, 50, 30, 0.2f);
        Crossbowman crossbowman = new Crossbowman(40, 60, 50, 30, 0.2f);
        Monk monk = new Monk(50, 30, 40, 40, 0.3f);
        Peasant peasant = new Peasant();
        Rogue rogue = new Rogue(40, 50, 30, 50, 0.3f);
        Spearman spearman = new Spearman(30, 40,20,30, 0.3f);
        Warlock warlock = new Warlock(20, 30, 50, 60, 0.2f);
    }
}
