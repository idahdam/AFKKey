package afk.key.boys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String args[]) throws AWTException {
        final double[] counter = {0};
        JFrame frame = new JFrame("AFK Key - 1.0.1");

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setSize(600, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOne = new JMenu("Options");

        menuBar.add(menuOne);

        JMenuItem itemOne = new JMenuItem("About");
        JMenuItem itemTwo = new JMenuItem("Exit");

        menuOne.add(itemOne);
        menuOne.add(itemTwo);

        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter text here: ");
        JLabel status = new JLabel("Status: None");
        JLabel time = new JLabel("Time: " + counter[0] + " s");
        JTextField input = new JTextField(5); // accepts upto 10 characters
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        panel.add(label); // Components Added using Flow Layout
        panel.add(input);
        panel.add(start);
        panel.add(stop);
        panel.add(status);
        panel.add(time);

        JTextArea textArea = new JTextArea();

        start.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                status.setText("Status: Start");
                new Thread(new Runnable() {
                    public void run() {
                    while(true){
            
                    if(status.getText()=="Status: Stop"){
                        break;
                    }

                    // Runs inside of the Swing UI thread
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                        if(input.getText().isEmpty() == true){
                            textArea.append("I'm AFK...\n");
                        }
                        else{
                            textArea.append(input.getText() + "\n");
                        }
                        counter[0] += 1.0;
                        time.setText("Time: " + counter[0] + " s");
                        }});


                    
                    try {
                        Thread.sleep(1000);
                    }
                    catch(Exception e) { }

                    }                    
                }
                }).start();


            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("Status: Stop");
                counter[0] = 0;
                textArea.selectAll();
                textArea.replaceSelection("");
            }
        });

        itemOne.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    frame, 
                    "I made the program because my Windows machine kept BSOD-ing me for days. \nFork the repository if you feel you can improve more. \n\nCheers, idahdam.", 
                    "About Program", JOptionPane.OK_OPTION);
                
            }
        });

        itemTwo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int respond = JOptionPane.showConfirmDialog(
                    frame, 
                    "Are you sure?", "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
                if(respond == JOptionPane.NO_OPTION){
                    
                }
                else{
                    System.exit(0);
                }
            }
        });

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);

        frame.setVisible(true);
    }
}
