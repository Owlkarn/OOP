package Units;

import Abstract.ManaUsers;
import Interface.Coordinates;

public class Warlock extends ManaUsers {

    final static int defaultMaxHp = 30;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 9;
    final static int defaultMinDamage = 0;
    final static int defaultMaxDamage = 0;
    final static int defaultHeal = -5; 
    final static int defaultDefence = 12;
    final static int defaultAttack = 17;  
    final static float defaultDoubleCastChance = 0.2f;
    final static String type = "Warlock";
    private Coordinates position;
    private float doubleCastChance;

    

    public Warlock(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int heal,
            float doubleCastChance, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, heal, position, type, maxHp);
        this.doubleCastChance = doubleCastChance;
    }

    public Warlock(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultHeal, defaultDoubleCastChance, position, type, defaultMaxHp);
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
