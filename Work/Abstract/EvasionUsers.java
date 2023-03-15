package Abstract;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(int maxHp, float hp, int speed, int damage, float evasion) {
        super(maxHp, hp, speed, damage);
        this.evasion = evasion;
    }    

}
