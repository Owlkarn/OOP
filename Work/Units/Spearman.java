package Units;

import java.util.Random;

import Abstract.EvasionUsers;

public class Spearman extends EvasionUsers {

    final static int defaultHp = 10;
    final static int defaultSpeed = 4;
    final static float defaultDamage = new Random().nextFloat(1f, 3f);;
    final static float defaultEvasion = 0.2f; 
    final static int defaultDefence = 5;
    final static int defaultAttack = 4; 
    final static float defaultBlockChance = 0.2f;
    private float blockChance;

    

    public Spearman(float hp, int speed, float damage, int defence, String name, int attack, float evasion,
            float blockChance) {
        super(hp, speed, damage, defence, name, attack, evasion);
        this.blockChance = blockChance;
    }

    public Spearman(String name) {
        this(defaultHp, defaultSpeed, defaultDamage, defaultDefence, name, defaultAttack, defaultEvasion, defaultBlockChance);
     }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Spearman";
    }
    
}
