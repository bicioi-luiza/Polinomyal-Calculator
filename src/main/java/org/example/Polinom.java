package org.example;
import java.text.DecimalFormat;
import java.util.*;

public class Polinom {
    private NavigableMap<Integer, Double> polinom = new TreeMap<Integer, Double>();
    ;


    public Polinom(NavigableMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    public NavigableMap<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(NavigableMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    @Override
    public String toString() {
        String rezultat = ""; DecimalFormat df = new DecimalFormat("#.#####");
        int primul_elem = 1;
        if (polinom.size() == 0)
            rezultat += "0";
        for (Map.Entry<Integer, Double> parcurgere_polinom : polinom.descendingMap().entrySet()) {
            if (parcurgere_polinom.getKey() == 0) //daca gradul este zero afisam doar coeficientul
            {if (parcurgere_polinom.getValue() > 0 && primul_elem == 0)
                rezultat += " + " + df.format(parcurgere_polinom.getValue());
            else rezultat += df.format(parcurgere_polinom.getValue());
            }
            if (parcurgere_polinom.getKey() != 0) {
                if (parcurgere_polinom.getKey() != 1) {
                    if (parcurgere_polinom.getValue() > 0 && primul_elem == 0)
                        rezultat += " + " + df.format(parcurgere_polinom.getValue()) + "x^" + parcurgere_polinom.getKey();
                    else rezultat += df.format(parcurgere_polinom.getValue()) + "x^" + parcurgere_polinom.getKey();
                }
                else
                {
                    if (parcurgere_polinom.getValue() > 0 && primul_elem == 0)
                        rezultat += " + " + df.format(parcurgere_polinom.getValue()) + "x";
                    else rezultat += df.format(parcurgere_polinom.getValue()) + "x";
                }

            }
            primul_elem = 0;
        }
        System.out.println(rezultat);
        return rezultat;
    }

    public NavigableMap elimina_zerouri()
    {
        Iterator<Map.Entry<Integer, Double>> parcurgere_add = polinom.entrySet().iterator();// eliminam toate cheiile cu coeficientii 0
        while (parcurgere_add.hasNext()) {
            Map.Entry<Integer, Double> entry = parcurgere_add.next();
            if (entry.getValue() == 0) {
                parcurgere_add.remove();
            }
        }
        return polinom;
    }

    public Polinom adunare(Polinom a, Polinom b) {
        NavigableMap<Integer, Double> rezultat = new TreeMap<Integer, Double>();
        Polinom suma = new Polinom(rezultat);
        rezultat.putAll(a.getPolinom());
        //apoi iau cel de al diolea map si probez daca cheia (adica gradul) este deja existent acolo
        //in cazul in care este atunci adunam valaorea(coeficientul) celui de al doilea polinom la primul
        for (Map.Entry<Integer, Double> parcurgere_b : b.getPolinom().entrySet()) {
            Integer grad = parcurgere_b.getKey();
            Double coeficient = parcurgere_b.getValue();
            if (rezultat.containsKey(grad)) {
                coeficient += rezultat.get(grad);
            }
            rezultat.put(grad, coeficient);
        }
        suma.setPolinom(rezultat);
        rezultat=suma.elimina_zerouri();
        this.setPolinom(rezultat);
        return suma;//am decis sa si returneze polinomul creat astfel incat sa putem apela polinom1.setPolinom(polinom2.adunare(polinom3,polinom4)), pt a il face mai diferit de restul

    }

    public Polinom scadere(Polinom a, Polinom b) {
        NavigableMap<Integer, Double> rezultat = new TreeMap<Integer, Double>();
        Polinom diferenta = new Polinom(rezultat);
        rezultat.putAll(a.getPolinom());
        //apoi iau cel de al diolea map si probez daca cheia (adica gradul) este deja existent acolo
        //in cazul in care este atunci adunam valaorea(coeficientul) celui de al doilea polinom la primul
        for (Map.Entry<Integer, Double> parcurgere_b : b.getPolinom().entrySet()) {
            Integer grad = parcurgere_b.getKey();
            Double coeficient = parcurgere_b.getValue();
            if (rezultat.containsKey(grad)) {
                coeficient -= rezultat.get(grad);
            }
            rezultat.put(grad, (-1)*coeficient);
        }
        diferenta.setPolinom(rezultat);
        rezultat=diferenta.elimina_zerouri();
        this.setPolinom(rezultat);
        return diferenta;//am decis sa si returneze polinomul creat astfel incat sa putem apela polinom1.setPolinom(polinom2.scadere(polinom3,polinom4)), pt a il face mai diferit de restul

    }

    public void inmultire (Polinom a, Polinom b)
    {
        NavigableMap<Integer, Double> rezultat = new TreeMap<Integer, Double>();
        Polinom inmultire = new Polinom(rezultat);
        for (Map.Entry<Integer, Double> parcurgere_a : a.getPolinom().entrySet())
            for (Map.Entry<Integer, Double> parcurgere_b : b.getPolinom().entrySet()){
                Integer grad = parcurgere_b.getKey()+parcurgere_a.getKey();
                Double coeficient = parcurgere_b.getValue()*parcurgere_a.getValue();
                if (rezultat.containsKey(grad)) {
                    coeficient += rezultat.get(grad);
                }
                rezultat.put(grad, coeficient);

            }
        rezultat=inmultire.elimina_zerouri();
        this.setPolinom(rezultat);
    }

    public Polinom impartire (Polinom a,Polinom b){
        NavigableMap<Integer, Double> rezultat = new TreeMap<Integer, Double>();
        Polinom impartire = new Polinom(rezultat);
        NavigableMap<Integer, Double> copieA = new TreeMap<Integer, Double>();
        NavigableMap<Integer, Double> copieB = new TreeMap<Integer, Double>();
        Polinom copie= new Polinom(copieA);
        if(a.getPolinom().lastKey()<b.getPolinom().lastKey())//daca gradul lui a mai mic decat gradul lui b
        { this.setPolinom(rezultat);}
        else{
            copieA.putAll(a.getPolinom());
            copieB.putAll(b.getPolinom());
            copie.setPolinom(copieA);
            NavigableMap<Integer, Double> catMap = new TreeMap<Integer, Double>();
            NavigableMap<Integer, Double> scazutM = new TreeMap<Integer, Double>();
            int iesire_b=0;
            Polinom cat= new Polinom(catMap);
            while(copie.getPolinom().isEmpty()==false&&copie.getPolinom().lastKey()>=copieB.lastKey()){//parcurgem de la cea mai mare la cea mai mica cheie
                Double coeficient = copie.getPolinom().get(copie.getPolinom().lastKey()) / copieB.get(copieB.lastKey());
                rezultat.put(copie.getPolinom().lastKey()-copieB.lastKey(),coeficient);
                catMap.put(copie.getPolinom().lastKey()-copieB.lastKey(),coeficient);
                cat.setPolinom(catMap);
                Polinom scazut=new Polinom(catMap);
                scazut.inmultire(scazut,b);
                catMap.remove(copie.getPolinom().lastKey()-copieB.lastKey(),coeficient);
                copie.scadere(copie,scazut);


            }
        }
        rezultat=impartire.elimina_zerouri();
        this.setPolinom(rezultat);
        return copie;
    }

    public void derivare (Polinom a){
        NavigableMap<Integer, Double> rezultat = new TreeMap<Integer, Double>();
        for (Map.Entry<Integer, Double> parcurgere : a.getPolinom().entrySet()){
            Integer grad=parcurgere.getKey()-1;
            Double coeficient=parcurgere.getValue()*parcurgere.getKey();
            rezultat.put(grad,coeficient);
        }
        this.setPolinom(rezultat);
        this.elimina_zerouri();
    }

    public void integrare (Polinom a){
        NavigableMap<Integer, Double> rezultat = new TreeMap<Integer, Double>();
        for (Map.Entry<Integer, Double> parcurgere : a.getPolinom().entrySet()){
            Integer grad=parcurgere.getKey()+1;
            Double coeficient=parcurgere.getValue()/grad;
            rezultat.put(grad,coeficient);
        }
        this.setPolinom(rezultat);
        this.elimina_zerouri();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Polinom)) {
            return false;
        }
        Polinom other = (Polinom) obj;
        return Objects.equals(polinom, other.polinom);
    }


}

