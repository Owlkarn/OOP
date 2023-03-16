package Units;

import Abstract.BaseHero;

public class Peasant extends BaseHero {

    final static int defaultHp = 1;
    final static int defaultSpeed = 3;
    final static float defaultDamage = 1; 
    final static int defaultDefence = 1;
    final static int defaultAttack = 1; 
    final static int defaultDelivery = 1;
    final static String defaultInfo = "Peasant";
    private int delivery;
    private String info;  

    public Peasant(float hp, int speed, float damage, int defence, String name, int attack, int delivery, String info) {
        super(hp, speed, damage, defence, name, attack);
        this.delivery = delivery;
        this.info = info;
    }

    public Peasant(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultDelivery, defaultInfo);
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
