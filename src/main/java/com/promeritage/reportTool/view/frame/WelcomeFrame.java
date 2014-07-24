package com.promeritage.reportTool.view.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.promeritage.reportTool.view.panel.DailyReportPanel;
import com.promeritage.reportTool.view.panel.MonthlyMailPanel;
import com.promeritage.reportTool.view.panel.MonthlyReportPanel;
import com.promeritage.reportTool.view.panel.SettingPanel;

public class WelcomeFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Create the frame.
     */
    public WelcomeFrame() {
        setTitle("普瑞德報表工具");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel panel_1 = new SettingPanel();
        tabbedPane.addTab("設定", null, panel_1, null);

        JPanel panel_2 = new DailyReportPanel();
        tabbedPane.addTab("日報表", null, panel_2, null);

        JPanel panel_3 = new MonthlyReportPanel();
        tabbedPane.addTab("月報表( 工作日誌 )", null, panel_3, null);

        JPanel panel_4 = new MonthlyMailPanel();
        tabbedPane.addTab("月請假紀錄", null, panel_4, null);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

}
