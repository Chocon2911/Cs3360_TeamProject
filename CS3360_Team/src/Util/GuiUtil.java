package Util;

import java.awt.*;
import javax.swing.*;

public abstract class GuiUtil
{
    //==========================================Variable==========================================
    // Frame
    protected int frameWidth = 500;
    protected int frameHeight = 600;

    // Strut
    protected int horizontalStrut = 20;
    protected int verticalStrut = 20;

    // Label
    protected int smallLabelWidth = 100;
    protected int smallLabelHeight = 20;

    protected int normalLabelWidth = 300;
    protected int normalLabelHeight = 20;

    // Panel
    protected int panelTextFieldWidth = 300;
    protected int panelTextFieldHeight = 25;

    // Button
    protected int bigButtonWidth = 200;
    protected int bigButtonHeight = 50;

    protected int smallButtonWidth = 100;
    protected int smallButtonHeight = 25;

    // Text Field
    protected int textFieldAmount = 20;

    // Font
    protected int bigTitleSize = 50;
    protected int normalTitleSize = 30;
    protected int smallTitleSize = 20;

    protected int normalTextSize = 15;

    //===========================================Method===========================================
    protected void setFixedSize(JComponent component, int width, int height)
    {
        component.setPreferredSize(new Dimension(width, height));
        component.setMaximumSize(new Dimension(width, height));
        component.setMinimumSize(new Dimension(width, height));
    }

    protected void setAlignmentCenter(JComponent component)
    {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        component.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    protected void setAlignmentCenterLeft(JComponent component)
    {
        component.setAlignmentX(Component.LEFT_ALIGNMENT);
        component.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    protected void setAlignmentCenterRight(JComponent component)
    {
        component.setAlignmentX(Component.RIGHT_ALIGNMENT);
        component.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    protected JButton createButton(String name, int width, int height)
    {
        JButton button = new JButton(name);
        this.setFixedSize(button, width, height);
        return button;
    }

    //===========================================Panel============================================
    protected JPanel getMainPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        return panel;
    }

    //===========================================Field============================================
    protected JPanel getTextPanel(String name)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        this.setFixedSize(panel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel nameLabel = new JLabel(name);
        this.setAlignmentCenter(nameLabel);
        this.setFixedSize(nameLabel, smallLabelWidth, smallLabelHeight);

        // TextField
        JTextField textField = new JTextField(this.textFieldAmount);

        // Display
        panel.add(Box.createHorizontalGlue());
        panel.add(nameLabel);
        panel.add(Box.createHorizontalStrut(horizontalStrut));
        panel.add(textField);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }

    protected JPanel getPasswordPanel(String name)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        this.setFixedSize(panel, panelTextFieldWidth, panelTextFieldHeight);

        // Label
        JLabel nameLabel = new JLabel(name);
        this.setAlignmentCenter(nameLabel);
        this.setFixedSize(nameLabel, smallLabelWidth, smallLabelHeight);

        // TextField
        JPasswordField textField = new JPasswordField(this.textFieldAmount);

        // Display
        panel.add(Box.createHorizontalGlue());
        panel.add(nameLabel);
        panel.add(Box.createHorizontalStrut(horizontalStrut));
        panel.add(textField);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }

    //===========================================Label============================================
    protected JLabel getTitleLabel(String name)
    {
        JLabel titleLabel = new JLabel(name);
        titleLabel.setFont(new Font("Arial", Font.BOLD, bigTitleSize));
        this.setAlignmentCenter(titleLabel);
        return titleLabel;
    }

    protected JLabel getNormalLabel(String name)
    {
        JLabel normalLabel = new JLabel(name);
        normalLabel.setFont(new Font("Arial", Font.BOLD, normalTextSize));
        this.setAlignmentCenter(normalLabel);
        this.setFixedSize(normalLabel, normalLabelWidth, normalLabelHeight);
        return normalLabel;
    }

    protected JLabel getSmallLabel(String name)
    {
        JLabel smallLabel = new JLabel(name);
        smallLabel.setFont(new Font("Arial", Font.BOLD, smallTitleSize));
        this.setAlignmentCenter(smallLabel);
        this.setFixedSize(smallLabel, smallLabelWidth, smallLabelHeight);
        return smallLabel;
    }
}
