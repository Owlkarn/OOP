package Units;

import Abstract.ManaUsers;

public class Monk extends ManaUsers{

    protected float prayChance;

    public Monk(float hp, int speed, int damage, int mana, float prayChance) {
        super(hp, speed, damage, mana);
        this.prayChance = prayChance;
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Monk";
    }
       
}
