package Units;

import Abstract.ManaUsers;
import Interface.Coordinates;

public class Monk extends ManaUsers{

    final static int defaultMaxHp = 30;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 5;
    final static int defaultMinDamage = -4;
    final static int defaultMaxDamage = -4;
    final static int defaultMana = 1; 
    final static int defaultDefence = 7;
    final static int defaultAttack = 12; 
    final static float defaultPrayChance = 0.2f;
    final static String type = "Monk";
    private Coordinates position;
    private float prayChance;

    public Monk(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int mana, 
    float prayChance, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, mana, position, type, maxHp);
        this.prayChance = prayChance;
    }

    public Monk(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultMana, defaultPrayChance, position, type, defaultMaxHp);
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
