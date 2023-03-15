package Units;

import Abstract.EvasionUsers;

public class Rogue extends EvasionUsers {

    protected float doubleDamageChance;

    public Rogue(float hp, int speed, int damage, float evasion, float doubleDamageChance) {
        super(hp, speed, damage, evasion);
        this.doubleDamageChance = doubleDamageChance;
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
