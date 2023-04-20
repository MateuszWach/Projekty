import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Projekt 2");
    JPanel panel1 = new JPanel();
    JButton startButton = new JButton("Start");
    JButton settingsButton = new JButton("Opcje");
    JButton exitButton = new JButton("Wyjście");

    JPanel panel2 = new JPanel();
    JButton fun1Button = new JButton("TextEditor");
    JButton fun2Button = new JButton("Stopwatch");
    JButton fun3Button = new JButton("Calculator");

    Menu(){
        // Panel strony 1

        startButton.setBounds(200,0,100,50);
        startButton.addActionListener(this);
        settingsButton.setBounds(200,100,100,50);
        settingsButton.addActionListener(this);
        exitButton.setBounds(200,200,100,50);
        exitButton.addActionListener(this);

        panel1.add(startButton);
        panel1.add(settingsButton);
        panel1.add(exitButton);
        panel1.setBounds(0,150,500,350);
        panel1.setLayout(null);

        // Strona główna

        label.setBounds(50,25,350,100);
        label.setFont(new Font(null,Font.BOLD,40));
        label.setHorizontalAlignment(0);

        frame.add(panel1);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //strona 1
        if (e.getSource()==exitButton){
            System.exit(0);
        }
        if (e.getSource()==settingsButton){
            JOptionPane.showMessageDialog(null,"To funkcja ustawień","Settings",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource()==startButton){
            panel1.setVisible(false);
            label.setText("Wybierz funkcję");
            setPanel2();
        }
        //strona 2
        if (e.getSource()==fun1Button) {
            TextEditor textEditor = new TextEditor();
        }
        if (e.getSource()==fun2Button) {
            Stopwatch stopwatch = new Stopwatch();
        }
        if (e.getSource()==fun3Button) {
            Calculator clock = new Calculator();
        }
    }
    public void setPanel2(){
        fun1Button.setBounds(200,0,100,50);
        fun1Button.addActionListener(this);
        fun2Button.setBounds(200,100,100,50);
        fun2Button.addActionListener(this);
        fun3Button.setBounds(200,200,100,50);
        fun3Button.addActionListener(this);

        panel2.add(fun1Button);
        panel2.add(fun2Button);
        panel2.add(fun3Button);
        panel2.setBounds(0,150,500,350);
        panel2.setLayout(null);
        
        frame.add(panel2);
    }
}
