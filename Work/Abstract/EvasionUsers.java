package Abstract;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(float hp, int speed, int damage, float evasion) {
        super(hp, speed, damage);
        this.evasion = evasion;
    }    

}
