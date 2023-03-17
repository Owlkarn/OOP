package Units;

import Abstract.ManaUsers;

public class Warlock extends ManaUsers {

    final static int defaultHp = 30;
    final static int defaultSpeed = 9;
    final static int defaultMinDamage = -5;
    final static int defaultMaxDamage = -5;
    final static int defaultMana = 1; 
    final static int defaultDefence = 12;
    final static int defaultAttack = 17;  
    final static float defaultDoubleCastChance = 0.2f;
    private float doubleCastChance;

    

    public Warlock(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int mana,
            float doubleCastChance) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, mana);
        this.doubleCastChance = doubleCastChance;
    }

    public Warlock(String name) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, defaultMana, defaultDoubleCastChance);
     }

    @Override
    public String getInfo() {
        return "Warlock";
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }
    
}
