package Units;

import java.util.Random;

import Abstract.EvasionUsers;
import Interface.Coordinates;

public class Rogue extends EvasionUsers {

    final static int defaultMaxHp = 10;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 6;
    final static int defaultMinDamage = 2;
    final static int defaultMaxDamage = 4; 
    final static float defaultEvasion = 0.2f; 
    final static int defaultDefence = 3;
    final static int defaultAttack = 8;
    final static float defaultDoubleDamageChance = 0.2f;
    final static String type = "Rogue";
    private Coordinates position;
    private float doubleDamageChance;

    

    public Rogue(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, float evasion,
            float doubleDamageChance, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, evasion, position, type, maxHp);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Rogue(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultEvasion, defaultDoubleDamageChance, position, type, defaultMaxHp);
     }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

}
