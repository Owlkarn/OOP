package Units;

import java.util.Random;

import Abstract.EvasionUsers;
import Interface.Coordinates;

public class Spearman extends EvasionUsers {

    final static int defaultMaxHp = 10;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 4;
    final static int defaultMinDamage = 1;
    final static int defaultMaxDamage = 3;
    final static float defaultEvasion = 0.2f; 
    final static int defaultDefence = 5;
    final static int defaultAttack = 4; 
    final static float defaultBlockChance = 0.2f;
    final static String type = "Spearman";
    private Coordinates position;
    private float blockChance;

    

    public Spearman(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, float evasion,
            float blockChance, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, evasion, position, type, maxHp);
        this.blockChance = blockChance;
    }

    public Spearman(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultEvasion, defaultBlockChance, position, type, defaultMaxHp);
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
