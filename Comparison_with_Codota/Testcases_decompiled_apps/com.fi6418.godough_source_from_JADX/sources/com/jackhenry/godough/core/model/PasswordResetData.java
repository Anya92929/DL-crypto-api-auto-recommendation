package com.jackhenry.godough.core.model;

public class PasswordResetData implements GoDoughType {
    private static final long serialVersionUID = 1;
    private String currentPassword = "";
    private String newPassword = "";
    private String newPasswordRepeated = "";
    private String newUserName = "";
    private String requestToken;

    public boolean doPasswordsMatch() {
        if (getNewPassword() != null && getNewPasswordRepeated() != null) {
            return getNewPassword().equals(getNewPasswordRepeated());
        }
        if (getNewPassword() != null || getNewPasswordRepeated() == null) {
            return getNewPassword() == null || getNewPasswordRepeated() != null;
        }
        return false;
    }

    public String getCurrentPassword() {
        return this.currentPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public String getNewPasswordRepeated() {
        return this.newPasswordRepeated;
    }

    public String getNewUserName() {
        return this.newUserName;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setCurrentPassword(String str) {
        this.currentPassword = str;
    }

    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    public void setNewPasswordRepeated(String str) {
        this.newPasswordRepeated = str;
    }

    public void setNewUserName(String str) {
        this.newUserName = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
