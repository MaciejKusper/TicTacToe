import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

/**
 * Created by Maciek on 29.07.2017.
 */
public class TicTacTou extends JFrame{
int couter=0;
static int ID=0;
JButton[] button = new JButton[9];
JButton[] player = new JButton[2];
JButton[] wynik = new JButton[2];
String[] b = new String[9];
int xscore=0 , oscore=0;
String player1= "player1", player2="player2";


    //Konstruktor
    public TicTacTou()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ustawienie zamykania okna na "x"
        setVisible(true); // widzialność okna (domyślnie okno jest niewidoczne
        setSize(1400,700); //ustawienie wielkości okna
        setTitle("Tic Tac Toe"); //dodanie tytułu
        setLayout(new GridLayout(3,5)); // ustawienie podziału strony
        // stworzenie i dodanie nowych przycisków gry
        for (int i=0; i<9; i++) {
            button[ID] = nowyPrzycisk();
        }
        player[0]=player(player1);
        player[1]=player(player2);
        wynik[0] = wynik();
        wynik[1]= wynik();

        add(button[0]);
        add(button[1]);
        add(button[2]);
        add(player[0]);
        add(wynik[0]);
        add(button[3]);
        add(button[4]);
        add(button[5]);
        add(player[1]);
        add(wynik[1]);
        add(button[6]);
        add(button[7]);
        add(button[8]);
        add(reset()); //dodanie resetu
        add(exit()); //dodanie exitu
    }

    public void resetm ()
    {
        for(int i=0; i<9; i++) {
            button[i].setText(null);
            button[i].setEnabled(true);
        }
    }
    //Tworzenie przycisków gry

    public JButton nowyPrzycisk() {

        JButton button=new JButton("");
        button.setFont(new Font("Arial", Font.PLAIN, 180));
        button.setText(null);
        ID++;
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (couter % 2 == 0) {
                    button.setText("x");
                } else {
                    button.setText("o");
                }
                button.setEnabled(false);
                couter++;
                owynik();
            }
        });
            return button;
    }
    //Metoda zwracając przycisk reset

    public JButton reset()
    {
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Arial",0,50));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            resetm();
            }
        });

        return reset;
    }
    //metoda zwracająca przycisk exit
    public JButton exit()
    {
        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Arial",0,50));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dodanie nowego okna dialogowego potwierdzającego wybór exit
                JFrame frame = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(frame, "Confirm if you won't to exit", "Tic Tac Toe",
                        JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
                //wyjście z programu
                System.exit(0);
            }
        });

        return exit;
    }

    public JButton player(String s)
    {
        JButton player = new JButton(s);
        player.setFont(new Font("Arial",0,50));
        return player;
        };

    public JButton wynik()
    {
        JButton wynik = new JButton("0");
        wynik.setFont(new Font("Arial",0,50));

        return wynik;
    };

    public void gamescore()
    {
        wynik[0].setText(xscore+"");
        wynik[1].setText(oscore+"");
    }
    public void owynik() {
        try {
        for (int i = 0; i < 9; i++) {
            b[i] = button[i].getText();
        }
        for (int i = 0; i < 9; i = i + 3) {
            if (b[i] == b[i + 1] && b[i + 1] == b[i + 2] && b[i] != null && b[i + 1] != null) {
                JFrame frame = new JFrame("Wynik");
                if (b[i] == "x") {
                    JOptionPane.showMessageDialog(frame, "Player X win", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                    button[i].setForeground(Color.red);
                    xscore++;
                    resetm();
                } else if (b[i] == "o") {
                    JOptionPane.showMessageDialog(frame, "Player O win", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                    button[i].setForeground(Color.red);
                    oscore++;
                    resetm();
                }
            }
        }


            for (int i = 0; i < 3; i = i+1) {
                if (b[i] == b[i + 3] && b[i + 3] == b[i + 6] && b[i] != null && b[i + 3] != null) {
                    JFrame frame = new JFrame("Wynik");
                    if (b[i] == "x") {
                        button[i].setForeground(Color.red);
                        JOptionPane.showMessageDialog(frame, "Player X win", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                        xscore++;
                        resetm();
                    } else if (b[i] == "o") {
                        JOptionPane.showMessageDialog(frame, "Player O win", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                        button[i].setForeground(Color.red);
                        oscore++;
                        resetm();
                    }
                }
            }
        }
        catch (Exception e) {
            System.err.println(e);}

            gamescore();
    }

   /* public void getplayer()
    {
        JFrame frame= new JFrame("Player1");
        JOptionPane.showMessageDialog(frame, "" +
                ""
*/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacTou();
            }
        });

    }
}
