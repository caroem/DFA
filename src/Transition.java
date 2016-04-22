public class Transition {
    public char input;
    public State source;
    public State destination;

    public Transition(State source, State destination, char input) {
        this.input = input;
        this.source = source;
        this.destination = destination;
    }
}