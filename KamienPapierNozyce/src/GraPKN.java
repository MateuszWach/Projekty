import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GraPKN implements ActionListener {
    JFrame frame = new JFrame("KPN");
    JButton papier = new JButton("Papier");
    JButton kamien = new JButton("Kamień");
    JButton nozyce = new JButton("Nożyce");
    JButton koniec = new JButton("Koniec");
    JButton restart = new JButton("Restart");
    JLabel label = new JLabel("Wybierz");
    JLabel computerPkt = new JLabel();
    JLabel playerPkt = new JLabel();
    JPanel pointsPanel = new JPanel();
    JPanel buttonChoicePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    String playerChoice = "0";
    String computerChoice;
    String nozyceS = "nozyce";
    String kamienS = "kamien";
    String papierS = "papier";
    int playerWins = 0;
    int computerWins = 0;


    GraPKN() {
        ustawienia();
    }
    public void ustawienia() {
        labelPanel.setLayout(new GridLayout(4,1));

        computerPkt.setText("Computer wins:");
        playerPkt.setText("Player wins:");
        pointsPanel.setLayout(new FlowLayout());
        pointsPanel.add(computerPkt);
        pointsPanel.add(playerPkt);
        labelPanel.add(pointsPanel);

        label.setHorizontalAlignment(0);
        labelPanel.add(label);

        buttonChoicePanel.setLayout(new FlowLayout());
        papier.addActionListener(this);
        kamien.addActionListener(this);
        nozyce.addActionListener(this);
        papier.setFocusable(false);
        kamien.setFocusable(false);
        nozyce.setFocusable(false);
        buttonChoicePanel.add(papier);
        buttonChoicePanel.add(kamien);
        buttonChoicePanel.add(nozyce);
        labelPanel.add(buttonChoicePanel);

        koniec.addActionListener(this);
        restart.addActionListener(this);
        koniec.setFocusable(false);
        restart.setFocusable(false);
        buttonPanel.add(restart);
        buttonPanel.add(koniec);
        labelPanel.add(buttonPanel);

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(labelPanel);
        frame.setVisible(true);
    }
    public void gra(String playerChoice) {
        if (playerChoice == computerChoice) {
            label.setText("Remis");
        } else if (playerChoice == nozyceS && computerChoice == papierS || playerChoice == kamienS && computerChoice == nozyceS || playerChoice == papierS && computerChoice == kamienS) {
            label.setText("Wygrałeś");
            playerWins++;
            playerPkt.setText("Player wins: "+playerWins);
        } else if (playerChoice == nozyceS && computerChoice == kamienS || playerChoice == kamienS && computerChoice == papierS || playerChoice == papierS && computerChoice == nozyceS) {
            label.setText("Przegrałeś");
            computerWins++;
            computerPkt.setText("Computer wins: "+computerWins);
        }
        if (computerWins == 3){
            label.setForeground(Color.RED);
            label.setText("Przegrałeś grę");
            nozyce.setEnabled(false);
            papier.setEnabled(false);
            kamien.setEnabled(false);
        } else if (playerWins == 3) {
            label.setForeground(Color.GREEN);
            label.setText("Wygrałeś grę");
            nozyce.setEnabled(false);
            papier.setEnabled(false);
            kamien.setEnabled(false);
        }
    }
    public void losowanie() {
        Random random = new Random();
        int losowa = random.nextInt(3);
        if (losowa == 0) {
            computerChoice = nozyceS;
        } else if (losowa == 1) {
            computerChoice = kamienS;
        } else if (losowa == 2) {
            computerChoice = papierS;
        }
    }
    public void restart() {
        playerWins = 0;
        computerWins = 0;
        label.setForeground(Color.BLACK);
        label.setText("Wybierz");
        computerPkt.setText("Computer wins:");
        playerPkt.setText("Player wins:");
        nozyce.setEnabled(true);
        papier.setEnabled(true);
        kamien.setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nozyce) {
            playerChoice = nozyceS;
            gra(playerChoice);
            losowanie();
        }
        if (e.getSource() == kamien) {
            playerChoice = kamienS;
            gra(playerChoice);
            losowanie();
        }
        if (e.getSource() == papier) {
            playerChoice = papierS;
            gra(playerChoice);
            losowanie();
        }
        if (e.getSource() == koniec) {
            System.exit(0);
        }
        if (e.getSource() == restart) {
            restart();
        }
    }
}