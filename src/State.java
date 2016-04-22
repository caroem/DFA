public class State {
    public int state;
    public boolean isFinal;
    public boolean isInitial;

    public State(int state, boolean isFinal, boolean isInitial) {
        this.state = state;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
    }
}