package Abstract;

import java.util.ArrayList;
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
    public String type;

    protected static Random rnd;

    static {
        BaseHero.rnd = new Random();
    }

    public BaseHero(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack,
            Coordinates position, String type, int maxHp) {
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defence = defence;
        this.name = name;
        this.attack = attack;
        this.position = position;
        this.type = this.getClass().getName().split("\\.")[1];
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
        else this.hp = 0;
    }

    public float rndDamage(int a, int b) {
        return new Random().nextFloat(a, b);
    }

    public void Attack(BaseHero target, float damage) {
        target.GetDamage(damage);
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public float getDistance(BaseHero unit) {
        return (float) Math.sqrt(Math.pow(this.position.getX() - unit.position.getX(), 2) +
                Math.pow(this.position.getY() - unit.position.getY(), 2));
    }

    public BaseHero findNearest(ArrayList<BaseHero> team) {
        float targetDistance = this.getDistance(team.get(0));
        BaseHero target = team.get(0);
        for (BaseHero unit : team) {
            if (unit.hp > 0 && this.getDistance(unit) < targetDistance) {
                target = unit;
                targetDistance = this.getDistance(unit);
            }
        }
        return target;
    }

    public Coordinates getPosition() {
        return this.position;
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\tAtt %-3d\tDef %-3d\tHp %-3d%%\tDmg %-3d\t ",
                type, attack, defence, (int) hp * 100 / maxHp, (minDamage + maxDamage) / 2);
        return outStr;
    }

    public String getType() {
        return "";
    }
}
