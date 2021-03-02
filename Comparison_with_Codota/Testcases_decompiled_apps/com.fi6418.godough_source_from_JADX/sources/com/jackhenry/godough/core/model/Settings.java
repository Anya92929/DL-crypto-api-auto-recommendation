package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class Settings implements GoDoughType {
    private String actionItemColor;
    private Calendar androidLastLogoUpdate;
    private boolean locationsEnabled;
    private String locationsMenuName;
    private String loginMenuName;
    private String mainColor;
    private Texture mobileBackgroundTextureImageId;
    private NotificationList notifications;
    private String passwordLabel;
    private boolean rememberMeEnabled;
    private String shortPasswordLabel;
    private boolean showDashboardButtonBorder;
    private String userNameLabel;

    public enum LogoType {
        AndroidLaunchPageImageID,
        AndroidLandscapeImageID
    }

    public enum Texture {
        TRANSPARENT,
        GRID_DARK,
        METAL,
        SMOOTH
    }

    public Settings() {
    }

    public Settings(String str, String str2, boolean z, String str3, String str4, String str5, String str6, Texture texture, boolean z2, Calendar calendar, boolean z3) {
        this.userNameLabel = str;
        this.passwordLabel = str2;
        this.locationsEnabled = z;
        this.locationsMenuName = str3;
        this.loginMenuName = str4;
        this.mainColor = str5;
        this.actionItemColor = str6;
        this.mobileBackgroundTextureImageId = texture;
        this.showDashboardButtonBorder = z2;
        this.androidLastLogoUpdate = calendar;
    }

    public String getActionItemColor() {
        return this.actionItemColor;
    }

    public Calendar getAndroidLastLogoUpdate() {
        return this.androidLastLogoUpdate;
    }

    public String getAndroidLastLogoUpdateFormatted() {
        return C1580i.m6155b(this.androidLastLogoUpdate);
    }

    public String getLocationsMenuName() {
        return this.locationsMenuName;
    }

    public String getLoginMenuName() {
        return this.loginMenuName;
    }

    public String getMainColor() {
        return this.mainColor;
    }

    public Texture getMobileBackgroundTextureImageId() {
        return this.mobileBackgroundTextureImageId;
    }

    public NotificationList getNotifications() {
        return this.notifications;
    }

    public String getPasswordLabel() {
        return this.passwordLabel;
    }

    public String getShortPasswordLabel() {
        return this.shortPasswordLabel;
    }

    public String getUserNameLabel() {
        return this.userNameLabel;
    }

    public boolean isLocationsEnabled() {
        return this.locationsEnabled;
    }

    public boolean isRememberMeEnabled() {
        return this.rememberMeEnabled;
    }

    public boolean isShowDashboardButtonBorder() {
        return this.showDashboardButtonBorder;
    }

    public void setActionItemColor(String str) {
        this.actionItemColor = str;
    }

    public void setAndroidLastLogoUpdate(Calendar calendar) {
        this.androidLastLogoUpdate = calendar;
    }

    public void setLocationsEnabled(boolean z) {
        this.locationsEnabled = z;
    }

    public void setLocationsMenuName(String str) {
        this.locationsMenuName = str;
    }

    public void setLoginMenuName(String str) {
        this.loginMenuName = str;
    }

    public void setMainColor(String str) {
        this.mainColor = str;
    }

    public void setMobileBackgroundTextureImageId(Texture texture) {
        this.mobileBackgroundTextureImageId = texture;
    }

    public void setNotifications(NotificationList notificationList) {
        this.notifications = notificationList;
    }

    public void setPasswordLabel(String str) {
        this.passwordLabel = str;
    }

    public void setRememberMeEnabled(boolean z) {
        this.rememberMeEnabled = z;
    }

    public void setShortPasswordLabel(String str) {
        this.shortPasswordLabel = str;
    }

    public void setShowDashboardButtonBorder(boolean z) {
        this.showDashboardButtonBorder = z;
    }

    public void setUserNameLabel(String str) {
        this.userNameLabel = str;
    }
}
