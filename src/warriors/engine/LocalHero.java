package warriors.engine;

public abstract class LocalHero implements warriors.contracts.Hero {
    protected String heroName;
    protected int lifeLevel;
    protected int attackLevel;

    public LocalHero(String heroName, int lifeLevel, int attackLevel) {
        this.heroName = heroName;
        this.lifeLevel = lifeLevel;
        this.attackLevel = attackLevel;
    }

    @Override
    public String getName() {
        return heroName;
    }

    @Override
    public int getLife() {
        return lifeLevel;
    }

    @Override
    public int getAttackLevel() {
        return attackLevel;
    }
}
