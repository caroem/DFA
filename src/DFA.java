import java.util.*;

/**
 * Created by caroem on 17.04.16.
 * Todo: Create createState Method
 */
public class DFA {
    private List<State> states = new ArrayList<>();
    private List<Transition> transition = new ArrayList<>();
    private char inputToCharArray[];
    private State currentState;
    private State errorState;
    private List<State> finalStates = new ArrayList<>();
    private List<Character> alphabet = new ArrayList<>();

    public void addState(int state, boolean isFinal, boolean isInitial) {
        State newState = new State(state, isFinal, isInitial);
        states.add(newState);
        if(isFinal) {
            finalStates.add(newState);
        }
    }

    public void addTransition(int source, int destination, char input) {
        Transition newTransition = new Transition(getStateForTransition(source), getStateForTransition(destination), input);
        transition.add(newTransition);
        alphabet.add(input);
    }

    public State getStateForTransition(int state) {
        for(int i = 0; i < states.size(); i++) {
            if(states.get(i).state == state) {
                return states.get(i);
            }
        }
        return null;
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

    public boolean acceptInput(String input) {
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
            if (states.get(i).isInitial) {
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