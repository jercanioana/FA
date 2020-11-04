import java.util.ArrayList;

public class Function<K,V,J> {
    public String K;
    public String V;
    public ArrayList<String> J = new ArrayList();

    public Function(String k, String v, ArrayList<String> j) {
        K = k;
        V = v;
        J = j;
    }

    public String getK() {
        return K;
    }

    public void setK(String k) {
        K = k;
    }

    public String getV() {
        return V;
    }

    public void setV(String v) {
        V = v;
    }

    public ArrayList<String> getJ() {
        return J;
    }


    public String printJ(){
        for(String j: J){
            return j;
        }
        return null;
    }

    @Override
    public String toString() {
        return
                "(" + K + ',' +
                 V + ") = "+ J;

    }

    public void setJ(ArrayList<String> j) {
        J = j;
    }
}
