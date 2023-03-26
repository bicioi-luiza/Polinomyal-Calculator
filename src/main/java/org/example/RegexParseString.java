package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.NavigableMap;
import java.util.TreeMap;
public class RegexParseString {
    //am ales sa creez o clasa in plus pt regex deoarece mi-am dorit sa se vada mai bine metoda utilizata pentru regex si am usurat si codul in InterfataCalculator

    //metoda pt a calcula coeficientul
    public static Double getCoefficient(String s){
        Double coeficient =0.0;
        if (s.equals("") || s.equals("+")) {
            coeficient = 1.0;
        } else if (s.equals("-")) {
            coeficient = -1.0;
        } else {
            coeficient = Double.parseDouble(s);
        }
    return coeficient;}

    public static NavigableMap stringTotree(String s) throws Exception {
        Matcher matcher;
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        NavigableMap<Integer,Double> polinom=new TreeMap<Integer,Double>();
        matcher = pattern.matcher(s); int ok=0;
        while (matcher.find()) {
            Double coeficient;
            Integer grad;
            //notatiile sunt similare celor de pe stackoverflow , de unde m-am si inspirat
            if (matcher.group(1).contains("x^")) {
                String[] parts = matcher.group(1).split("x\\^");
                grad = Integer.parseInt(parts[1]);
                coeficient=getCoefficient(parts[0]);
            } else if (matcher.group(1).contains("x")) {
                String[] parts = matcher.group(1).split("x");
                grad = 1;
                if(parts.length==0)
                    coeficient=1.0;
                else coeficient=getCoefficient(parts[0]);
            } else {
                coeficient = Double.parseDouble(matcher.group(1));
                grad = 0;
            }
            polinom.put(grad,coeficient);
            if(s.endsWith(matcher.group(1)))
                ok=1;//s-a ajuns la finalul stringului , toate match urile au fost gasite => string introdus corect
        }
        if(ok==0)
            throw new Exception("Nu ati introdus cum trebuie polinomul");//daca nu s-au gasit astfel de matcher uri pana la finalul stringului , atunci inseamna ca stringul nu a fost introdus cum trebuie
        return polinom;
    }



}
