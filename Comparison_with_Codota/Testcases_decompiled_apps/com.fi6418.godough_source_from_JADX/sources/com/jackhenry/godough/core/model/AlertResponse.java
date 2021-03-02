package com.jackhenry.godough.core.model;

import java.util.List;

public class AlertResponse implements GoDoughType {
    private List<Alert> activeAlerts;

    public List<Alert> getActiveAlerts() {
        return this.activeAlerts;
    }

    public void setActiveAlerts(List<Alert> list) {
        this.activeAlerts = list;
    }
}
