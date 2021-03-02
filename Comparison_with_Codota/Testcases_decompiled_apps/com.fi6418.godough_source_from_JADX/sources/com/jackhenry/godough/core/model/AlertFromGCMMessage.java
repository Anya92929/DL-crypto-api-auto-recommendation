package com.jackhenry.godough.core.model;

public class AlertFromGCMMessage implements GoDoughType {
    private String alert;
    private int badge;
    private String sound;

    public String getAlert() {
        return this.alert;
    }

    public int getBadge() {
        return this.badge;
    }

    public String getSound() {
        return this.sound;
    }

    public void setAlert(String str) {
        this.alert = str;
    }

    public void setBadge(int i) {
        this.badge = i;
    }

    public void setSound(String str) {
        this.sound = str;
    }
}
