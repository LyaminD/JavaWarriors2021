package warriors.engine;

public class Potion extends Event{

    public Potion(String name, int lifeLevel){
        super(name ,lifeLevel, 0, "Potion");
    }

    public String toString(){
        return "C'est une " + name + " elle vous rend " + lifeLevel + " points de vie.";
    }
}