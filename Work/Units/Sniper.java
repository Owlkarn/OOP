package Units;

import Abstract.ArrowsUsers;

public class Sniper extends ArrowsUsers {

    protected float doubleDamageChance;

    public Sniper(float hp, int speed, int damage, int arrows, float doubleDamageChance) {
        super(hp, speed, damage, arrows);
        this.doubleDamageChance = doubleDamageChance;
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
