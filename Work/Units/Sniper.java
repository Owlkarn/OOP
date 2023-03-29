package Units;

import Abstract.ArrowsUsers;
import Interface.Coordinates;

public class Sniper extends ArrowsUsers {

    final static int defaultMaxHp = 15;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 9;
    final static int defaultMinDamage = 8;
    final static int defaultMaxDamage = 10; 
    final static int defaultArrows = 32; 
    final static int defaultDefence = 10;
    final static int defaultAttack = 12;
    final static float defaultDoubleDamageChance = 0.2f;
    final static String type = "Sniper";
    private Coordinates position;
    private float doubleDamageChance;

    

    public Sniper(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int arrows,
            float doubleDamageChance, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, arrows, position, type, maxHp);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Sniper(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultArrows, defaultDoubleDamageChance, position, type, defaultMaxHp);
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
