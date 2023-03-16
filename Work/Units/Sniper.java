package Units;

import java.util.Random;

import Abstract.ArrowsUsers;

public class Sniper extends ArrowsUsers {

    final static int defaultHp = 15;
    final static int defaultSpeed = 9;
    final static float defaultDamage = new Random().nextFloat(8f, 10f);
    final static int defaultArrows = 32; 
    final static int defaultDefence = 10;
    final static int defaultAttack = 12;
    final static float defaultDoubleDamageChance = 0.2f;
    private float doubleDamageChance;

    

    public Sniper(float hp, int speed, float damage, int defence, String name, int attack, int arrows,
            float doubleDamageChance) {
        super(hp, speed, damage, defence, name, attack, arrows);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Sniper(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultArrows, defaultDoubleDamageChance);
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
