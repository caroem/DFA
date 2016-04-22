import java.util.*;

/**
 * Created by caroem on 17.04.16.
 */
public class dfa {
    public List<State> states = new ArrayList<>();
    public List<Transition> transition = new ArrayList<>();
    char inputToCharArray[];
    State currentState;
    State errorState;
    List<State> finalStates = new ArrayList<>();
    List<Character> alphabet = new ArrayList<>();
    String input;

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

    public class Transition {
        public char input;
        public State source;
        public State destination;

        public Transition(int source, int destination, char input) {
            this.input = input;

            for(int i = 0; i < states.size(); i++) {
                if((states.get(i).state == source)) {
                    this.source = states.get(i);
                }
                if(states.get(i).state == destination) {
                    this.destination = states.get(i);
                }
            }
        }
    }

    public void addState(int state, boolean isFinal, boolean isInitial) {
        State newState = new State(state, isFinal, isInitial);
        states.add(newState);
        if(isFinal == true) {
            finalStates.add(newState);
        }
    }

    public void addTransition(int source, int destination, char input) {
        Transition newTransition = new Transition(source, destination, input);
        transition.add(newTransition);
        alphabet.add(input);
    }

    public boolean readCharacters(char input) {
        for(int i = 0; i < transition.size(); i++) {
            if((transition.get(i).source == currentState) && (transition.get(i).input == input)) {
                currentState = transition.get(i).destination;
                return true;
            }
        }
        if(!alphabet.contains(input)) {
            currentState = errorState;
            return false;
        }
        currentState = errorState;
        return false;
    }

    public boolean acceptInput() {
        inputToCharArray = new char[input.length()];
        inputToCharArray = input.toCharArray();
        for (int i = 0; i < inputToCharArray.length; i++) {
            readCharacters(inputToCharArray[i]);
        }

        if(finalStates.contains(currentState)) {
            System.out.println("Accepted!");
            setInitialState();
            return true;
        } else {
            System.out.println("Not Accepted!");
            setInitialState();
            return false;
        }
    }

    public void setInitialState() {
        for (int i = 0; i < states.size(); i++) {
            if (states.get(i).isInitial == true) {
                currentState = states.get(i);
            }
        }
    }

    public void setErrorState(int state) {
        for(int i = 0; i < states.size(); i++) {
            if(states.get(i).state == state) {
                errorState = states.get(i);
            }
        }
    }

}