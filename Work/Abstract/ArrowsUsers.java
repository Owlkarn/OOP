package Abstract;

public abstract class ArrowsUsers extends BaseHero {

    protected int arrows;

    public ArrowsUsers(float hp, int speed, int damage, int arrows) {
        super(hp, speed, damage);
        this.arrows = arrows;
    }    

    
}
