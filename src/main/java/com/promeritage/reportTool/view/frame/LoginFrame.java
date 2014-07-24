package com.promeritage.reportTool.view.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gdata.util.AuthenticationException;
import com.promeritage.reportTool.key.Key;
import com.promeritage.reportTool.main.ReportTool;
import com.promeritage.reportTool.repository.CalendarRepository;
import com.promeritage.reportTool.utils.ProxyUtil;

/**
 * @author Tim.ling
 */
public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Create the frame.
     */
    public LoginFrame() {
        setTitle("普瑞德報表工具 - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        final JTextField userText = new JTextField();
        userText.setText(ReportTool.PREF.get(Key.USER_EMAIL, ""));
        userText.setBounds(100, 10, 184, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        final JPasswordField passwordText = new JPasswordField();
        passwordText.setText(ReportTool.PREF.get(Key.PASSWORD, ""));
        passwordText.setBounds(100, 40, 184, 25);
        panel.add(passwordText);

        final JCheckBox rememberPassword = new JCheckBox("remember password");
        rememberPassword.setSelected(ReportTool.PREF.getBoolean(Key.REMEMBER_PASSWORD, false));
        rememberPassword.setBounds(100, 80, 160, 25);
        panel.add(rememberPassword);
        rememberPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportTool.PREF.putBoolean(Key.REMEMBER_PASSWORD, rememberPassword.isSelected());
            }
        });

        final JCheckBox useProxy = new JCheckBox("useProxy");
        useProxy.setSelected(ReportTool.PREF.getBoolean(Key.PROXY_SET, false));
        useProxy.setBounds(100, 120, 160, 25);
        panel.add(useProxy);
        ProxyUtil.setProxy(useProxy.isSelected());
        useProxy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProxyUtil.setProxy(useProxy.isSelected());
            }
        });

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                ReportTool.PREF.put(Key.USER_EMAIL, username);
                if (rememberPassword.isSelected()) {
                    ReportTool.PREF.put(Key.PASSWORD, password);
                } else {
                    ReportTool.PREF.remove(Key.PASSWORD);
                }

                try {
                    CalendarRepository.setAuth(username, password);
                    setVisible(false);

                    WelcomeFrame welcomeFrame = new WelcomeFrame();
                    welcomeFrame.setVisible(true);
                } catch (AuthenticationException e1) {
                    throw new RuntimeException(e1);
                }

            }
        });

        setContentPane(panel);
    }

}
