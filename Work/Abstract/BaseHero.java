package Abstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Interface.Coordinates;
import Interface.HeroInterface;

public abstract class BaseHero implements HeroInterface {

    protected int maxHp;
    public float hp;
    protected int speed;
    protected int minDamage;
    protected int maxDamage;
    protected int defence;
    protected String name;
    protected int attack;
    public Coordinates position;

    protected static Random rnd;

    static {
        BaseHero.rnd = new Random();
    }

    public BaseHero(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack,
            Coordinates position) {
        this.hp = hp;
        this.speed = speed;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defence = defence;
        this.name = name;
        this.attack = attack;
        this.position = position;
    }

    public void Step(ArrayList<BaseHero> team, ArrayList<BaseHero> team2) {
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
        System.out.printf("%s %s (%d, %d) attacks %s %s (%d, %d)\n",
                this.getInfo(), this.getName(), this.position.getX(), this.position.getY(),
                target.getInfo(), target.getName(), target.position.getX(), target.position.getY());
        System.out.printf("Damage deal %.2f\n", damage);
        System.out.printf("%s %s hp = %.2f\n", target.getInfo(), target.getName(), target.hp);
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public float getDistance(BaseHero unit) {
        return (float) Math.sqrt(Math.pow(this.position.getX() - unit.position.getX(), 2) +
                Math.pow(this.position.getY() - unit.position.getY(), 2));
    }

    public BaseHero findNearest(ArrayList<BaseHero> team) {
        float targetDistance = this.getDistance(team.get(0));
        BaseHero target = team.get(0);
        for (BaseHero unit : team) {
            if (this.getDistance(unit) < targetDistance) {
                target = unit;
                targetDistance = this.getDistance(unit);
            }
        }
        return target;
    }
}
