package Abstract;

public abstract class ManaUsers extends BaseHero {
    
    protected int mana;

    public ManaUsers(float hp, int speed, int damage, int mana) {
        super(hp, speed, damage);
        this.mana = mana;
    }    
}
