package com.promeritage.reportTool.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;

public class DailyReportPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public DailyReportPanel() {
        setLayout(null);

        final JXDatePicker startDatePicker = new JXDatePicker(new Date());
        startDatePicker.setBounds(10, 10, 100, 25);
        add(startDatePicker);

        JButton sendMailButton = new JButton("產出日報");
        sendMailButton.setBounds(10, 46, 128, 25);
        sendMailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(sendMailButton);

    }

}
