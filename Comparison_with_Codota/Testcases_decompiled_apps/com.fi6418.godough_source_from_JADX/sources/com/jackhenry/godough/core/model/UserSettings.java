package com.jackhenry.godough.core.model;

public class UserSettings implements GoDoughType {
    private String P2PDeliveryDateLabelText;
    private String P2PUserDateLabelText;
    private int alertCount;
    private String billPayDeliveryDateLabelText;
    private String billPayUserDateLabelText;
    private boolean hasDualControlWires;
    private boolean isBillPayEstimatedArrivalCalendarEnabled;
    private boolean isP2PEstimatedArrivalCalendarEnabled;
    private String offlineMessage;
    private RDAVerificationStatusResponse rdaVerificationStatusResponse;
    private UserMenu userMenu;

    public int getAlertCount() {
        return this.alertCount;
    }

    public String getBillPayDeliveryDateLabelText() {
        return this.billPayDeliveryDateLabelText;
    }

    public String getBillPayUserDateLabelText() {
        return this.billPayUserDateLabelText;
    }

    public boolean getIsBillPayEstimatedArrivalCalendarEnabled() {
        return this.isBillPayEstimatedArrivalCalendarEnabled;
    }

    public String getOfflineMessage() {
        return this.offlineMessage;
    }

    public String getP2PDeliveryDateLabelText() {
        return this.P2PDeliveryDateLabelText;
    }

    public String getP2PUserDateLabelText() {
        return this.P2PUserDateLabelText;
    }

    public RDAVerificationStatusResponse getRdaVerificationStatusResponse() {
        return this.rdaVerificationStatusResponse;
    }

    public UserMenu getUserMenu() {
        return this.userMenu;
    }

    public boolean isHasDualControlWires() {
        return this.hasDualControlWires;
    }

    public boolean isP2PEstimatedArrivalCalendarEnabled() {
        return this.isP2PEstimatedArrivalCalendarEnabled;
    }

    public void setAlertCount(int i) {
        this.alertCount = i;
    }

    public void setBillPayDeliveryDateLabelText(String str) {
        this.billPayDeliveryDateLabelText = str;
    }

    public void setBillPayEstimatedArrivalCalendarEnabled(boolean z) {
        this.isBillPayEstimatedArrivalCalendarEnabled = z;
    }

    public void setBillPayUserDateLabelText(String str) {
        this.billPayUserDateLabelText = str;
    }

    public void setIsHasDualControlWires(boolean z) {
        this.hasDualControlWires = z;
    }

    public void setOfflineMessage(String str) {
        this.offlineMessage = str;
    }

    public void setP2PDeliveryDateLabelText(String str) {
        this.P2PDeliveryDateLabelText = str;
    }

    public void setP2PEstimatedArrivalCalendarEnabled(boolean z) {
        this.isP2PEstimatedArrivalCalendarEnabled = z;
    }

    public void setP2PUserDateLabelText(String str) {
        this.P2PUserDateLabelText = str;
    }

    public void setRdaVerificationStatusResponse(RDAVerificationStatusResponse rDAVerificationStatusResponse) {
        this.rdaVerificationStatusResponse = rDAVerificationStatusResponse;
    }

    public void setUserMenu(UserMenu userMenu2) {
        this.userMenu = userMenu2;
    }
}
