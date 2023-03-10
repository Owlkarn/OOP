package Units;

public class AgilityUsers extends BaseHero {

    protected int evasion;

    public AgilityUsers(float hp, int speed, int damage, int evasion) {
        super(hp, speed, damage);
        this.evasion = evasion;
    }    

}
