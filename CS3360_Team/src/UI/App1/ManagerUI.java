package UI.App1;

import Controller.Child.ManagerCtrl;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class ManagerUI extends GuiUtil
{
    private ManagerCtrl ctrl;
    
    //========================================Constructor=========================================
    public ManagerUI()
    {
        this.displayMain();
        this.ctrl = null;
    }

    public ManagerUI(String id)
    {
        this.ctrl = new ManagerCtrl(id);
    }

    //=========================================PreMain UI=========================================
    private void displayPreMain() 
    {
        // Frame
        JFrame frame = new JFrame("Manager.PreMain");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Change to logOut() later

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Manager");
        this.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));

        // Infomation Button
        JButton infoButton = createButton("Information", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(infoButton);
        infoButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayInfo();
        });

        // JoinShop Button
        JButton joinShopButton = createButton("Join Shop", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(joinShopButton);
        joinShopButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayJoinShop();
        });

        // Quit Button
        JButton quitButton = createButton("Quit", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(quitButton);
        quitButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayQuit();
        });

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(infoButton);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(joinShopButton);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //==========================================Main UI===========================================
    private void displayMain()
    {
        // Frame
        JFrame frame = new JFrame("Manager.Main");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Manager");
        this.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));

        // Info Button
        JButton infoButton = createButton("Information", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(infoButton);
        infoButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayInfo();
        });

        // CreateStaff Button
        JButton createStaffButton = createButton("Create Staff", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(createStaffButton);
        createStaffButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayCreateStaff();
        });

        // DeleteStaff Button
        JButton deleteStaffButton = createButton("Delete Staff", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(deleteStaffButton);
        deleteStaffButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayDeleteStaff();
        });

        // AddItem Button
        JButton addItemButton = createButton("Add Item", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(addItemButton);
        addItemButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayAddItem();
        });

        // Quit Button
        JButton quitButton = createButton("Quit", bigButtonWidth, bigButtonHeight);
        this.setAlignmentCenter(quitButton);
        quitButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayQuit();
        });

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(infoButton);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(createStaffButton);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(deleteStaffButton);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(addItemButton);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //=======================================Information UI=======================================
    private void displayInfo()
    {
        // ===Frame===
        JFrame frame = new JFrame("Manager.Information");
        frame.setSize(600, 700);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);
        frame.setLayout(new BorderLayout());



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));
        this.setAlignmentCenter(titleLabel);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createHorizontalStrut(verticalStrut));
        // panel.add(ctrl.displayInfo());
        panel.add(Box.createVerticalGlue());


        
        // ===Back Panel===
        // Back Panel
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));

        // Back Button
        JButton backButton = this.createButton("Back", smallButtonWidth, bigButtonHeight);
        backButton.setAlignmentY(Component.TOP_ALIGNMENT);
        backButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayMain();
        });

        // Display
        backPanel.add(Box.createVerticalStrut(verticalStrut));
        backPanel.add(backButton);



        // ===scrollPane===
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);



        // ===Display===
        frame.add(backPanel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    //========================================JoinShop UI=========================================
    private void displayJoinShop()
    {
        // ===Frame===
        JFrame frame = new JFrame("Manager.JoinShop");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Join Shop");
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));
        this.setAlignmentCenter(titleLabel);



        // ===CheckInCode Panel===
        // Panel
        JPanel checkInCodePanel = new JPanel();
        checkInCodePanel.setLayout(new BoxLayout(checkInCodePanel, BoxLayout.X_AXIS));
        this.setFixedSize(checkInCodePanel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel checkInCodeLabel = new JLabel("CheckIn Code:");
        this.setAlignmentCenter(checkInCodeLabel);
        this.setFixedSize(checkInCodeLabel, normalLabelWidth, normalLabelHeight);

        // TextField
        JTextField checkInCodeTextField = new JTextField(this.textFieldAmount);

        // Display
        checkInCodePanel.add(Box.createHorizontalGlue());
        checkInCodePanel.add(checkInCodeLabel);
        checkInCodePanel.add(Box.createHorizontalStrut(horizontalStrut));
        checkInCodePanel.add(checkInCodeTextField);
        checkInCodePanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        this.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = this.createButton("Cancel", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Join Button
        JButton joinButton = this.createButton("Join", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(joinButton);
        joinButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(horizontalStrut));
        buttonPanel.add(joinButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(checkInCodePanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //=======================================CreateStaff UI=======================================
    private void displayCreateStaff()
    {
        // ===Frame===
        JFrame frame = new JFrame("Manager.CreateStaff");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);

        // ===Panel===
        JPanel panel = this.getMainPanel();

        JLabel titleLabel = this.getTitleLabel("Create Staff");
        JPanel namePanel = this.getTextPanel("Name:");
        JPanel userNamePanel = this.getTextPanel("User Name:");
        JPanel passwordPanel = this.getPasswordPanel("Password:");

        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        this.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = this.createButton("Cancel", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayMain();
        });

        // Create Button
        JButton createButton = this.createButton("Create", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(createButton);
        createButton.addActionListener((ActionEvent e) -> 
        {
            
        });
        
        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(horizontalStrut));
        buttonPanel.add(createButton);
        buttonPanel.add(Box.createHorizontalGlue());


        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(userNamePanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());
        
        frame.add(panel);
        frame.setVisible(true);
    }

    //=======================================DeleteStaff UI=======================================
    private void displayDeleteStaff()
    {
        // ===Frame===
        JFrame frame = new JFrame("Manager.DeleteStaff");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);

        
        
        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Delete Staff");
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));
        this.setAlignmentCenter(titleLabel);



        // ===Id Panel===
        // Panel
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
        this.setFixedSize(idPanel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel idLabel = new JLabel("Id:");
        this.setAlignmentCenter(idLabel);
        this.setFixedSize(idLabel, normalLabelWidth, normalLabelHeight);

        // TextField
        JTextField idTextField = new JTextField(this.textFieldAmount);

        // Display
        idPanel.add(Box.createHorizontalGlue());
        idPanel.add(idLabel);
        idPanel.add(Box.createHorizontalStrut(horizontalStrut));
        idPanel.add(idTextField);
        idPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        this.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = this.createButton("Cancel", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Delete Button
        JButton deleteButton = this.createButton("Delete", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(deleteButton);
        deleteButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(horizontalStrut));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(idPanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //=========================================AddItem UI=========================================
    private void displayAddItem()
    {
        // ===Frame===
        JFrame frame = new JFrame("Manager.AddItem");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);

        
        
        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = new JLabel("Add Item");
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));
        this.setAlignmentCenter(titleLabel);




        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        this.setFixedSize(namePanel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel nameLabel = new JLabel("Name:");
        this.setAlignmentCenter(nameLabel);
        this.setFixedSize(nameLabel, normalLabelWidth, normalLabelHeight);

        // TextField
        JTextField nameTextField = new JTextField(this.textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(horizontalStrut));
        namePanel.add(nameTextField);
        namePanel.add(Box.createHorizontalGlue());



        // ===Price Panel===
        // Panel
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.X_AXIS));
        this.setFixedSize(pricePanel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel priceLabel = new JLabel("Price:");
        this.setAlignmentCenter(priceLabel);
        this.setFixedSize(priceLabel, normalLabelWidth, normalLabelHeight);

        // TextField
        JTextField priceTextField = new JTextField(this.textFieldAmount);

        // Display
        pricePanel.add(Box.createHorizontalGlue());
        pricePanel.add(priceLabel);
        pricePanel.add(Box.createHorizontalStrut(horizontalStrut));
        pricePanel.add(priceTextField);
        pricePanel.add(Box.createHorizontalGlue());

        
        
        // ===ItemType Panel===
        // Panel
        JPanel itemTypePanel = new JPanel();
        itemTypePanel.setLayout(new BoxLayout(itemTypePanel, BoxLayout.X_AXIS));
        this.setFixedSize(itemTypePanel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel itemTypeLabel = new JLabel("ItemType:");
        this.setAlignmentCenter(itemTypeLabel);
        this.setFixedSize(itemTypeLabel, normalLabelWidth, normalLabelHeight);

        // JList

        // Display

        // ===Amount Panel===
        // Panel
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.X_AXIS));
        this.setFixedSize(amountPanel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel amountLabel = new JLabel("Amount:");
        this.setAlignmentCenter(amountLabel);
        this.setFixedSize(amountLabel, normalLabelWidth, normalLabelHeight);

        // TextField
        JTextField amountTextField = new JTextField(this.textFieldAmount);

        // Display
        amountPanel.add(Box.createHorizontalGlue());
        amountPanel.add(amountLabel);
        amountPanel.add(Box.createHorizontalStrut(horizontalStrut));
        amountPanel.add(amountTextField);
        amountPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        this.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = this.createButton("Cancel", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Add Button
        JButton addButton = this.createButton("Add", smallButtonWidth, smallButtonHeight);
        this.setAlignmentCenter(addButton);
        addButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(horizontalStrut));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(pricePanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(itemTypePanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(amountPanel);
        panel.add(Box.createVerticalStrut(verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //==========================================Quit UI===========================================
    private void displayQuit()
    {
        
    }

    //===========================================Other============================================
    private void setDefaultWindowClose(JFrame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                // ctrl.logOut();
                System.exit(0);
            }
        });
    }

    //============================================Test============================================
    public static void main(String[] args)
    {
        new ManagerUI();
    }
}
