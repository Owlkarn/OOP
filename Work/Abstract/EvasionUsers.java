package Abstract;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(float hp, int speed, float damage, int defence, String name, int attack, float evasion) {
        super(hp, speed, damage, defence, name, attack);
        this.evasion = evasion;
    }
}
