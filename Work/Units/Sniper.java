package Units;

import Abstract.ArrowsUsers;

public class Sniper extends ArrowsUsers {

    final static int defaultHp = 100;
    final static int defaultSpeed = 50;
    final static int defaultDamage = 80;
    final static int defaultArrows = 60; 
    final static float defaultDoubleDamageChance = 0.2f;
    private float doubleDamageChance;

    public Sniper(float hp, int speed, int damage, int arrows, float doubleDamageChance) {
        super(hp, speed, damage, arrows);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Sniper() {
        this(defaultHp, defaultSpeed, defaultDamage, defaultArrows, defaultDoubleDamageChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Sniper";
    }
    
}
