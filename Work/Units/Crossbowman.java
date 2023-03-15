package Units;

import Abstract.ArrowsUsers;

public class Crossbowman extends ArrowsUsers {

    final static int defaultHp = 100;
    final static int defaultSpeed = 50;
    final static int defaultDamage = 80;
    final static int defaultArrows = 60; 
    final static float defaultStunChance = 0.2f;
    private float stunChance;

    public Crossbowman(float hp, int speed, int damage, int arrows, float stunChance) {
        super(hp, speed, damage, arrows);
        this.stunChance = stunChance;
    }

    public Crossbowman() {
        this(defaultHp, defaultSpeed, defaultDamage, defaultArrows, defaultStunChance);
     }



    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }
    
    
}
