package org.example;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import java.util.NavigableMap;
import java.util.TreeMap;




public class InterfataCalculator {

    private JFrame frame;
    private JTextField textPol2;
    private JTextField textRezultat;

    NavigableMap<Integer,Double> pol1=new TreeMap<Integer,Double>();
    public Polinom polinom1=new Polinom(pol1);

    NavigableMap<Integer,Double> pol2=new TreeMap<Integer,Double>();
    public Polinom polinom2=new Polinom(pol2);

    NavigableMap<Integer,Double> rezf=new TreeMap<Integer,Double>();
    public Polinom rez=new Polinom(rezf);

    NavigableMap<Integer,Double> restf=new TreeMap<Integer,Double>();
    public Polinom rest=new Polinom(restf);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfataCalculator window = new InterfataCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //metoda returneazaPolinoame o folosesc pt a testa daca au fost introduse corect , si in cazul in care sunt corecte apelez functia din clasa RegexParseString pt creea treemapul polinoamelor
    public void returneazaPolinoame(String a, String b){
        try{
            pol1=RegexParseString.stringTotree(a);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Polinomul 1 nu a fost introdus corect");
            throw new RuntimeException(ex);
        } ;
        try {
            pol2 = RegexParseString.stringTotree(b);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Polinomul 2 nu a fost introdus corect");
            throw new RuntimeException(ex);
        } ;
    }

    /**
     * Create the application.
     */
    public InterfataCalculator() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(217, 249, 255));
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel LabelTitlu = new JLabel("Calculator");
        LabelTitlu.setForeground(new Color(0, 0, 0));
        LabelTitlu.setBackground(new Color(0, 0, 0));
        LabelTitlu.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 28));
        LabelTitlu.setBounds(212, 39, 150, 35);
        frame.getContentPane().add(LabelTitlu);

        JLabel LabelIntroducerePol1 = new JLabel("Introduceti polinomul 1");
        LabelIntroducerePol1.setFont(new Font("Tahoma", Font.BOLD, 14));
        LabelIntroducerePol1.setForeground(new Color(0, 0, 0));
        LabelIntroducerePol1.setBackground(new Color(217, 249, 255));
        LabelIntroducerePol1.setBounds(59, 115, 174, 19);
        LabelIntroducerePol1.setOpaque(true);
        frame.getContentPane().add(LabelIntroducerePol1);

        JTextField textPol1 = new JTextField("");
        LabelIntroducerePol1.setLabelFor(textPol1);
        textPol1.setForeground(new Color(217, 249, 253));
        textPol1.setBackground(new Color(0, 0, 0));
        textPol1.setBounds(39, 144, 205, 19);
        textPol1.setOpaque(true);
        frame.getContentPane().add(textPol1);

        JLabel LabelIntroducerePol2 = new JLabel("Introduceti polinomul 2");
        LabelIntroducerePol2.setOpaque(true);
        LabelIntroducerePol2.setForeground(new Color(0, 0, 0));
        LabelIntroducerePol2.setFont(new Font("Tahoma", Font.BOLD, 14));
        LabelIntroducerePol2.setBackground(new Color(217, 249, 255));
        LabelIntroducerePol2.setBounds(59, 212, 174, 19);
        frame.getContentPane().add(LabelIntroducerePol2);

        textPol2 = new JTextField("");
        LabelIntroducerePol2.setLabelFor(textPol2);
        textPol2.setOpaque(true);
        textPol2.setForeground(new Color(217, 249, 253));
        textPol2.setBackground(Color.BLACK);
        textPol2.setBounds(39, 241, 205, 19);
        frame.getContentPane().add(textPol2);

        JButton butonAdunare = new JButton("Adunare");
        butonAdunare.setForeground(new Color(217, 249, 253));
        butonAdunare.setOpaque(true);
        butonAdunare.setBorderPainted(false);
        butonAdunare.setBackground(new Color(64, 0, 64));
        butonAdunare.setFont(new Font("Tahoma", Font.BOLD, 14));
        butonAdunare.setVisible(true);
        butonAdunare.setBounds(283, 144, 124, 19);
        frame.getContentPane().add(butonAdunare);

        JLabel lblOperatiiPe = new JLabel("Operatii pe 2 polinoame");
        lblOperatiiPe.setOpaque(true);
        lblOperatiiPe.setForeground(new Color(64, 0, 64));
        lblOperatiiPe.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOperatiiPe.setBackground(new Color(217, 249, 253));
        lblOperatiiPe.setBounds(333, 115, 171, 19);
        frame.getContentPane().add(lblOperatiiPe);

        JButton butonScadere= new JButton("Scadere");
        butonScadere.setForeground(new Color(217, 249, 253));
        butonScadere.setOpaque(true);
        butonScadere.setBorderPainted(false);
        butonScadere.setBackground(new Color(64, 0, 64));
        butonScadere.setFont(new Font("Tahoma", Font.BOLD, 14));
        butonScadere.setVisible(true);
        butonScadere.setBounds(417, 144, 124, 19);
        frame.getContentPane().add(butonScadere);

        JButton butonInmultire = new JButton("Inmultire");
        butonInmultire.setForeground(new Color(217, 249, 253));
        butonInmultire.setOpaque(true);
        butonInmultire.setBorderPainted(false);
        butonInmultire.setBackground(new Color(64, 0, 64));
        butonInmultire.setFont(new Font("Tahoma", Font.BOLD, 14));
        butonInmultire.setVisible(true);
        butonInmultire.setBounds(283, 174, 124, 19);
        frame.getContentPane().add(butonInmultire);

        JButton butonImpartire= new JButton("Impartire");
        butonImpartire.setForeground(new Color(217, 249, 253));
        butonImpartire.setOpaque(true);
        butonImpartire.setBorderPainted(false);
        butonImpartire.setBackground(new Color(64, 0, 64));
        butonImpartire.setFont(new Font("Tahoma", Font.BOLD, 14));
        butonImpartire.setVisible(true);
        butonImpartire.setBounds(417, 173, 124, 19);
        frame.getContentPane().add(butonImpartire);

        JButton butonDerivare = new JButton("Derivare");
        butonDerivare.setForeground(new Color(217, 249, 253));
        butonDerivare.setOpaque(true);
        butonDerivare.setBorderPainted(false);
        butonDerivare.setBackground(new Color(64, 0, 64));
        butonDerivare.setFont(new Font("Tahoma", Font.BOLD, 14));
        butonDerivare.setVisible(true);
        butonDerivare.setBounds(283, 239, 124, 19);
        frame.getContentPane().add(butonDerivare);

        JButton butonIntegrare= new JButton("Integrare");
        butonIntegrare.setForeground(new Color(217, 249, 253));
        butonIntegrare.setOpaque(true);
        butonIntegrare.setBorderPainted(false);
        butonIntegrare.setBackground(new Color(64, 0, 64));
        butonIntegrare.setFont(new Font("Tahoma", Font.BOLD, 14));
        butonIntegrare.setVisible(true);
        butonIntegrare.setBounds(417, 239, 124, 19);
        frame.getContentPane().add(butonIntegrare);

        JLabel labelRez = new JLabel("Rezultatul final este");
        labelRez.setOpaque(true);
        labelRez.setForeground(new Color(217, 249, 253));
        labelRez.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRez.setBackground(new Color(0, 0, 0));
        labelRez.setBounds(212, 323, 150, 19);
        frame.getContentPane().add(labelRez);

        textRezultat = new JTextField("");
        textRezultat.setOpaque(true);
        textRezultat.setForeground(new Color(217, 249, 253));
        textRezultat.setBackground(Color.BLACK);
        textRezultat.setBounds(163, 352, 251, 28);
        frame.getContentPane().add(textRezultat);

        JLabel lblOperatiiPeUn = new JLabel("Operatii pe un polinom");
        lblOperatiiPeUn.setOpaque(true);
        lblOperatiiPeUn.setForeground(new Color(64, 0, 64));
        lblOperatiiPeUn.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOperatiiPeUn.setBackground(new Color(217, 249, 253));
        lblOperatiiPeUn.setBounds(333, 210, 171, 19);
        frame.getContentPane().add(lblOperatiiPeUn);

        JButton butonReset = new JButton("C");
        butonReset.setOpaque(true);
        butonReset.setBorderPainted(false);
        butonReset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        butonReset.setForeground(new Color(217, 249, 255));
        butonReset.setBackground(new Color(0, 0, 0));
        butonReset.setBounds(501, 404, 53, 49);
        frame.getContentPane().add(butonReset);

        ///action perfored for buttons
        //toate functioneaza pe acelasi principiu : se apeleaza fctia returneazaPolinoame , apoi se apeleaza operatia dorita din clasa polinom si pune toStringul rezultatului in textField ul pt rezultat

        butonAdunare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returneazaPolinoame(textPol1.getText(),textPol2.getText());
                polinom1.setPolinom(pol1);
                polinom2.setPolinom(pol2);
                rez.adunare(polinom1,polinom2);
                textRezultat.setText(rez.toString());
            }
        });

        butonScadere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returneazaPolinoame(textPol1.getText(),textPol2.getText());
                polinom1.setPolinom(pol1);
                polinom2.setPolinom(pol2);
                rez.scadere(polinom1,polinom2);
                textRezultat.setText(rez.toString());
            }
        });

        butonInmultire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returneazaPolinoame(textPol1.getText(),textPol2.getText());
                polinom1.setPolinom(pol1);
                polinom2.setPolinom(pol2);
                rez.inmultire(polinom1,polinom2);
                textRezultat.setText(rez.toString());
            }
        });
        butonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                polinom1.getPolinom().clear();
                polinom2.getPolinom().clear();
                textRezultat.setText("");
                textPol1.setText("");
                textPol2.setText("");
            }
        });
        butonImpartire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returneazaPolinoame(textPol1.getText(),textPol2.getText());
                polinom1.setPolinom(pol1);
                polinom2.setPolinom(pol2);
                rest=rez.impartire(polinom1,polinom2);
                textRezultat.setText(rez.toString()+ "   " + "Restul : " +rest.toString());
            }
        });
        butonDerivare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returneazaPolinoame(textPol1.getText(),"0");
                if(textPol2.getText().isBlank()) {
                    polinom1.setPolinom(pol1);
                    rez.derivare(polinom1);
                    textRezultat.setText(rez.toString());
                }
            }
        });
        butonIntegrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returneazaPolinoame(textPol1.getText(),"0");
                if(textPol2.getText().isBlank()) {
                    polinom1.setPolinom(pol1);
                    rez.integrare(polinom1);
                    textRezultat.setText(rez.toString() + " + C");
                }
            }
        });



    }

}
