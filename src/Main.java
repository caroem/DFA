/**
 * Created by caroem on 22.04.16.
 */
public class Main {
    public static void main(String[] args) {
        DFA dea = new DFA();
        dea.addState(0, false, true);
        dea.addState(1, true, false);
        dea.addState(2, false, false);
        dea.addState(3, false, false);
        dea.addState(4, true, false);
        dea.addState(5, true, false);
        dea.addState(6, false, false);
        dea.addState(-1, false, false);
        dea.setInitialState();
        dea.setErrorState(-1);
        dea.addTransition(0, 1, 'n');
        dea.addTransition(0, 2, '.');
        dea.addTransition(1, 2, '.');
        dea.addTransition(1, 3, 'e');
        dea.addTransition(2, 4, 'n');
        dea.addTransition(3, 5, '.');
        dea.addTransition(3, 6, '+');
        dea.addTransition(3, 6, '-');
        dea.addTransition(4, 3, 'e');
        dea.addTransition(6, 5, 'n');
        dea.acceptInput("nasdas");
    }
}
