package UI.App2;

// import Obj.Main.Shop;
import Util.GuiUtil;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ShopUI extends GuiUtil
{
    //==========================================Variable==========================================
    // private Shop shop;

    //========================================Constructor=========================================
    public ShopUI()
    {
        // this.shop = null;
        this.displayMain();
    }

    // public ShopUI(Shop shop)
    // {
    //     this.shop = shop;
    //     this.displayMain();
    // }

    //==========================================Main UI===========================================
    private void displayMain()
    {
        // Frame
        JFrame frame = new JFrame("App2.Shop.Main");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Shop");
        this.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, titleSize));

        // Information Button
        JButton infoButton = createButton("Information", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(infoButton);
        infoButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                displayInfo();
            }
        });

        // CreateManager Button
        JButton createManagerButton = createButton("Create Manager", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(createManagerButton);
        createManagerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                displayCreateManager();
            }
        });

        // ChangeCheckInCode Button
        JButton changeCheckInCodeButton = createButton("Change Check In Code", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(changeCheckInCodeButton);
        changeCheckInCodeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                displayChangeCheckInCode();
            }
        });

        // Quit Button
        JButton quitButton = createButton("Quit", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(quitButton);
        quitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                displayQuit();
            }
        });

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(this.verticalStrut));
        panel.add(infoButton);
        panel.add(Box.createVerticalStrut(this.verticalStrut));
        panel.add(createManagerButton);
        panel.add(Box.createVerticalStrut(this.verticalStrut));
        panel.add(changeCheckInCodeButton);
        panel.add(Box.createVerticalStrut(this.verticalStrut));
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());
        
        frame.add(panel);
        frame.setVisible(true);
        
    }

    //=======================================Information UI=======================================
    private void displayInfo()
    {
        // ===Frame===
        JFrame frame = new JFrame("App2.Shop.Main.Information");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //=====================================Create Manager UI======================================
    private void displayCreateManager()
    {

    }

    //===================================Change CheckIn Code UI===================================
    private void displayChangeCheckInCode()
    {

    }

    //==========================================Quit UI===========================================
    private void displayQuit()
    {
        
    }

    //============================================Test============================================
    public static void main(String[] args) 
    {
        new ShopUI();
    }
}
