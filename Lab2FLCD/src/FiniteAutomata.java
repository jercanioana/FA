import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FiniteAutomata {
    private ArrayList<String> Q = new ArrayList<>();
    private String initialState;
    private ArrayList<Function<String, String, String>> transitionFunction = new ArrayList<>();
    private ArrayList<String> alphabet = new ArrayList<>();
    private ArrayList<String> F = new ArrayList<>();

    public void getFAFromFile(){
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader("FA.txt"));
            String line = bufferedReader.readLine();
            int linenumber = 0;
            while(line != null){
                String[] elements = line.split(" ");
                if(linenumber == 0)
                    Q.addAll(Arrays.asList(elements));
                if(linenumber == 1)
                    alphabet.addAll(Arrays.asList(elements));
                if(linenumber == 2){
                    initialState = elements[0];
                }
                if(linenumber == 3){
                    F.addAll(Arrays.asList(elements));
                }else if(linenumber > 3){
                    boolean ok = false;
                    ArrayList<String> list = new ArrayList<>();
                    list.add(elements[2]);
                    Function TransFunction = new Function(elements[0], elements[1], list);
                    for(Function pairs: transitionFunction){
                        if (pairs.getK().equals(elements[0]) && pairs.getV().equals(elements[1])){
                            ArrayList<String> J = pairs.getJ();
                            J.add(elements[2]);
                            pairs.setJ(J);
                            ok = true;
                        }
                    }
                    if(!ok){
                        transitionFunction.add(TransFunction);
                    }
                }

                linenumber++;
                line = bufferedReader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public boolean isDeterministic(){
        for(Function pairs: transitionFunction){
            if(pairs.getJ().size() > 1){
                return false;
            }
        }
        return true;
    }

    public void printF(){
        for(String f: F){
            System.out.println(f);
        }
    }

    public void printQ(){
        for(String q: Q){
            System.out.println(q);
        }
    }

    public void printAlphabet(){
        for(String q: alphabet){
            System.out.println(q);
        }
    }

    public void printInitialState(){
        System.out.println(initialState);
    }

    public void printTransitionFunction(){
        for(Function function :transitionFunction){
            System.out.println(function.toString());
        }
    }

    @Override
    public String toString() {
        return "FiniteAutomata{" +
                "Q=" + Q +
                ", initialState='" + initialState + '\'' +
                ", transitionFunction='" + transitionFunction + '\'' +
                ", alphabet=" + alphabet +
                ", F=" + F +
                '}';
    }
}
