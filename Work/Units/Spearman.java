package Units;

import Abstract.EvasionUsers;

public class Spearman extends EvasionUsers {

    protected float blockChance;

    public Spearman(float hp, int speed, int damage, float evasion, float blockChance) {
        super(hp, speed, damage, evasion);
        this.blockChance = blockChance;
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
