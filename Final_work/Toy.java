package Final_work;

public class Toy {
    protected int id;
    protected String name;
    protected int count;
    protected int chance;

    public Toy(int id, String name, int count, int chance) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    
}
