package warriors.engine;

public class Weapon extends Event{

    public Weapon(String name, int attackLevel){
        super(name, 0, attackLevel, "weapon");
    }

    public String toString(){
        return "Vous trouvez une arme qui est un" + name + "avec" + attackLevel + "points d'attaque.";
    }
}
