package Units;

import Abstract.ManaUsers;

public class Monk extends ManaUsers{

    final static int defaultHp = 30;
    final static int defaultSpeed = 5;
    final static float defaultDamage = -4;
    final static int defaultMana = 1; 
    final static int defaultDefence = 7;
    final static int defaultAttack = 12; 
    final static float defaultPrayChance = 0.2f;
    private float prayChance;

    public Monk(float hp, int speed, float damage, int defence, String name, int attack, int mana, float prayChance) {
        super(hp, speed, damage, defence, name, attack, mana);
        this.prayChance = prayChance;
    }

    public Monk(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultMana, defaultPrayChance);
     }

    @Override
    public String getInfo() {
        return "Monk";
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }
       
}
