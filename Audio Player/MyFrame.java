import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.File;


import javax.sound.sampled.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton b1 = new JButton("Caramelldansen");
    JButton b2 = new JButton("Super Idol");
    JButton b3 = new JButton("DOTA");

    JButton play = new JButton();
    JButton pause = new JButton();
    JButton reset = new JButton();

    JButton home = new JButton("Home");
    JButton radio = new JButton("Radio");
    JButton share = new JButton("Share");
    JLabel caramell_IMG = new JLabel();
    JLabel superIdolSad_IMG = new JLabel();
    JLabel ricardomilos_IMG = new JLabel();

    JPanel leftPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JProgressBar bar = new JProgressBar();

    File musicPath = new File("");
    Clip clip;

    MyFrame() {
        ImageIcon icon = new ImageIcon("logo.jpg");
        ImageIcon caramell_button = new ImageIcon("CatOrange.jpg");
        ImageIcon sadIdol_button = new ImageIcon("deepfriedidol.jpg");
        ImageIcon ricardoMilos_Icon = new ImageIcon("ricardomilos.jpg");
        
        ImageIcon play_icon = new ImageIcon("play.png");
        ImageIcon pause_icon = new ImageIcon("pause.png");
        ImageIcon reset_icon = new ImageIcon("rewind.png");

        ImageIcon caramell_button_small = resizer(caramell_button);
        ImageIcon sadIdol_button_small = resizer(sadIdol_button);
        ImageIcon ricardoMilos_Icon_small = resizer(ricardoMilos_Icon);
        ImageIcon playIcon_small = resizer(play_icon);
        ImageIcon pauseIcon_small = resizer(pause_icon);
        ImageIcon resetIcon_small = resizer(reset_icon);

        this.setTitle("Odjo Player");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setSize(640,480);
        this.setVisible(true);

        b1.setBounds(5,10,90,80);
        b1.addActionListener(this);
        b1.setFocusable(false);

        b1.setIcon(caramell_button_small);
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setVerticalTextPosition(JButton.BOTTOM);

        b2.setBounds(5,110,90,80);
        b2.addActionListener(this);
        b2.setFocusable(false);
        b2.setIcon(sadIdol_button_small);
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setVerticalTextPosition(JButton.BOTTOM);

        b3.setBounds(5,210,90,80);
        b3.addActionListener(this);
        b3.setFocusable(false);
        b3.setIcon(ricardoMilos_Icon_small);
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setVerticalTextPosition(JButton.BOTTOM);

        home.setBounds(0,0,30,32);
        home.addActionListener(this);
        home.setFocusable(false);

        radio.setBounds(0,0,30,32);
        radio.addActionListener(this);
        radio.setFocusable(false);
        
        share.setBounds(0,0,30,32);
        share.addActionListener(this);
        share.setFocusable(false);

        play.setBounds(0,0,30,32);
        play.addActionListener(this);
        play.setFocusable(false);
        play.setIcon(playIcon_small);
        play.setBounds(0, 0, 40, 40);

        reset.setBounds(0,0,30,32);
        reset.addActionListener(this);
        reset.setFocusable(false);
        reset.setIcon(resetIcon_small);
        reset.setBounds(0, 0, 40, 40);

        pause.setBounds(0,0,30,32);
        pause.addActionListener(this);
        pause.setFocusable(false);
        pause.setIcon(pauseIcon_small);
        pause.setBounds(0, 0, 40, 40);

        caramell_IMG.setIcon(caramell_button);
        caramell_IMG.setBounds(0,0,700,700);
        caramell_IMG.setVisible(false);

        superIdolSad_IMG.setIcon(sadIdol_button);
        superIdolSad_IMG.setBounds(0,0,700,700);
        superIdolSad_IMG.setVisible(false);

        ricardomilos_IMG.setIcon(ricardoMilos_Icon);
        ricardomilos_IMG.setBounds(0,0,700,700);
        ricardomilos_IMG.setVisible(false);

        bar.setPreferredSize(new Dimension(200,15));
        bar.setStringPainted(true);
        
        leftPanel.setBackground(Color.GRAY);
        leftPanel.setPreferredSize(new Dimension(100,105));
        leftPanel.setLayout(null);
        leftPanel.add(b1);
        leftPanel.add(b2);
        leftPanel.add(b3);

        rightPanel.setBackground(Color.RED);
        rightPanel.setPreferredSize(new Dimension(10,100));

        centerPanel.setBackground(Color.BLACK);
        centerPanel.setPreferredSize(new Dimension(300,100));
        centerPanel.add(caramell_IMG);
        centerPanel.add(superIdolSad_IMG);
        centerPanel.add(ricardomilos_IMG);

        topPanel.setBackground(Color.BLUE);
        topPanel.setPreferredSize(new Dimension(80,50));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.add(home);
        topPanel.add(radio);
        topPanel.add(share);

        bottomPanel.setBackground(Color.YELLOW);
        bottomPanel.setPreferredSize(new Dimension(80,80));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(pause);
        bottomPanel.add(play);
        bottomPanel.add(reset);
        bottomPanel.add(bar);

        this.add(leftPanel,BorderLayout.WEST);
        this.add(rightPanel,BorderLayout.EAST);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(bottomPanel,BorderLayout.SOUTH);

        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(156,94,51));
    }

    @Override
    public void actionPerformed(ActionEvent event){
        
        try {
            if(musicPath.exists() && clip == null) {
                bar.setValue(0);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                
                clip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.close();
                            clip = null;
                        }
                    }
                });
            } 
            else if (!musicPath.exists()) {
                System.out.println("Cannot find file");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        if (event.getSource()==share) {
            bar.setValue(0);
            clip.close();
            clip=null;
            this.dispose();
            new ShareWindow();
        }
        if (event.getSource()==b1) {
            bar.setValue(0);
            System.out.println("selected caramelldansen super idol");
            ricardomilos_IMG.setVisible(false);
            superIdolSad_IMG.setVisible(false);
            caramell_IMG.setVisible(true);
            musicPath = new File("Caramelldansen Super Idol.wav");
        }
        if (event.getSource()==b2) {
            bar.setValue(0);
            System.out.println("selected super idol sad");
            ricardomilos_IMG.setVisible(false);
            caramell_IMG.setVisible(false);
            superIdolSad_IMG.setVisible(true);
            musicPath = new File("super idol sad.wav");
        }
        if (event.getSource()==b3) {
            bar.setValue(0);
            System.out.println("selected dota");
            caramell_IMG.setVisible(false);
            superIdolSad_IMG.setVisible(false);
            ricardomilos_IMG.setVisible(true);
            musicPath = new File("dota.wav");
        }
        
        if(event.getSource()==pause) {
            bar.setValue(0);
            clip.stop();
            clip = null;

        }
        if(event.getSource()==play) {
            clip.start();
            
            System.out.println("play");
        }  
        if(event.getSource()==reset) {
            clip.setMicrosecondPosition(0); 
            System.out.println("reset");
            bar.setValue(0);
        }   
    }

    public ImageIcon resizer(ImageIcon icon) {
        Image img = icon.getImage();
        Image newIcon = img.getScaledInstance(75,50,10);
        icon = new ImageIcon(newIcon);
        return icon;
        }
}
