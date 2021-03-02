package com.jackhenry.godough.core.model;

import java.util.List;

public class NotificationList implements GoDoughType {
    private List<Notification> notifications;

    public NotificationList() {
    }

    public NotificationList(List<Notification> list) {
        this.notifications = list;
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<Notification> list) {
        this.notifications = list;
    }
}
