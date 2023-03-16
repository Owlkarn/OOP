package Abstract;

import java.util.Random;

import Interface.HeroInterface;

public abstract class BaseHero implements HeroInterface {

    protected int maxHp;
    protected float hp;
    protected int speed;
    protected float damage;
    protected int defence;
    protected String name;
    protected int attack;

    protected static Random rnd;

    static {
        BaseHero.rnd = new Random();
    }

    public BaseHero(float hp, int speed, float damage, int defence, String name, int attack) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.defence = defence;
        this.name = name;
        this.attack = attack;
    }

    public void healed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }

    public void Attack(BaseHero target) {
        int damage = BaseHero.rnd.nextInt(10, 20);
        target.GetDamage(damage);
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

}
