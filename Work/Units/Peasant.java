package Units;

import Abstract.BaseHero;
import Interface.Coordinates;

public class Peasant extends BaseHero {

    final static int defaultMaxHp = 1;
    static float hp = defaultMaxHp;
    final static int defaultSpeed = 3;
    final static int defaultMinDamage = 1;
    final static int defaultMaxDamage = 1; 
    final static int defaultDefence = 1;
    final static int defaultAttack = 1; 
    final static int defaultDelivery = 1;
    private static String type = "Peasant";
    private Coordinates position;
    private int delivery; 

    public Peasant(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, 
    int delivery, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.delivery = delivery;
    }

    public Peasant(String name, Coordinates position) {
        this(hp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultDelivery, position, type, defaultMaxHp);
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getType() {
        return type;
    }

    public static void setType(String type) {
        Peasant.type = type;
    }   
}
