package Units;

import Abstract.ManaUsers;

public class Warlock extends ManaUsers {

    final static int defaultHp = 100;
    final static int defaultSpeed = 50;
    final static int defaultDamage = 80;
    final static int defaultMana = 60; 
    final static float defaultDoubleCastChance = 0.2f;
    private float doubleCastChance;

    public Warlock(float hp, int speed, int damage, int mana, float doubleCastChance) {
        super(hp, speed, damage, mana);
        this.doubleCastChance = doubleCastChance;
    }

    public Warlock() {
        this(defaultHp, defaultSpeed, defaultDamage, defaultMana, defaultDoubleCastChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Warlock";
    }
    
}
