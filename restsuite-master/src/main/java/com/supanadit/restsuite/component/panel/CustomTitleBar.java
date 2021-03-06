package com.supanadit.restsuite.component.panel;
import com.supanadit.restsuite.listener.DragListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
public class CustomTitleBar extends JPanel {
    public CustomTitleBar(JFrame frame) {
        setLayout(new MigLayout("insets 0 10 0 0"));
        DragListener drag = new DragListener();
        frame.addMouseListener(drag);
        frame.addMouseMotionListener(drag);
        JButton minimize = new JButton("Minimize");
        JButton close = new JButton("Close");
        minimize.addActionListener(( e) -> {
            frame.setState(Frame.ICONIFIED);
        });
        close.addActionListener(( e) -> {
            frame.dispose();
        });
        add(new JLabel("Rest Suite - Rest API Testing for Professional"), "push");
        // Button Minimize
        JPanel buttonMinimize = new JPanel(new MigLayout("fill"));
        JLabel minimizeLabel = new JLabel("Minimize");
        minimizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonMinimize.add(minimizeLabel, "push,grow");
        Color minimizeColor = buttonMinimize.getBackground();
        buttonMinimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mouseClicked", "setState");
                frame.setState(Frame.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mousePressed", "setState");
                frame.setState(Frame.ICONIFIED);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "darker");
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "setBackground");
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "getColor");
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "setForeground");
                minimizeLabel.setForeground(Color.white);
                Color background = UIManager.getColor("Panel.background");
                buttonMinimize.setBackground(background.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mouseExited", "setBackground");
                com.supanadit.restsuite.logger.LogWriter.out("mouseExited", "setForeground");
                minimizeLabel.setForeground(Color.black);
                buttonMinimize.setBackground(minimizeColor);
            }
        });
        add(buttonMinimize, "pushy,growy,w 55,h 28");
        // End Button Minimize
        // Button Close
        JPanel buttonClose = new JPanel(new MigLayout("fill"));
        JLabel buttonLabel = new JLabel("Close");
        buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonClose.add(buttonLabel, "push,grow");
        Color buttonColor = buttonClose.getBackground();
        buttonClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mouseClicked", "dispose");
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mousePressed", "dispose");
                frame.dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "decode");
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "setBackground");
                com.supanadit.restsuite.logger.LogWriter.out("mouseEntered", "setForeground");
                buttonLabel.setForeground(Color.white);
                buttonClose.setBackground(Color.decode("#E81123"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                com.supanadit.restsuite.logger.LogWriter.out("mouseExited", "setBackground");
                com.supanadit.restsuite.logger.LogWriter.out("mouseExited", "setForeground");
                buttonLabel.setForeground(Color.black);
                buttonClose.setBackground(buttonColor);
            }
        });
        add(buttonClose, "pushy,growy,w 55,h 28");
        // End Button Close
        Color lineColor = UIManager.getColor("Table.gridColor");
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, lineColor));
        frame.add(this, BorderLayout.NORTH);
    }
}