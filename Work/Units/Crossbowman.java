package Units;

import java.util.ArrayList;
import java.util.Random;

import Abstract.ArrowsUsers;
import Abstract.BaseHero;

public class Crossbowman extends ArrowsUsers {

    final static int defaultHp = 10;
    final static int defaultSpeed = 4;
    final static float defaultDamage = new Random().nextFloat(2f, 4f);
    final static int defaultArrows = 16; 
    final static float defaultStunChance = 0.2f;
    final static int defaultDefence = 3;
    final static int defaultAttack = 6;
    private float stunChance;

    public Crossbowman(float hp, int speed, float damage, int defence, String name, int attack, int arrows,
            float stunChance) {
        super(hp, speed, damage, defence, name, attack, arrows);
        this.stunChance = stunChance;
    }

    public Crossbowman(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultArrows, defaultStunChance);
     }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }

    public int getArrows() {
        return arrows;
    }

    public float rndDamage(float a, float b) {
        return new Random().nextFloat(a, b);
    }

    public void Step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> alliesTeam) {
        if (arrows > 0 && hp > 0) {
            System.out.println("Могу стрелять!");
            for (BaseHero unit : enemyTeam) {
                if (unit.hp > 0) {
                    damage = rndDamage(2f, 4f);
                    Attack(unit, damage);
                    if (!alliesTeam.stream().filter(peasant -> peasant.getInfo().startsWith("P")).anyMatch(peasant -> true)) {
                        this.arrows--;
                    }
                    System.out.println("Arrows have: " + this.getArrows());
                }                
            }
        }
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }
    
    
}
