package Units;

import Abstract.ManaUsers;

public class Monk extends ManaUsers{

    final static int defaultHp = 100;
    final static int defaultSpeed = 50;
    final static int defaultDamage = 80;
    final static int defaultMana = 60; 
    final static float defaultPrayChance = 0.2f;
    private float prayChance;

    public Monk(float hp, int speed, int damage, int mana, float prayChance) {
        super(hp, speed, damage, mana);
        this.prayChance = prayChance;
    }

    public Monk() {
        this(defaultHp, defaultSpeed, defaultDamage, defaultMana, defaultPrayChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Monk";
    }
       
}
