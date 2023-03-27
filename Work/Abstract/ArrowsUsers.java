package Abstract;

import java.util.ArrayList;
import java.util.Random;

import Interface.Coordinates;

public abstract class ArrowsUsers extends BaseHero {

    protected int arrows;

    public ArrowsUsers(float hp, int speed, int mindamage, int maxDamage, int defence, String name, int attack,
            int arrows, Coordinates position, String type, int maxHp) {
        super(hp, speed, mindamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.arrows = arrows;
    }

    @Override
    public void Step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> alliesTeam) {
        if (arrows > 0 && hp > 0) {
            Attack(findNearest(enemyTeam), rndDamage(minDamage, maxDamage));
            if (!alliesTeam.stream().filter(peasant -> peasant.getInfo().startsWith("P"))
                    .anyMatch(peasant -> true)) {
                this.arrows--;
            }
            //System.out.println("Arrows have: " + this.getArrows());
        }
    }

    public int getArrows() {
        return arrows;
    }

}
