package com.promeritage.reportTool.main;

import java.awt.EventQueue;
import java.util.prefs.Preferences;

import com.promeritage.reportTool.view.frame.LoginFrame;

/**
 * 
 * @author Tim.ling
 */
public class ReportTool {

    /**
     * 儲存使用者資訊 <br>
     * (java內建, 安全)
     */
    public static final Preferences PREF = Preferences.userRoot().node(ReportTool.class.getName());

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
