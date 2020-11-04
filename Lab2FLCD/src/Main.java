import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FiniteAutomata fa = new FiniteAutomata();
        fa.getFAFromFile();
        System.out.println("Q: ");
        fa.printQ();
        System.out.println("Alphabet: ");
        fa.printAlphabet();
        System.out.println("Initial state: ");
        fa.printInitialState();
        System.out.println("Final states: ");
        fa.printF();
        System.out.println("Transition function: ");
        fa.printTransitionFunction();
        System.out.println("Is deterministic: ");
        System.out.println(fa.isDeterministic());
    }
}
