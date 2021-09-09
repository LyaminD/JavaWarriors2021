package warriors.engine;

public class Case {
    private Events event;

    public Case(Events event) {
        this.event = event;
    }

    public Events getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}