package com.supanadit.restsuite.component.input;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
public class InputComponent extends JTextField {
    private String placeholder;

    @Override
    protected void paintComponent(final Graphics pG) {
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getInsets");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getFontMetrics");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getFontMetrics");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getInsets");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "drawString");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getDisabledTextColor");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "setColor");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "setRenderingHint");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getText");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "getText");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "length");
        com.supanadit.restsuite.logger.LogWriter.out("paintComponent", "paintComponent");
        super.paintComponent(pG);
        if (((placeholder == null) || (placeholder.length() == 0)) || (getText().length() > 0)) {
            return;
        }
        final Graphics2D g = ((Graphics2D) (pG));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics().getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }
}