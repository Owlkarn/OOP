package Abstract;

public abstract class ArrowsUsers extends BaseHero {

    protected int arrows;

    public ArrowsUsers(float hp, int speed, float damage, int defence, String name, int attack, int arrows) {
        super(hp, speed, damage, defence, name, attack);
        this.arrows = arrows;
    }

     

    
}
