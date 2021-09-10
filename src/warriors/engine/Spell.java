package warriors.engine;

public class Spell extends Event{

    public Spell(String name, int attackLevel){
        super(name, 0, attackLevel, "spell");
    }

    public String toString(){
        return "Vous trouvez un sort" + name + " avec" + attackLevel + "points d'attaque.";
    }
}
