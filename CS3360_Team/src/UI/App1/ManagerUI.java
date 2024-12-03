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

public class ManagerUI
{
    private final ManagerCtrl ctrl;
    
    //========================================Constructor=========================================
    public ManagerUI()
    {
        this.displayMain();
        this.ctrl = new ManagerCtrl();
    }

    public ManagerUI(String id)
    {
        this.ctrl = new ManagerCtrl(id);
        this.displayPreMain();
    }

    //=========================================PreMain UI=========================================
    private void displayPreMain() 
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        JFrame frame = new JFrame("Manager.PreMain");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Change to logOut() later

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Manager");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));

        // Infomation Button
        JButton infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(infoButton);
        infoButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayInfo();
        });

        // JoinShop Button
        JButton joinShopButton = guiUtil.createButton("Join Shop", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(joinShopButton);
        joinShopButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayJoinShop();
        });

        // Quit Button
        JButton quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(quitButton);
        quitButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayQuit();
        });

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(joinShopButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //==========================================Main UI===========================================
    private void displayMain()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        JFrame frame = new JFrame("Manager.Main");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Manager");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));

        // Info Button
        JButton infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(infoButton);
        infoButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayInfo();
        });

        // CreateStaff Button
        JButton createStaffButton = guiUtil.createButton("Create Staff", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(createStaffButton);
        createStaffButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayCreateStaff();
        });

        // DeleteStaff Button
        JButton deleteStaffButton = guiUtil.createButton("Delete Staff", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(deleteStaffButton);
        deleteStaffButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayDeleteStaff();
        });

        // AddItem Button
        JButton addItemButton = guiUtil.createButton("Add Item", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(addItemButton);
        addItemButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayAddItem();
        });

        // Quit Button
        JButton quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(quitButton);
        quitButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayQuit();
        });

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(createStaffButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(deleteStaffButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(addItemButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //=======================================Information UI=======================================
    private void displayInfo()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

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
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createHorizontalStrut(guiUtil.verticalStrut));
        panel.add(ctrl.displayInfo());
        panel.add(Box.createVerticalGlue());


        
        // ===Back Panel===
        // Back Panel
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));

        // Back Button
        JButton backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        backButton.setAlignmentY(Component.TOP_ALIGNMENT);
        backButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            int backButtonPressed = ctrl.backButtonPressed();
            if (backButtonPressed == 1) displayPreMain();
            else if (backButtonPressed == 2) displayMain();
        });

        // Display
        backPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
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
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        JFrame frame = new JFrame("Manager.JoinShop");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Join Shop");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);



        // ===CheckInCode Panel===
        // Panel
        JPanel checkInCodePanel = new JPanel();
        checkInCodePanel.setLayout(new BoxLayout(checkInCodePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(checkInCodePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel checkInCodeLabel = new JLabel("CheckIn Code:");
        guiUtil.setAlignmentCenter(checkInCodeLabel);
        guiUtil.setFixedSize(checkInCodeLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        JTextField checkInCodeTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        checkInCodePanel.add(Box.createHorizontalGlue());
        checkInCodePanel.add(checkInCodeLabel);
        checkInCodePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        checkInCodePanel.add(checkInCodeTextField);
        checkInCodePanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayPreMain();
        });

        // Join Button
        JButton joinButton = guiUtil.createButton("Join", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(joinButton);
        joinButton.addActionListener((ActionEvent e) -> 
        {
            String checkInCode = checkInCodeTextField.getText();

            int joinShop = ctrl.joinShop(checkInCode);
            if (joinShop == 1) // Wrong CheckInCode
            {
                System.out.println("joinShop(): Wrong CheckInCode: " + checkInCode);
                JOptionPane.showMessageDialog(null, "Wrong CheckInCode!");
            }
            else if (joinShop == 2) // Shop is not online
            {
                System.out.println("joinShop(): Shop is not online: " + checkInCode);
                JOptionPane.showMessageDialog(null, "Wrong CheckInCode");
            } 
            else // Success
            {
                JOptionPane.showMessageDialog(null, "Join Shop successfully");
                frame.dispose();
                displayMain();
            }
        });

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(joinButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(checkInCodePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //=======================================CreateStaff UI=======================================
    private void displayCreateStaff()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        JFrame frame = new JFrame("Manager.CreateStaff");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);

        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();

        JLabel titleLabel = guiUtil.getTitleLabel("Create Staff");
        JPanel namePanel = guiUtil.getTextPanel("Name:");
        JPanel userNamePanel = guiUtil.getTextPanel("User Name:");
        JPanel passwordPanel = guiUtil.getPasswordPanel("Password:");

        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            frame.dispose();
            displayMain();
        });

        // Create Button
        JButton createButton = guiUtil.createButton("Create", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(createButton);
        createButton.addActionListener((ActionEvent e) -> 
        {
            
        });
        
        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(createButton);
        buttonPanel.add(Box.createHorizontalGlue());


        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(userNamePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());
        
        frame.add(panel);
        frame.setVisible(true);
    }

    //=======================================DeleteStaff UI=======================================
    private void displayDeleteStaff()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        JFrame frame = new JFrame("Manager.DeleteStaff");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);

        
        
        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Delete Staff");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);



        // ===Id Panel===
        // Panel
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(idPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel idLabel = new JLabel("Id:");
        guiUtil.setAlignmentCenter(idLabel);
        guiUtil.setFixedSize(idLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        JTextField idTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        idPanel.add(Box.createHorizontalGlue());
        idPanel.add(idLabel);
        idPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        idPanel.add(idTextField);
        idPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Delete Button
        JButton deleteButton = guiUtil.createButton("Delete", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(deleteButton);
        deleteButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(idPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }

    //=========================================AddItem UI=========================================
    private void displayAddItem()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        JFrame frame = new JFrame("Manager.AddItem");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(true);
        this.setDefaultWindowClose(frame);

        
        
        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = new JLabel("Add Item");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);




        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(namePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel nameLabel = new JLabel("Name:");
        guiUtil.setAlignmentCenter(nameLabel);
        guiUtil.setFixedSize(nameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        JTextField nameTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        namePanel.add(nameTextField);
        namePanel.add(Box.createHorizontalGlue());



        // ===Price Panel===
        // Panel
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(pricePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel priceLabel = new JLabel("Price:");
        guiUtil.setAlignmentCenter(priceLabel);
        guiUtil.setFixedSize(priceLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        JTextField priceTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        pricePanel.add(Box.createHorizontalGlue());
        pricePanel.add(priceLabel);
        pricePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        pricePanel.add(priceTextField);
        pricePanel.add(Box.createHorizontalGlue());

        
        
        // ===ItemType Panel===
        // Panel
        JPanel itemTypePanel = new JPanel();
        itemTypePanel.setLayout(new BoxLayout(itemTypePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(itemTypePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel itemTypeLabel = new JLabel("ItemType:");
        guiUtil.setAlignmentCenter(itemTypeLabel);
        guiUtil.setFixedSize(itemTypeLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // JList

        // Display

        // ===Amount Panel===
        // Panel
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(amountPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel amountLabel = new JLabel("Amount:");
        guiUtil.setAlignmentCenter(amountLabel);
        guiUtil.setFixedSize(amountLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        JTextField amountTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        amountPanel.add(Box.createHorizontalGlue());
        amountPanel.add(amountLabel);
        amountPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        amountPanel.add(amountTextField);
        amountPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        JButton cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(cancelButton);
        cancelButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Add Button
        JButton addButton = guiUtil.createButton("Add", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(addButton);
        addButton.addActionListener((ActionEvent e) -> 
        {
            
        });

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(pricePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(itemTypePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(amountPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
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
