package org.example;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        NavigableMap<Integer,Double> proba=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(proba);
        a.getPolinom().put(0, 2.0);
        a.getPolinom().put(2, 1.0);
        a.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> proba_exemplu=new TreeMap<Integer,Double>();
        Polinom exp=new Polinom(proba_exemplu);
        Polinom b=new Polinom(proba);
        exp.getPolinom().put(3,1.0);
        exp.getPolinom().put(2,-2.0);
        exp.getPolinom().put(1,6.0);
        exp.getPolinom().put(0,-5.0);
        NavigableMap<Integer,Double> proba_exemplu2=new TreeMap<Integer,Double>();
        Polinom exp2=new Polinom(proba_exemplu2);
        exp2.getPolinom().put(3,1.0);
        exp2.getPolinom().put(2,4.0);
        exp2.getPolinom().put(0,5.0);
        NavigableMap<Integer,Double> proba_imp=new TreeMap<Integer,Double>();
        Polinom imp=new Polinom(proba_imp);
        imp.getPolinom().put(0,4.0);
        imp.getPolinom().put(2,-2.0);
        imp.getPolinom().put(3,1.0);
        imp.getPolinom().put(1,-1.0);

        NavigableMap<Integer,Double> proba_c=new TreeMap<Integer,Double>();
        Polinom cristi=new Polinom(proba_c);
        cristi.getPolinom().put(6,32.0);
        cristi.getPolinom().put(3,-4.0);
        cristi.getPolinom().put(4,5.0);
        cristi.getPolinom().put(2,-12.0);
        cristi.getPolinom().put(0,-2.0);


        Polinom c=new Polinom(proba);
        c.adunare(a,b);
        c.toString();
        c.scadere(a,b);
        c.toString();
        c.inmultire(a,b);
        c.toString();
        c.impartire(a,b);
        c.toString();
        exp.derivare(exp);
        exp.toString();
        exp2.integrare(exp2);
        exp2.toString();
        Polinom rest=c.impartire(cristi,imp);
        c.toString();
        rest.toString();
    }
}