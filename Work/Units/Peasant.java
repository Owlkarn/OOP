package Units;

import Abstract.BaseHero;
import Interface.Coordinates;

public class Peasant extends BaseHero {

    final static int defaultHp = 1;
    final static int defaultSpeed = 3;
    final static int defaultMinDamage = 1;
    final static int defaultMaxDamage = 1; 
    final static int defaultDefence = 1;
    final static int defaultAttack = 1; 
    final static int defaultDelivery = 1;
    final static String defaultInfo = "Peasant";
    private Coordinates position;
    private int delivery;
    private String info;  

    public Peasant(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, int delivery, String info, Coordinates position) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position);
        this.delivery = delivery;
        this.info = info;
    }

    public Peasant(String name, Coordinates position) {
        this(defaultHp, defaultSpeed, defaultMinDamage, defaultMaxDamage, defaultDefence, name, defaultAttack, 
        defaultDelivery, defaultInfo, position);
    }

    @Override
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }    
}
