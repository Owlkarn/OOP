package Units;

import Abstract.ManaUsers;
import Interface.Coordinates;

public class Monk extends ManaUsers{

    final static int defaultHp = 30;
    final static int defaultSpeed = 5;
    final static int defaultMinDamage = -4;
    final static int defaultMaxDamage = -4;
    final static int defaultMana = 1; 
    final static int defaultDefence = 7;
    final static int defaultAttack = 12; 
    final static float defaultPrayChance = 0.2f;
    private Coordinates position;
    private float prayChance;

    public Monk(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int mana, float prayChance, Coordinates position) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, mana, position);
        this.prayChance = prayChance;
    }

    public Monk(String name, Coordinates position) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultMana, defaultPrayChance, position);
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
