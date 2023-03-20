package Units;

import java.util.Random;

import Abstract.EvasionUsers;
import Interface.Coordinates;

public class Spearman extends EvasionUsers {

    final static int defaultHp = 10;
    final static int defaultSpeed = 4;
    final static int defaultMinDamage = 1;
    final static int defaultMaxDamage = 3;
    final static float defaultEvasion = 0.2f; 
    final static int defaultDefence = 5;
    final static int defaultAttack = 4; 
    final static float defaultBlockChance = 0.2f;
    private Coordinates position;
    private float blockChance;

    

    public Spearman(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, float evasion,
            float blockChance, Coordinates position) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, evasion, position);
        this.blockChance = blockChance;
    }

    public Spearman(String name, Coordinates position) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultEvasion, defaultBlockChance, position);
     }

    @Override
    public String getInfo() {
        return "Spearman";
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }
    
}
