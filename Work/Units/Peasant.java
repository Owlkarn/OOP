package Units;

import Abstract.BaseHero;

public class Peasant extends BaseHero {

    public Peasant() {
        super(50, 20, 30);
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }
    
}
