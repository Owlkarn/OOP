package Abstract;

import java.util.ArrayList;

import Interface.Coordinates;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack,
            float evasion, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.evasion = evasion;
    }

    private boolean isEmpty(ArrayList<BaseHero> team, Coordinates step) {
        for (BaseHero unit : team) {
            if (step.isEquals(unit.position))
                return false;
        }
        return true;
    }

    @Override
    public void Step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> alliesTeam) {
        ArrayList<BaseHero> allUnits = new ArrayList<>();
        for (BaseHero unit : alliesTeam)
            allUnits.add(unit);
        for (BaseHero unit : enemyTeam)
            allUnits.add(unit);

        BaseHero target = findNearest(enemyTeam);

        if (hp > 0) {
            if (getDistance(target) > Math.sqrt(2)) {
                if (target.position.getX() < this.position.getX()) {
                    if (target.position.getY() == this.position.getY()) {
                        // если впереди свободно - шагаем вперед
                        if (isEmpty(allUnits, new Coordinates(this.position.getX() - 1, this.position.getY())))
                            this.position.setX(this.position.getX() - 1);
                        // иначе, если снизу свободно и это не конец поля, то шагаем вниз
                        else if (this.position.getY() < 10 && isEmpty(allUnits, new Coordinates(this.position.getX(),
                                this.position.getY() + 1)))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если сверху свободно и это не конец поля, то шагаем вверх
                        else if (this.position.getY() > 10 && isEmpty(allUnits, new Coordinates(this.position.getX(),
                                this.position.getY() - 1)))
                            this.position.setX(this.position.getY() - 1);

                    } else if (target.position.getY() < this.position.getY()) {
                        // если вперед вверх свободно - шагаем вперед вверх
                        if (isEmpty(allUnits, new Coordinates(this.position.getX() - 1, this.position.getY() - 1))) {
                            this.position.setX(this.position.getX() - 1);
                            this.position.setY(this.position.getY() - 1);
                        }
                        // иначе, если сверху свободно, то шагаем вверх
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX(), this.position.getY() - 1)))
                            this.position.setX(this.position.getY() - 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX() - 1, this.position.getY())))
                            this.position.setX(this.position.getX() - 1);
                    } else if (target.position.getY() > this.position.getY()) {
                        // если вперед вниз свободно - шагаем вперед вниз
                        if (isEmpty(allUnits, new Coordinates(this.position.getX() - 1, this.position.getY() + 1))) {
                            this.position.setX(this.position.getX() - 1);
                            this.position.setY(this.position.getY() + 1);
                        }
                        // иначе, если снизу свободно, то шагаем вниз
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX(), this.position.getY() + 1)))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX() - 1, this.position.getY())))
                            this.position.setX(this.position.getX() - 1);
                    }

                }

                else {
                    if (target.position.getY() == this.position.getY()) {
                        // если впереди свободно - шагаем вперед
                        if (isEmpty(allUnits, new Coordinates(this.position.getX() + 1, this.position.getY())))
                            this.position.setX(this.position.getX() + 1);
                        // иначе, если снизу свободно и это не конец поля, то шагаем вниз
                        else if (this.position.getY() < 10 && isEmpty(allUnits, new Coordinates(this.position.getX(),
                                this.position.getY() + 1)))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если сверху свободно и это не конец поля, то шагаем вверх
                        else if (this.position.getY() > 10 && isEmpty(allUnits, new Coordinates(this.position.getX(),
                                this.position.getY() - 1)))
                            this.position.setX(this.position.getY() - 1);

                    } else if (target.position.getY() < this.position.getY()) {
                        // если вперед вверх свободно - шагаем вперед вверх
                        if (isEmpty(allUnits, new Coordinates(this.position.getX() + 1, this.position.getY() - 1))) {
                            this.position.setX(this.position.getX() + 1);
                            this.position.setY(this.position.getY() - 1);
                        }
                        // иначе, если сверху свободно, то шагаем вверх
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX(), this.position.getY() - 1)))
                            this.position.setX(this.position.getY() - 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX() + 1, this.position.getY())))
                            this.position.setX(this.position.getX() + 1);
                    } else if (target.position.getY() > this.position.getY()) {
                        // если вперед вниз свободно - шагаем вперед вниз
                        if (isEmpty(allUnits, new Coordinates(this.position.getX() + 1, this.position.getY() + 1))) {
                            this.position.setX(this.position.getX() + 1);
                            this.position.setY(this.position.getY() + 1);
                        }
                        // иначе, если снизу свободно, то шагаем вниз
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX(), this.position.getY() + 1)))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(allUnits, new Coordinates(this.position.getX() + 1, this.position.getY())))
                            this.position.setX(this.position.getX() + 1);
                    }
                }
            } else {
                float dmg = rndDamage(minDamage, maxDamage);
                Attack(findNearest(enemyTeam), dmg);
                System.out.println(this.type + " attacked " + findNearest(enemyTeam).type + " for " + dmg);
            }

            // System.out.println("My position: " + this.position.getX()+"
            // "+this.position.getY());
        }
        // for (int i = 0; i < positions.size(); i++) {
        // System.out.print("Array #" + i + ": " +
        // java.util.Arrays.toString(positions.get(i)));
        // }
        System.out.println();
    }
}
