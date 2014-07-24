package com.promeritage.reportTool.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;
import org.joda.time.LocalDate;

public class MonthlyMailPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public MonthlyMailPanel() {
        setLayout(null);
        LocalDate now = LocalDate.now();

        JLabel startDateLabel = new JLabel("起日");
        startDateLabel.setBounds(10, 10, 50, 25);
        add(startDateLabel);

        LocalDate withMinimumValue = now.dayOfMonth().withMinimumValue();
        final JXDatePicker startDatePicker = new JXDatePicker(withMinimumValue.toDate());
        startDatePicker.setBounds(45, 10, 100, 25);
        add(startDatePicker);

        JLabel endDateLabel = new JLabel("迄日");
        endDateLabel.setBounds(155, 10, 50, 25);
        add(endDateLabel);

        LocalDate withMaximumValue = now.dayOfMonth().withMaximumValue();
        final JXDatePicker endDatePicker = new JXDatePicker(withMaximumValue.toDate());
        endDatePicker.setBounds(185, 10, 100, 25);
        add(endDatePicker);

        JButton leftButton = new JButton("<");
        leftButton.setBounds(10, 46, 50, 25);
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date startDate = startDatePicker.getDate();
                if (startDate != null) {
                    LocalDate fromDateFields = LocalDate.fromDateFields(startDate).minusMonths(1);
                    LocalDate withMinimumValue = fromDateFields.dayOfMonth().withMinimumValue();
                    startDatePicker.setDate(withMinimumValue.toDate());
                }
                Date endDate = endDatePicker.getDate();
                if (endDate != null) {
                    LocalDate fromDateFields = LocalDate.fromDateFields(endDate).minusMonths(1);
                    LocalDate withMaximumValue = fromDateFields.dayOfMonth().withMaximumValue();
                    endDatePicker.setDate(withMaximumValue.toDate());
                }
            }
        });
        add(leftButton);

        JButton sendMailButton = new JButton("寄送請假紀錄");
        sendMailButton.setBounds(70, 46, 155, 25);
        sendMailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(sendMailButton);

        JButton rightButton = new JButton(">");
        rightButton.setBounds(235, 46, 50, 25);
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date startDate = startDatePicker.getDate();
                if (startDate != null) {
                    LocalDate fromDateFields = LocalDate.fromDateFields(startDate).minusMonths(-1);
                    LocalDate withMinimumValue = fromDateFields.dayOfMonth().withMinimumValue();
                    startDatePicker.setDate(withMinimumValue.toDate());
                }
                Date endDate = endDatePicker.getDate();
                if (endDate != null) {
                    LocalDate fromDateFields = LocalDate.fromDateFields(endDate).minusMonths(-1);
                    LocalDate withMaximumValue = fromDateFields.dayOfMonth().withMaximumValue();
                    endDatePicker.setDate(withMaximumValue.toDate());
                }
            }
        });
        add(rightButton);
    }

}
