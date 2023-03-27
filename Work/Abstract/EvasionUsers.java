package Abstract;

import java.util.ArrayList;

import Interface.Coordinates;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, 
    float evasion, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.evasion = evasion;
    }

    // @Override
    // public void Step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> alliesTeam) {
    //     if (hp > 0) {
            
    //         Attack(findNearest(enemyTeam), rndDamage(minDamage, maxDamage));
    //         if (!alliesTeam.stream().filter(peasant -> peasant.getInfo().startsWith("P"))
    //                 .anyMatch(peasant -> true)) {
    //             this.arrows--;
    //         }
    //         //System.out.println("Arrows have: " + this.getArrows());
    //     }
    // }
}
