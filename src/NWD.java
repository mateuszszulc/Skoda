import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 01.03.12
 * Time: 22:03
 */
public class NWD {

    private static JTextField liczba1;
    private static JTextField liczba2;
    private static JTextField wynik;

    public static void main(String[] args) {
        JFrame okienko = new JFrame();

        GridLayout grid = new GridLayout();
        okienko.setLayout(grid);


        liczba1 = new JTextField();
        okienko.add(liczba1, 0, 0);

        liczba2 = new JTextField();
        okienko.add(liczba2, 0, 1);

        wynik = new JTextField();
        wynik.setEditable(false);
        okienko.add(wynik, 0, 2);

        JButton przycisk = new JButton("Licz!");
        okienko.add(przycisk, 0, 3);

        przycisk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pierwszaLiczba = Integer.parseInt(liczba1.getText());
                int drugaLiczba = Integer.parseInt(liczba2.getText());

                int nwdWynik = policz(pierwszaLiczba, drugaLiczba);
                wynik.setText(String.valueOf(nwdWynik));
            }
        });

        okienko.setSize(200, 200);
        okienko.pack();
        okienko.setVisible(true);
    }

    public static int policz(int pierwszaLiczba, int drugaLiczba) {
        List<Integer> tablicaDzielnikow = new ArrayList();

        for (int i = 1; i <= pierwszaLiczba; ++i) {
            tablicaDzielnikow.add(i);
        }
        int jelen = -1000;
        for (Integer liczba : tablicaDzielnikow) {
            if ((drugaLiczba % liczba) == 0 && (pierwszaLiczba % liczba) == 0) {
                jelen = liczba;
            } else {
                jelen = jelen;
            }
        }

        return jelen;
    }
}
