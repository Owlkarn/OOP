package Abstract;

public abstract class ManaUsers extends BaseHero {
    
    protected int mana;

    public ManaUsers(int maxHp, float hp, int speed, int damage, int mana) {
        super(maxHp, hp, speed, damage);
        this.mana = mana;
    }    
}
