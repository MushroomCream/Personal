import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareWindow extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    JPanel bottomPanel = new JPanel();
    JPanel centerPanel = new JPanel();

    JButton back = new JButton("Back");
    JButton discord = new JButton();
    JButton messenger = new JButton();
    JButton twitter = new JButton();
    JButton instagram = new JButton();
    JButton snapchat = new JButton();
    JButton telegram = new JButton();

    ShareWindow() {
        ImageIcon discordIcon = new ImageIcon("discord.png");
        ImageIcon messengerIcon = new ImageIcon("messenger.png");
        ImageIcon twitterIcon = new ImageIcon("twitter.png");
        ImageIcon instagramIcon = new ImageIcon("instagram.png");
        ImageIcon snapchatIcon = new ImageIcon("snapchat.png");
        ImageIcon telegramIcon = new ImageIcon("telegram.png");

        discordIcon = resizer(discordIcon);
        messengerIcon = resizer(messengerIcon);
        twitterIcon = resizer(twitterIcon);
        instagramIcon = resizer(instagramIcon);
        snapchatIcon = resizer(snapchatIcon);
        telegramIcon = resizer(telegramIcon);

        frame.setTitle("Share Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(centerPanel,BorderLayout.CENTER);

        back.setFocusable(false);
        back.addActionListener(this);

        discord.addActionListener(this);
        discord.setFocusable(false);
        discord.setIcon(discordIcon);

        messenger.addActionListener(this);
        messenger.setFocusable(false);
        messenger.setIcon(messengerIcon);

        twitter.addActionListener(this);
        twitter.setFocusable(false);
        twitter.setIcon(twitterIcon);

        instagram.addActionListener(this);
        instagram.setFocusable(false);
        instagram.setIcon(instagramIcon);

        snapchat.addActionListener(this);
        snapchat.setFocusable(false);
        snapchat.setIcon(snapchatIcon);

        telegram.addActionListener(this);
        telegram.setFocusable(false);
        telegram.setIcon(telegramIcon);

        centerPanel.setPreferredSize(new Dimension(400,400));
        centerPanel.setBackground(Color.black);
        centerPanel.setLayout(new GridLayout(2,3));
        centerPanel.add(discord);
        centerPanel.add(messenger);
        centerPanel.add(twitter);
        centerPanel.add(instagram);
        centerPanel.add(snapchat);
        centerPanel.add(telegram);

        bottomPanel.setBackground(Color.YELLOW);
        bottomPanel.setPreferredSize(new Dimension(80,80));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(back);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back) {
            frame.dispose();
            new MyFrame();
            System.out.println("pressed share button");
        }
    }
    public ImageIcon resizer(ImageIcon icon) {
        Image img = icon.getImage();
        Image newIcon = img.getScaledInstance(100,100,10);
        icon = new ImageIcon(newIcon);
        return icon;
        }
}