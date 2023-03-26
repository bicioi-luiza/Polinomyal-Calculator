package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.NavigableMap;
import java.util.TreeMap;
public class RegexParseString {

    public static NavigableMap stringTotree(String s) throws Exception {
        Matcher matcher;
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        NavigableMap<Integer,Double> polinom=new TreeMap<Integer,Double>();
        matcher = pattern.matcher(s); int ok=0;
        while (matcher.find()) {
            Double coeficient;
            Integer grad;

            if (matcher.group(1).contains("x^")) {
                String[] parts = matcher.group(1).split("x\\^");
                grad = Integer.parseInt(parts[1]);
                coeficient = (parts[0].equals("") || parts[0].equals("+")) ? 1.0
                        : (parts[0].equals("-") ? -1.0 : Double.parseDouble(parts[0]));
            } else if (matcher.group(1).contains("x")) {
                String[] parts = matcher.group(1).split("x");
                grad = 1;
                coeficient = (parts.length == 0 || parts[0].equals("+")) ? 1.0
                        : (parts[0].equals("-") ? -1.0 : Double.parseDouble(parts[0]));
            } else {
                coeficient = Double.parseDouble(matcher.group(1));
                grad = 0;
            }
            polinom.put(grad,coeficient);
            if(s.endsWith(matcher.group(1)))
                ok=1;
        }
        if(ok==0)
            throw new Exception("Nu ati introdus cum trebuie polinomul");
        return polinom;
    }



}
