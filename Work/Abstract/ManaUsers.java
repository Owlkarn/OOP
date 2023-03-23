package Abstract;

import Interface.Coordinates;

public abstract class ManaUsers extends BaseHero {
    
    protected int mana;

    public ManaUsers(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack,
     int mana, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.mana = mana;
    }       
}
