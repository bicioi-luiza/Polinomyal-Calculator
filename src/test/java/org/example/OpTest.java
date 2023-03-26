
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
        System.out.println("Test adunare \n ");
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        Polinom polinom=new Polinom(polrez);
        assertEquals(expectedResult, polinom.adunare(firstPolinom,secondPolinom)); }
    @ParameterizedTest
    @MethodSource("provideInputScadere")
    void testSubtraction(Polinom firstPolinom, Polinom secondPolinom, Polinom expectedResult){
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        System.out.println("Test scadere \n ");
        Polinom polinom=new Polinom(polrez);
        assertEquals(expectedResult, polinom.scadere(firstPolinom,secondPolinom)); }
    @ParameterizedTest
    @MethodSource("provideInputInmultire")
    void testMultiplication(Polinom firstPolinom, Polinom secondPolinom, Polinom expectedResult){
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        System.out.println("Test inmultire \n ");
        Polinom polinom=new Polinom(polrez);
        polinom.inmultire(firstPolinom,secondPolinom);
        assertEquals(expectedResult, polinom); }

    @ParameterizedTest
    @MethodSource("provideInputImpartire")
    void testDivision(Polinom firstPolinom, Polinom secondPolinom, Polinom expectedResult , Polinom expectedRest){
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        System.out.println("Test impartire \n ");
        Polinom polinom=new Polinom(polrez);
        Polinom rest=new Polinom(polrez);
        rest=polinom.impartire(firstPolinom,secondPolinom);
        assertEquals(expectedResult, polinom);
        assertEquals(expectedRest, rest);}

    @ParameterizedTest
    @MethodSource("provideInputDerivare")
    void testDerivation(Polinom firstPolinom, Polinom expectedResult){
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        System.out.println("Test derivare \n ");//am testat exemplul din assigment s1
        Polinom polinom=new Polinom(polrez);
        polinom.derivare(firstPolinom);
        assertEquals(expectedResult, polinom);}
    @ParameterizedTest
    @MethodSource("provideInputIntegrare")
    void testIntegration(Polinom firstPolinom, Polinom expectedResult){
        NavigableMap<Integer,Double> polrez=new TreeMap<Integer,Double>();
        System.out.println("Test integrare \n ");//am testat exemplul din assigment s1
        Polinom polinom=new Polinom(polrez);
        polinom.integrare(firstPolinom);
        assertEquals(expectedResult, polinom);}


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
        a.getPolinom().put(0, 1.0);
        a.getPolinom().put(2, 1.0);
        a.getPolinom().put(1, 2.0);
        NavigableMap<Integer,Double> pol2=new TreeMap<Integer,Double>();
        Polinom b=new Polinom(pol2);
        b.getPolinom().put(0, 1.0);
        b.getPolinom().put(1, -2.0);
        b.getPolinom().put(2, 1.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(4, 1.0);
        rez.getPolinom().put(2, -2.0);
        rez.getPolinom().put(0, 1.0);
        arguments.add(Arguments.of(a, b, rez));
        return arguments;}

    private static List<Arguments> provideInputImpartire(){
        List<Arguments> arguments = new ArrayList<>();
        NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(pol1);
        a.getPolinom().put(2, 1.0);
        a.getPolinom().put(0, -2.0);
        NavigableMap<Integer,Double> pol2=new TreeMap<Integer,Double>();
        Polinom b=new Polinom(pol2);
        b.getPolinom().put(0, 1.0);
        b.getPolinom().put(1, 1.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(1, 1.0);
        rez.getPolinom().put(0, -1.0);
        NavigableMap<Integer,Double> pol4=new TreeMap<Integer,Double>();
        Polinom rest=new Polinom(pol4);
        rest.getPolinom().put(0, -1.0);
        arguments.add(Arguments.of(a, b, rez,rest));
        return arguments;}

    private static List<Arguments> provideInputDerivare(){
        List<Arguments> arguments = new ArrayList<>();
        NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(pol1);
        a.getPolinom().put(3,1.0);
        a.getPolinom().put(2,-2.0);
        a.getPolinom().put(1,6.0);
        a.getPolinom().put(0,-5.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(2, 3.0);
        rez.getPolinom().put(1, -4.0);
        rez.getPolinom().put(0, 6.0);
        arguments.add(Arguments.of(a, rez));
        return arguments;}

    private static List<Arguments> provideInputIntegrare(){
        List<Arguments> arguments = new ArrayList<>();
        NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
        Polinom a=new Polinom(pol1);
        a.getPolinom().put(3,1.0);
        a.getPolinom().put(2,4.0);
        a.getPolinom().put(0,5.0);
        NavigableMap<Integer,Double> pol3=new TreeMap<Integer,Double>();
        Polinom rez=new Polinom(pol3);
        rez.getPolinom().put(4, 0.25);
        rez.getPolinom().put(3, 4.0/3);
        rez.getPolinom().put(1, 5.0);
        arguments.add(Arguments.of(a, rez));
        return arguments;}

}
