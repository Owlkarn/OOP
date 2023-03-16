package Abstract;

public abstract class ManaUsers extends BaseHero {
    
    protected int mana;

    public ManaUsers(float hp, int speed, float damage, int defence, String name, int attack, int mana) {
        super(hp, speed, damage, defence, name, attack);
        this.mana = mana;
    }       
}
