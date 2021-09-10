package warriors.engine;

public class Enemy extends Event{

    public Enemy(String name, int attackLevel, int lifeLevel){
        super(name, lifeLevel, attackLevel, "Enemy");
    }

    public String  toString(){
        return "Vous rencontrez un" + name + ", il a" + attackLevel + "attaques et" + lifeLevel + "points de vie.";
    }
}
