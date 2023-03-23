package Units;

import java.util.ArrayList;
import java.util.Random;

import Abstract.ArrowsUsers;
import Abstract.BaseHero;
import Interface.Coordinates;

public class Crossbowman extends ArrowsUsers {

    final static int defaultMaxHp = 10;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 4;
    final static int defaultMinDamage = 2;
    final static int defaultMaxDamage = 3;
    final static int defaultArrows = 16; 
    final static float defaultStunChance = 0.2f;
    final static int defaultDefence = 3;
    final static int defaultAttack = 6;
    private Coordinates position;
    private float stunChance;
    final static String type = "Crossbowman";

    public Crossbowman(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int arrows,
            float stunChance, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, arrows, position, type, maxHp);
        this.stunChance = stunChance;
    }

    public Crossbowman(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultArrows, defaultStunChance, position, type, defaultMaxHp);
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
