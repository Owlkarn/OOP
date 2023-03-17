package Units;

import java.util.Random;

import Abstract.EvasionUsers;

public class Rogue extends EvasionUsers {

    final static int defaultHp = 10;
    final static int defaultSpeed = 6;
    final static int defaultMinDamage = 2;
    final static int defaultMaxDamage = 4; 
    final static float defaultEvasion = 0.2f; 
    final static int defaultDefence = 3;
    final static int defaultAttack = 8;
    final static float defaultDoubleDamageChance = 0.2f;
    private float doubleDamageChance;

    

    public Rogue(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, float evasion,
            float doubleDamageChance) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, evasion);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Rogue(String name) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, defaultEvasion, defaultDoubleDamageChance);
     }

    @Override
    public String getInfo() {
        return "Rogue";
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

}
