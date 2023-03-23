package Abstract;

import Interface.Coordinates;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack, 
    float evasion, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.evasion = evasion;
    }
}
