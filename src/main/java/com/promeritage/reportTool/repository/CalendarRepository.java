package com.promeritage.reportTool.repository;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.util.AuthenticationException;
import com.promeritage.reportTool.main.ReportTool;

public class CalendarRepository {
    private static CalendarService service = new CalendarService(ReportTool.class.getName());

    public static void setAuth(String username, String password) throws AuthenticationException {
        if (!username.contains("@")) {
            username = username.trim().concat("@promeritage.com.tw");
        }
        service.setUserCredentials(username, password);
    }
}
