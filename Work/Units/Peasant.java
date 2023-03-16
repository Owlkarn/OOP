package Units;

import Abstract.BaseHero;

public class Peasant extends BaseHero {

    final static int defaultHp = 30;
    final static int defaultSpeed = 5;
    final static float defaultDamage = -4; 
    final static int defaultDefence = 7;
    final static int defaultAttack = 12; 
    final static int defaultDelivery = 1;
    static String defaultInfo = "Peasant";
    private int delivery;
    private String info;  

    public Peasant(float hp, int speed, float damage, int defence, String name, int attack, int delivery) {
        super(hp, speed, damage, defence, name, attack);
        this.delivery = delivery;
    }

    public Peasant(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultDelivery);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return defaultInfo;
    }

    public void setInfo(String info) {
        defaultInfo = info;
    }

    
    
    
}
