import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.*;

import javax.sound.sampled.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton b = new JButton("Play");
    JLabel label = new JLabel();
    String filepath = "Caramelldansen Super Idol.wav";
    MyFrame() {
        ImageIcon icon = new ImageIcon("logo.jpg");
        ImageIcon icon2 = new ImageIcon("CatOrange.jpg");

        Image img = icon.getImage();
        Image smallIcon = img.getScaledInstance(75,50,10);
        icon = new ImageIcon(smallIcon);

        this.setTitle("Odjo Player");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setLayout(null);
        this.setSize(640,480);
        this.setVisible(true);

        b.setBounds(260,200,180,90);
        b.addActionListener(this);
        b.setFocusable(false);
        b.setIcon(icon);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setVerticalTextPosition(JButton.BOTTOM);
        this.add(b);

        label.setIcon(icon2);
        label.setBounds(0,0,640,550);
        label.setVisible(false);
        this.add(label);

        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(156,94,51));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b) {
            System.out.println("super idol");
            label.setVisible(true);
            PlayMusic(filepath);
        }
    }
    public static void PlayMusic(String location) {
        try {
            File musicPath = new File(location); 
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }   
            else {
                System.out.println("Cannot find file");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
