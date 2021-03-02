package com.jackhenry.godough.core.model;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

public class CredentialsChangeSettings implements GoDoughType, MobilAPIDataValidation {
    private static final String NONE_ERROR = "none";
    public static final int PASSWORD = 1;
    private static final String PASSWORD_CHANGE_OPTIONAL = "passwordoptional";
    private static final String PASSWORD_CHANGE_REQUIRED = "passwordrequired";
    public static final int PASSWORD_REQUIRED = 8;
    public static final int USERNAME = 2;
    private static final String USERNAME_CHANGE_OPTIONAL = "usernameoptional";
    private static final String USERNAME_CHANGE_REQUIRED = "usernamerequired";
    public static final int USERNAME_REQUIRED = 4;
    private static final long serialVersionUID = 1;
    private String changeMessage;
    private String changeStatus;
    private int currentStatus;
    private String currentUserName;
    private int passwordMaximumLength = 0;
    private int passwordMinimumLength = 0;
    private String rulesMessage;
    private int userNameMaximumLength = 0;
    private int userNameMinimumLength = 0;

    public enum ViewTag {
        NEW_USERNAME_VIEW_TAG,
        NEW_PASSWORD_VIEW_TAG,
        REENTER_PASSWORD_VIEW_TAG,
        CURRENT_PASSWORD_VIEW_TAG
    }

    private boolean allPasswordsEmpty(PasswordResetData passwordResetData) {
        return !TextUtils.isEmpty(passwordResetData.getCurrentPassword()) && !TextUtils.isEmpty(passwordResetData.getNewPassword()) && !TextUtils.isEmpty(passwordResetData.getNewPasswordRepeated());
    }

    private String getChangeStatus() {
        return this.changeStatus == null ? PASSWORD_CHANGE_OPTIONAL : this.changeStatus.toLowerCase();
    }

    private boolean isValidPassword(String str) {
        return str != null && str.length() >= getPasswordMinimumLength() && str.length() <= getPasswordMaximumLength();
    }

    private boolean isValidUsername(String str) {
        return str != null && str.length() >= getUserNameMinimumLength() && str.length() <= getUserNameMaximumLength();
    }

    public boolean areFieldsValid(PasswordResetData passwordResetData) {
        boolean z = true;
        boolean z2 = statusContains(1) ? (!allPasswordsEmpty(passwordResetData) || statusContains(8)) ? isValidPassword(passwordResetData.getNewPassword()) && isValidPassword(passwordResetData.getNewPasswordRepeated()) && passwordResetData.doPasswordsMatch() && !TextUtils.isEmpty(passwordResetData.getCurrentPassword()) : true : true;
        if (statusContains(2)) {
            if (!statusContains(1) && TextUtils.isEmpty(passwordResetData.getNewUserName())) {
                return false;
            }
            if ((statusContains(4) || !TextUtils.isEmpty(passwordResetData.getNewUserName())) && !isValidUsername(passwordResetData.getNewUserName())) {
                z = false;
            }
        }
        return z & z2;
    }

    public String getChangeMessage() {
        return this.changeMessage;
    }

    public String getCurrentUserName() {
        return this.currentUserName;
    }

    public int getPasswordMaximumLength() {
        return this.passwordMaximumLength;
    }

    public int getPasswordMinimumLength() {
        return this.passwordMinimumLength;
    }

    public String getRulesMessage() {
        return this.rulesMessage;
    }

    public int getUserNameMaximumLength() {
        return this.userNameMaximumLength;
    }

    public int getUserNameMinimumLength() {
        return this.userNameMinimumLength;
    }

    public boolean isValid() {
        return true;
    }

    public void setChangeMessage(String str) {
        this.changeMessage = str;
    }

    public void setChangeStatus(String str) {
        this.changeStatus = str;
    }

    public void setCurrentUserName(String str) {
        this.currentUserName = str;
    }

    public void setPasswordMaximumLength(int i) {
        this.passwordMaximumLength = i;
    }

    public void setPasswordMinimumLength(int i) {
        this.passwordMinimumLength = i;
    }

    public void setRulesMessage(String str) {
        this.rulesMessage = str;
    }

    public void setUserNameMaximumLength(int i) {
        this.userNameMaximumLength = i;
    }

    public void setUserNameMinimumLength(int i) {
        this.userNameMinimumLength = i;
    }

    public boolean statusContains(int i) {
        String changeStatus2 = getChangeStatus();
        char c = 65535;
        switch (changeStatus2.hashCode()) {
            case -337150347:
                if (changeStatus2.equals(USERNAME_CHANGE_REQUIRED)) {
                    c = 1;
                    break;
                }
                break;
            case -23028170:
                if (changeStatus2.equals(USERNAME_CHANGE_OPTIONAL)) {
                    c = 2;
                    break;
                }
                break;
            case 3387192:
                if (changeStatus2.equals(NONE_ERROR)) {
                    c = 3;
                    break;
                }
                break;
            case 372251450:
                if (changeStatus2.equals(PASSWORD_CHANGE_REQUIRED)) {
                    c = 0;
                    break;
                }
                break;
            case 686373627:
                if (changeStatus2.equals(PASSWORD_CHANGE_OPTIONAL)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.currentStatus = 9;
                break;
            case 1:
                this.currentStatus = 6;
                break;
            case 2:
                this.currentStatus = 2;
                break;
            default:
                this.currentStatus = 1;
                break;
        }
        return (this.currentStatus & i) == i;
    }

    public String validateInput(PasswordResetData passwordResetData, EditText editText) {
        Resources resources = GoDoughApp.getApp().getResources();
        passwordResetData.getNewPassword();
        String str = null;
        ViewTag viewTag = (ViewTag) editText.getTag();
        if (!TextUtils.isEmpty(editText.getText())) {
            switch (viewTag) {
                case NEW_USERNAME_VIEW_TAG:
                    if (!isValidUsername(passwordResetData.getNewUserName()) && editText.getText().toString().length() > 0) {
                        str = resources.getString(C1506am.username_max_min_error_message, new Object[]{Integer.valueOf(getUserNameMinimumLength()), Integer.valueOf(getUserNameMaximumLength())});
                        break;
                    }
                case CURRENT_PASSWORD_VIEW_TAG:
                    str = resources.getString(C1506am.current_password_missing);
                    break;
                case REENTER_PASSWORD_VIEW_TAG:
                    if (!passwordResetData.doPasswordsMatch()) {
                        str = resources.getString(C1506am.password_must_match_message);
                        break;
                    }
                    break;
                case NEW_PASSWORD_VIEW_TAG:
                    break;
            }
            if (!isValidPassword(editText.getText().toString())) {
                str = resources.getString(C1506am.password_max_min_error_message, new Object[]{Integer.valueOf(getPasswordMinimumLength()), Integer.valueOf(getPasswordMaximumLength())}) + (str != null ? " " + str : "");
            }
        }
        if (viewTag != ViewTag.CURRENT_PASSWORD_VIEW_TAG) {
            editText.setError(str);
        }
        return str;
    }
}
