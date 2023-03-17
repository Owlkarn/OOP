package Units;

import java.util.ArrayList;
import java.util.Random;

import Abstract.ArrowsUsers;
import Abstract.BaseHero;
import Interface.Coordinates;

public class Crossbowman extends ArrowsUsers {

    final static int defaultHp = 10;
    final static int defaultSpeed = 4;
    final static int defaultMinDamage = 2;
    final static int defaultMaxDamage = 3;
    final static int defaultArrows = 16; 
    final static float defaultStunChance = 0.2f;
    final static int defaultDefence = 3;
    final static int defaultAttack = 6;
    private Coordinates position;
    private float stunChance;

    public Crossbowman(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int arrows,
            float stunChance, Coordinates position) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, arrows, position);
        this.stunChance = stunChance;
    }

    public Crossbowman(String name, Coordinates position) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultArrows, defaultStunChance, position);
     }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }
    
    
}
