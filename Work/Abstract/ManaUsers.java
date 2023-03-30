package Abstract;

import java.util.ArrayList;
import java.util.Comparator;

import Interface.Coordinates;

public abstract class ManaUsers extends BaseHero {

    protected int heal;

    public ManaUsers(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack,
            int heal, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.heal = heal;
    }

    private int hpPercent(BaseHero unit) {
        return (int) unit.getHp() * 100 / unit.getMaxHp();
    }

    @Override
    public void Step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> alliesTeam) {
        if (this.hp > 0) {
            ArrayList<BaseHero> alliesHpSort = new ArrayList<>();
            alliesHpSort.addAll(0, alliesTeam);
            alliesHpSort.sort(new Comparator<BaseHero>() {
                @Override
                public int compare(BaseHero u1, BaseHero u2) {
                    if (hpPercent(u1) == hpPercent(u2)) {
                        if (u1.getHp() < u2.getHp())
                            return -1;
                        else if (u1.getHp() > u2.getHp())
                            return 1;
                        else
                            return 0;
                    } else if (hpPercent(u1) < hpPercent(u2))
                        return -1;
                    else
                        return 1;
                }
            });
            for (BaseHero unit : alliesHpSort) {
                if (unit.hp != 0 && unit.hp < unit.maxHp){
                    Attack(unit, this.heal);
                    System.out.println(this.type + " healed " + unit.type + " for " + this.heal);
                    if (unit.hp > unit.maxHp) unit.hp = unit.maxHp;
                    break;
                }
                
            }
        }
    }
}
