package Units;

import Abstract.EvasionUsers;

public class Spearman extends EvasionUsers {

    final static int defaultHp = 100;
    final static int defaultSpeed = 50;
    final static int defaultDamage = 80;
    final static int defaultEvasion = 60; 
    final static float defaultBlockChance = 0.2f;
    private float blockChance;

    public Spearman(float hp, int speed, int damage, float evasion, float blockChance) {
        super(hp, speed, damage, evasion);
        this.blockChance = blockChance;
    }

    public Spearman() {
        this(defaultHp, defaultSpeed, defaultDamage, defaultEvasion, defaultBlockChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Spearman";
    }
    
}
