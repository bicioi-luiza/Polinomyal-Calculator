
package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;

import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static junit.framework.TestCase.assertEquals;

public class OpTest {
    @ParameterizedTest
    @MethodSource("provideInputAdunare")
    void testAdditions(Polinom firstPolinom, Polinom secondPolinom, Polinom expectedResult){
        System.out.println("Test adunare : ");
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        Polinom polinom=new Polinom(polrez);
        assertEquals(expectedResult, polinom.adunare(firstPolinom,secondPolinom)); }
    @ParameterizedTest
    @MethodSource("provideInputScadere")
    void testSubtraction(Polinom firstPolinom, Polinom secondPolinom, Polinom expectedResult){
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        System.out.println("Test scadere : ");
        Polinom polinom=new Polinom(polrez);
        assertEquals(expectedResult, polinom.scadere(firstPolinom,secondPolinom)); }


    private static List<Arguments> provideInputAdunare(){
        List<Arguments> arguments = new ArrayList<>();
        NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(pol1);
        a.getPolinom().put(0, 2.0);
        a.getPolinom().put(2, 1.0);
        a.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol2=new TreeMap<Integer,Double>();
        Polinom b=new Polinom(pol2);
        b.getPolinom().put(0, -1.0);
        b.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(2, 1.0);
        rez.getPolinom().put(0, 1.0);
        rez.getPolinom().put(1, 2.0);
        arguments.add(Arguments.of(a, b, rez));
        return arguments;}

    private static List<Arguments> provideInputScadere(){
        List<Arguments> arguments = new ArrayList<>();
        NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(pol1);
        a.getPolinom().put(0, 2.0);
        a.getPolinom().put(2, 1.0);
        a.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol2=new TreeMap<Integer,Double>();
        Polinom b=new Polinom(pol2);
        b.getPolinom().put(0, -1.0);
        b.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(2, 1.0);
        rez.getPolinom().put(0, 3.0);
        arguments.add(Arguments.of(a, b, rez));
        return arguments;}

    private static List<Arguments> provideInputInmultire(){
        List<Arguments> arguments = new ArrayList<>();
        NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(pol1);
        a.getPolinom().put(0, 2.0);
        a.getPolinom().put(2, 1.0);
        a.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol2=new TreeMap<Integer,Double>();
        Polinom b=new Polinom(pol2);
        b.getPolinom().put(0, -1.0);
        b.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(2, 1.0);
        rez.getPolinom().put(0, 3.0);
        arguments.add(Arguments.of(a, b, rez));
        return arguments;}

}
