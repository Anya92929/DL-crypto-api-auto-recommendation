package com.jackhenry.godough.core.model;

public class Notification implements GoDoughType {
    public static final String NOTIFICATION_TYPE_HARD = "UPGRADEREQUIRED";
    public static final String NOTIFICATION_TYPE_SOFT = "UPGRADEOPTIONAL";
    private String message;
    private String notificationType;
    private String upgradePackageName;

    public Notification() {
    }

    public Notification(String str, String str2, String str3) {
        this.notificationType = str;
        this.message = str2;
        this.upgradePackageName = str3;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNotificationType() {
        return this.notificationType;
    }

    public String getUpgradePackageName() {
        return this.upgradePackageName;
    }

    public boolean isMandatoryUpdate() {
        return NOTIFICATION_TYPE_HARD.equals(this.notificationType.toUpperCase());
    }

    public boolean isValid() {
        if (this.notificationType == null || this.message == null || this.upgradePackageName == null) {
            return false;
        }
        return (NOTIFICATION_TYPE_HARD.equals(this.notificationType.toUpperCase()) || NOTIFICATION_TYPE_SOFT.equals(this.notificationType.toUpperCase())) && !this.message.isEmpty() && !this.upgradePackageName.isEmpty();
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNotificationType(String str) {
        this.notificationType = str;
    }

    public void setUpgradePackageName(String str) {
        this.upgradePackageName = str;
    }
}
