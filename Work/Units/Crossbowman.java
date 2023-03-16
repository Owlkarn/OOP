package Units;

import java.util.Random;

import Abstract.ArrowsUsers;

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
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }

    public static int getDefaulthp() {
        return defaultHp;
    }

    public static int getDefaultspeed() {
        return defaultSpeed;
    }

    public static float getDefaultdamage() {
        return defaultDamage;
    }

    public static int getDefaultarrows() {
        return defaultArrows;
    }

    public static float getDefaultstunchance() {
        return defaultStunChance;
    }

    public static int getDefaultdefence() {
        return defaultDefence;
    }

    public static int getDefaultattack() {
        return defaultAttack;
    }

    public float getStunChance() {
        return stunChance;
    }
    
    
}
