package Abstract;

import java.util.ArrayList;
import java.util.Random;

import Interface.HeroInterface;

public abstract class BaseHero implements HeroInterface {

    protected int maxHp;
    public float hp;
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

    public void Step (ArrayList<BaseHero> team, ArrayList<BaseHero> team2) {
    }

    public void healed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    public void GetDamage(float damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }

    public void Attack(BaseHero target, float damage) {
        target.GetDamage(damage);
        System.out.printf("%s %s attacks %s %s\n", this.getInfo(), this.getName(), target.getInfo(), target.getName());
        System.out.printf("Damage deal %.2f\n", damage);
        System.out.printf("%s %s hp = %.2f\n", target.getInfo(), target.getName(), target.hp);
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

}
