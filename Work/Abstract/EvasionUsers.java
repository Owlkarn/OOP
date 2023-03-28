package Abstract;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Interface.Coordinates;

public abstract class EvasionUsers extends BaseHero {

    protected float evasion;

    public EvasionUsers(float hp, int speed, int minDamage, int maxDamage, int defence, String name, int attack,
            float evasion, Coordinates position, String type, int maxHp) {
        super(hp, speed, minDamage, maxDamage, defence, name, attack, position, type, maxHp);
        this.evasion = evasion;
    }

    private boolean isEmpty(ArrayList<int[]> positions, int stepX, int stepY) {
        int[] stepXY = { stepX, stepY };
        return !positions.contains(stepXY);
    }

    @Override
    public void Step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> alliesTeam) {
        ArrayList<int[]> positions = new ArrayList<>();
        for (BaseHero unit : alliesTeam) {
            int[] posXY = { unit.position.getX(), unit.position.getY() };
            positions.add(posXY);
        }
        for (BaseHero unit : enemyTeam) {
            int[] posXY = { unit.position.getX(), unit.position.getY() };
            positions.add(posXY);
        }

        if (hp > 0) {
            if (getDistance(findNearest(enemyTeam)) > Math.sqrt(2)) {
                if (findNearest(enemyTeam).position.getX() < this.position.getX()) {
                    if (findNearest(enemyTeam).position.getY() == this.position.getY()) {
                        // если впереди свободно - шагаем вперед
                        if (isEmpty(positions, this.position.getX() - 1, this.position.getY()))
                            this.position.setX(this.position.getX() - 1);
                        // иначе, если снизу свободно и это не конец поля, то шагаем вниз
                        else if (this.position.getY() < 10 && isEmpty(positions, this.position.getX(),
                                this.position.getY() + 1))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если сверху свободно и это не конец поля, то шагаем вверх
                        else if (this.position.getY() > 10 && isEmpty(positions, this.position.getX(),
                                this.position.getY() - 1))
                            this.position.setX(this.position.getY() - 1);

                    } else if (findNearest(enemyTeam).position.getY() < this.position.getY()) {
                        // если вперед вверх свободно - шагаем вперед вверх
                        if (isEmpty(positions, this.position.getX() - 1, this.position.getY() - 1)) {
                            this.position.setX(this.position.getX() - 1);
                            this.position.setY(this.position.getY() - 1);
                        }
                        // иначе, если сверху свободно, то шагаем вверх
                        else if (isEmpty(positions, this.position.getX(), this.position.getY() - 1))
                            this.position.setX(this.position.getY() - 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(positions, this.position.getX() - 1, this.position.getY()))
                            this.position.setX(this.position.getX() - 1);
                    } else if (findNearest(enemyTeam).position.getY() > this.position.getY()) {
                        // если вперед вниз свободно - шагаем вперед вниз
                        if (isEmpty(positions, this.position.getX() - 1, this.position.getY() + 1)) {
                            this.position.setX(this.position.getX() - 1);
                            this.position.setY(this.position.getY() + 1);
                        }
                        // иначе, если снизу свободно, то шагаем вниз
                        else if (isEmpty(positions, this.position.getX(), this.position.getY() + 1))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(positions, this.position.getX() - 1, this.position.getY()))
                            this.position.setX(this.position.getX() - 1);
                    }

                }

                else {
                    if (findNearest(enemyTeam).position.getY() == this.position.getY()) {
                        // если впереди свободно - шагаем вперед
                        if (isEmpty(positions, this.position.getX() + 1, this.position.getY()))
                            this.position.setX(this.position.getX() + 1);
                        // иначе, если снизу свободно и это не конец поля, то шагаем вниз
                        else if (this.position.getY() < 10 && isEmpty(positions, this.position.getX(),
                                this.position.getY() + 1))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если сверху свободно и это не конец поля, то шагаем вверх
                        else if (this.position.getY() > 10 && isEmpty(positions, this.position.getX(),
                                this.position.getY() - 1))
                            this.position.setX(this.position.getY() - 1);

                    } else if (findNearest(enemyTeam).position.getY() < this.position.getY()) {
                        // если вперед вверх свободно - шагаем вперед вверх
                        if (isEmpty(positions, this.position.getX() + 1, this.position.getY() - 1)) {
                            this.position.setX(this.position.getX() + 1);
                            this.position.setY(this.position.getY() - 1);
                        }
                        // иначе, если сверху свободно, то шагаем вверх
                        else if (isEmpty(positions, this.position.getX(), this.position.getY() - 1))
                            this.position.setX(this.position.getY() - 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(positions, this.position.getX() + 1, this.position.getY()))
                            this.position.setX(this.position.getX() + 1);
                    } else if (findNearest(enemyTeam).position.getY() > this.position.getY()) {
                        // если вперед вниз свободно - шагаем вперед вниз
                        if (isEmpty(positions, this.position.getX() + 1, this.position.getY() + 1)) {
                            this.position.setX(this.position.getX() + 1);
                            this.position.setY(this.position.getY() + 1);
                        }
                        // иначе, если снизу свободно, то шагаем вниз
                        else if (isEmpty(positions, this.position.getX(), this.position.getY() + 1))
                            this.position.setX(this.position.getY() + 1);
                        // иначе, если вперед свободно, то шагаем вперед
                        else if (isEmpty(positions, this.position.getX() + 1, this.position.getY()))
                            this.position.setX(this.position.getX() + 1);
                    }
                }
            } else {
                Attack(findNearest(enemyTeam), rndDamage(minDamage, maxDamage));
                System.out.println("Attack: " + findNearest(enemyTeam).type);
            }

            // System.out.println("My position: " + this.position.getX()+"
            // "+this.position.getY());
        }
        // for (int i = 0; i < positions.size(); i++) {
        //     System.out.print("Array #" + i + ": " + java.util.Arrays.toString(positions.get(i)));
        // }
        System.out.println();
        positions.clear();
    }
}
