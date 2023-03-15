package Units;

import Abstract.ManaUsers;

public class Warlock extends ManaUsers {

    protected float doubleCastChance;

    public Warlock(float hp, int speed, int damage, int mana, float doubleCastChance) {
        super(hp, speed, damage, mana);
        this.doubleCastChance = doubleCastChance;
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Warlock";
    }
    
}
