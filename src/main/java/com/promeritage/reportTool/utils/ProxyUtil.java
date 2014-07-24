package com.promeritage.reportTool.utils;

import java.util.Properties;

import com.promeritage.reportTool.key.Key;
import com.promeritage.reportTool.main.ReportTool;

public class ProxyUtil {

    public static void setProxy(boolean selected) {
        Properties properties = System.getProperties();
        ReportTool.PREF.putBoolean(Key.PROXY_SET, selected);
        if (selected) {
            properties.put(Key.PROXY_SET, "true");
            properties.put(Key.PROXY_HOST, "10.160.3.88");
            properties.put(Key.PROXY_PORT, "8080");
        } else {
            properties.remove(Key.PROXY_SET);
            properties.remove(Key.PROXY_HOST);
            properties.remove(Key.PROXY_PORT);
        }
    }

}
