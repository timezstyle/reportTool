package com.promeritage.reportTool.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.promeritage.reportTool.key.Key;
import com.promeritage.reportTool.main.ReportToolApp;

public class SettingPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public SettingPanel() {
        setLayout(null);

        JLabel usernameLabel = new JLabel("中文姓名");
        usernameLabel.setBounds(10, 10, 88, 14);
        add(usernameLabel);

        final JTextField usernameText = new JTextField();
        String username = ReportToolApp.PREF.get(Key.USER_NAME, "");
        usernameText.setText(username);
        usernameText.setBounds(108, 8, 217, 20);
        add(usernameText);

        JLabel officerEmailLabel = new JLabel("長官 email");
        officerEmailLabel.setBounds(10, 40, 88, 14);
        add(officerEmailLabel);

        final JTextField officerEmailAddrText = new JTextField();
        String officerEmailAddr = ReportToolApp.PREF.get(Key.DAILY_MAIL_ADDR,
                "ireneliu@cht.com.tw,evanhuang@cht.com.tw,annyhu@cht.com.tw");
        officerEmailAddrText.setText(officerEmailAddr);
        officerEmailAddrText.setBounds(108, 38, 217, 20);
        add(officerEmailAddrText);

        JLabel hrEmailAddrLabel = new JLabel("HR email");
        hrEmailAddrLabel.setBounds(10, 70, 88, 14);
        add(hrEmailAddrLabel);

        final JTextField hrEmailAddrText = new JTextField();
        String hrEmailAddr = ReportToolApp.PREF.get(Key.HR_MAIL_ADDR,
                "funny.wu@promeritage.com.tw,queenie.chang@promeritage.com.tw");
        hrEmailAddrText.setText(hrEmailAddr);
        hrEmailAddrText.setBounds(108, 68, 217, 20);
        add(hrEmailAddrText);

        JLabel joinSystemIdsLabel = new JLabel("參予模組");
        joinSystemIdsLabel.setBounds(10, 105, 88, 14);
        add(joinSystemIdsLabel);

        final JTextField joinSystemIdsText = new JTextField();
        String joinSystemIds = ReportToolApp.PREF.get(Key.JOIN_SYSTEM_IDS, "CTA,FMS,MCT");
        joinSystemIdsText.setText(joinSystemIds);
        joinSystemIdsText.setBounds(108, 102, 217, 20);
        add(joinSystemIdsText);

        JButton saveButton = new JButton("儲存");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportToolApp.PREF.put(Key.USER_NAME, usernameText.getText());
                ReportToolApp.PREF.put(Key.DAILY_MAIL_ADDR, officerEmailAddrText.getText());
                ReportToolApp.PREF.put(Key.HR_MAIL_ADDR, hrEmailAddrText.getText());
                ReportToolApp.PREF.put(Key.JOIN_SYSTEM_IDS, joinSystemIdsText.getText());
            }
        });
        saveButton.setBounds(236, 136, 89, 23);
        add(saveButton);

    }
}
