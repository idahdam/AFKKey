package afk.key.boys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String args[]) throws AWTException {
        JFrame frame = new JFrame("AFK Key");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOne = new JMenu("Options");

        menuBar.add(menuOne);

        JMenuItem itemOne = new JMenuItem("About");
        JMenuItem itemTwo = new JMenuItem("Exit");

        menuOne.add(itemOne);
        menuOne.add(itemTwo);

        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter key to be typed: ");
        JLabel status = new JLabel("Status: None");
        JTextField input = new JTextField(5); // accepts upto 10 characters
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        panel.add(label); // Components Added using Flow Layout
        panel.add(input);
        panel.add(start);
        panel.add(stop);
        panel.add(status);

        JTextArea textArea = new JTextArea();

        Robot robot = new Robot();

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("Status: Start");
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("Status: Stop");
            }
        });


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);

        frame.setVisible(true);
    }
}
