package Units;

import Abstract.EvasionUsers;

public class Rogue extends EvasionUsers {

    final static int defaultHp = 100;
    final static int defaultSpeed = 50;
    final static int defaultDamage = 80;
    final static int defaultEvasion = 60; 
    final static float defaultDoubleDamageChance = 0.2f;
    private float doubleDamageChance;

    public Rogue(float hp, int speed, int damage, float evasion, float doubleDamageChance) {
        super(hp, speed, damage, evasion);
        this.doubleDamageChance = doubleDamageChance;
    }

    public Rogue() {
        this(defaultHp, defaultSpeed, defaultDamage, defaultEvasion, defaultDoubleDamageChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Rogue";
    }

}
