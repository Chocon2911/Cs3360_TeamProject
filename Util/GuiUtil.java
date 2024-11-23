package Util;

import java.awt.*;
import javax.swing.*;

public abstract class GuiUtil
{
    //==========================================Variable==========================================
    protected int frameWidth = 500;
    protected int frameHeight = 600;

    protected int horizontalStrut = 20;
    protected int verticalStrut = 20;

    protected int normalLabelWidth = 100;
    protected int normalLabelHeight = 20;

    protected int panelFieldWidth = 300;
    protected int panelFieldHeight = 25;

    protected int bigButtonWidth = 200;
    protected int bigButtonHeight = 50;

    protected int smallButtonWidth = 100;
    protected int smallButtonHeight = 25;

    protected int textFieldAmount = 20;

    protected int titleSize = 50;

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
}
