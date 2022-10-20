import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class CatTicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    BufferedImage image = ImageIO.read(new File("/Users/rocks/Pictures/Camera Roll/cuteCat1.png"));
    Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
    Icon icon = new ImageIcon(newimg);
    BufferedImage image2 = ImageIO.read(new File("/Users/rocks/Pictures/Camera Roll/cuteCat2.png"));
    Image newimg2 = image2.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
    Icon icon2 = new ImageIcon(newimg2);

    CatTicTacToe() throws IOException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(8, 245, 199));
        textField.setForeground(new Color(5, 0, 0));
        textField.setFont(new Font("Calibri Light",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 200);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(93, 92, 92));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Calibri Light", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setIcon(icon);
                        player1_turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setIcon(icon2);
                        player1_turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X Turn");
        } else {
            player1_turn = false;
            textField.setText("O Turn");
        }
    }

    public void check() {
        // Check X
            if ((buttons[0].getIcon() == icon) &&
                    (buttons[1].getIcon() == icon) &&
                    (buttons[2].getIcon() == icon)) {

                xWins(0, 1, 2);
            }
            if ((buttons[3].getIcon() == icon) &&
                    (buttons[4].getIcon() == icon) &&
                    (buttons[5].getIcon() == icon)){

                xWins(3, 4, 5);
            }
            if ((buttons[6].getIcon() == icon) &&
                    (buttons[7].getIcon() == icon) &&
                    (buttons[8].getIcon() == icon)) {

                xWins(6, 7, 8);
            }
            if ((buttons[0].getIcon() == icon) &&
                    (buttons[3].getIcon() == icon) &&
                    (buttons[6].getIcon() == icon)) {

                xWins(0, 3, 6);
            }
            if ((buttons[1].getIcon() == icon) &&
                    (buttons[4].getIcon() == icon) &&
                    (buttons[7].getIcon() == icon)) {

                xWins(1, 4, 7);
            }
            if ((buttons[2].getIcon() == icon) &&
                    (buttons[5].getIcon() == icon) &&
                    (buttons[8].getIcon() == icon)) {

                xWins(2, 5, 8);
            }
            if ((buttons[0].getIcon() == icon) &&
                    (buttons[4].getIcon() == icon) &&
                    (buttons[8].getIcon() == icon)) {

                xWins(0, 4, 8);
            }
            if ((buttons[2].getIcon() == icon) &&
                    (buttons[4].getIcon() == icon) &&
                    (buttons[6].getIcon() == icon)) {

                xWins(2, 4, 6);
            }
        // Check O
            if ((buttons[0].getIcon() == icon2) &&
                    (buttons[1].getIcon() == icon2) &&
                    (buttons[2].getIcon() == icon2)) {

                oWins(0, 1, 2);
            }
            if ((buttons[3].getIcon() == icon2) &&
                    (buttons[4].getIcon() == icon2) &&
                    (buttons[5].getIcon() == icon2)) {

                oWins(3, 4, 5);
            }
            if ((buttons[6].getIcon() == icon2) &&
                    (buttons[7].getIcon() == icon2) &&
                    (buttons[8].getIcon() == icon2)) {

                oWins(6, 7, 8);
            }
            if ((buttons[0].getIcon() == icon2) &&
                    (buttons[3].getIcon() == icon2) &&
                    (buttons[6].getIcon() == icon2)) {

                oWins(0, 3, 6);
            }
            if ((buttons[1].getIcon() == icon2) &&
                    (buttons[4].getIcon() == icon2) &&
                    (buttons[7].getIcon() == icon2)) {

                oWins(1, 4, 7);
            }
            if ((buttons[2].getIcon() == icon2) &&
                    (buttons[5].getIcon() == icon2) &&
                    (buttons[8].getIcon() == icon2)) {

                oWins(2, 5, 8);
            }
            if ((buttons[0].getIcon() == icon2) &&
                    (buttons[4].getIcon() == icon2) &&
                    (buttons[8].getIcon() == icon2)) {

                oWins(0, 4, 8);
            }
            if ((buttons[2].getIcon() == icon2) &&
                    (buttons[4].getIcon() == icon2) &&
                    (buttons[6].getIcon() == icon2)) {

                oWins(2, 4, 6);
            }
    }

    public void xWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("CatX Wins");
    }

    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("CatO Wins");
    }

    public static void main(String[] args) throws IOException {
        new CatTicTacToe();
    }

}
