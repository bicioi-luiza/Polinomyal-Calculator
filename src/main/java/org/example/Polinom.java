package org.example;
import javax.lang.model.type.NullType;
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
        String rezultat = ""; DecimalFormat df = new DecimalFormat("#.#####");//il utilizam astfel incat daca double ul parsat este de forma x.00 noi sa afisam doar x
        int primul_elem = 1;
        if (polinom.size() == 0)
            rezultat += "0";//daca polinomul are size ul 0 , atunci el e 0
        for (Map.Entry<Integer, Double> parcurgere_polinom : polinom.descendingMap().entrySet()) {
            if (parcurgere_polinom.getKey() == 0) //daca gradul este zero afisam doar coeficientul
            {if (parcurgere_polinom.getValue() > 0 && primul_elem == 0)
                rezultat += " + " + df.format(parcurgere_polinom.getValue());
            else rezultat += df.format(parcurgere_polinom.getValue()); // aceasta ramura e pt valorile negative
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
                        rezultat += " + " + df.format(parcurgere_polinom.getValue()) + "x";//gradul fiind 1 , nu se mai afiseaza
                    else rezultat += df.format(parcurgere_polinom.getValue()) + "x";
                }

            }
            primul_elem = 0;//atunci cand era pe 1 , se evita sa se puna semnul + in fata lui deoarece era primul element( nu arata bine sa scriem polinomul +x^2 spre exemplu)
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
        //iau cel de al diolea map si probez daca cheia (adica gradul) este deja existent acolo
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
        //iau cel de al diolea map si probez daca cheia (adica gradul) este deja existent acolo
        //in cazul in care este atunci scadem valaorea(coeficientul) celui de al doilea polinom la primul
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
        //se parcurg simultan ambele polinoame si se inmulteste fiecare element din pol1 cu fiecare elm din pol2
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
        Polinom impartire = new Polinom(rezultat);//polinomul in care se va pastra rezultatul
        NavigableMap<Integer, Double> copieA = new TreeMap<Integer, Double>();//fac copii si lucrez cu ele , pt a nu deteriora polinaomele initiale
        NavigableMap<Integer, Double> copieB = new TreeMap<Integer, Double>(); Polinom copie= new Polinom(copieA);
        copieA.putAll(a.getPolinom());
        if(a.getPolinom().lastKey()<b.getPolinom().lastKey())//daca gradul lui a mai mic decat gradul lui b
        { this.setPolinom(rezultat);}//daca gradul lui a este mai mic decat gradul lui b , rezultatul este 0
        else{
            copieB.putAll(b.getPolinom()); copie.setPolinom(copieA);
            NavigableMap<Integer, Double> catMap = new TreeMap<Integer, Double>();//in el voi salva monoame
            NavigableMap<Integer, Double> scazutM = new TreeMap<Integer, Double>();
            int iesire_b=0;
            Polinom cat= new Polinom(catMap);
            while(copie.getPolinom().isEmpty()==false&&copie.getPolinom().lastKey()>=copieB.lastKey()){//parcurgem de la cea mai mare la cea mai mica cheie
                Double coeficient = copie.getPolinom().get(copie.getPolinom().lastKey()) / copieB.get(copieB.lastKey());//impartimi primii coeficienti unul la altul
                rezultat.put(copie.getPolinom().lastKey()-copieB.lastKey(),coeficient);// se salveaza un monom in rezultat
                catMap.put(copie.getPolinom().lastKey()-copieB.lastKey(),coeficient);
                cat.setPolinom(catMap);
                Polinom scazut=new Polinom(catMap);
                scazut.inmultire(scazut,b);//se inmulteste monomul descoperit la respectiva iteratia , cu tot polinomul b
                catMap.remove(copie.getPolinom().lastKey()-copieB.lastKey(),coeficient);// dupa cum am zis , polinomul acesta , salveaza DOAR UN MONOM
                copie.scadere(copie,scazut);// se scade din copie , acea inmultire si se continua while ul , pt a afla si urmatoarele monoame
            }
        }
        rezultat=impartire.elimina_zerouri();
        this.setPolinom(rezultat);// deci daca apelam d=c.impartire(a,b) => rezultatul se pune in c
        return copie;// iar ceea ce se returneaza , adica restul , se pune in d
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
        return Objects.equals(polinom, other.polinom);//functie pt testele JUnit
    }


}

