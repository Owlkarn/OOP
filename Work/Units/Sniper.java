package Units;

import java.util.Random;

import Abstract.ArrowsUsers;

public class Sniper extends ArrowsUsers {

    final static int defaultHp = 15;
    final static int defaultSpeed = 9;
    final static int defaultMinDamage = 8;
    final static int defaultMaxDamage = 10; 
    final static int defaultArrows = 32; 
    final static int defaultDefence = 10;
    final static int defaultAttack = 12;
    final static float defaultDoubleDamageChance = 0.2f;
    private float doubleDamageChance;

    

    public Sniper(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int arrows,
            float doubleDamageChance) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, arrows);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Sniper(String name) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, defaultArrows, defaultDoubleDamageChance);
     }

    @Override
    public String getInfo() {
        return "Sniper";
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }
    
}
