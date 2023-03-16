package Units;

import java.util.Random;

import Abstract.EvasionUsers;

public class Rogue extends EvasionUsers {

    final static int defaultHp = 10;
    final static int defaultSpeed = 6;
    final static float defaultDamage = new Random().nextFloat(2f, 4f);;
    final static float defaultEvasion = 0.2f; 
    final static int defaultDefence = 3;
    final static int defaultAttack = 8;
    final static float defaultDoubleDamageChance = 0.2f;
    private float doubleDamageChance;

    

    public Rogue(float hp, int speed, float damage, int defence, String name, int attack, float evasion,
            float doubleDamageChance) {
        super(hp, speed, damage, defence, name, attack, evasion);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Rogue(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultEvasion, defaultDoubleDamageChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Rogue";
    }

}
