package com.jackhenry.godough.core.model;

import com.google.p008a.p009a.C0347a;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.GoDoughApp;

public class GodoughMenuItem implements GoDoughType {
    private int index;
    private boolean isEnabled;
    @C0347a(mo6290a = false, mo6291b = false)
    private String overlayText;
    private String text;
    @C0347a(mo6290a = false, mo6291b = false)
    private Type type;

    public enum Type {
        ACCOUNTS,
        ALERTS,
        ACH,
        BILLPAY,
        LOCATIONS,
        MAINTENANCE,
        RDA,
        TRANSFERS,
        WIRES,
        P2P,
        SETTINGS,
        ABOUT,
        STATEMENTS,
        PREFERENCES
    }

    public GodoughMenuItem() {
    }

    public GodoughMenuItem(boolean z, String str, int i) {
        this.isEnabled = z;
        this.text = str;
        this.index = i;
    }

    public static String getMenuLabel(Type type2) {
        String text2 = GoDoughApp.getUserSettings().getUserMenu().getAccounts().getText();
        switch (type2) {
            case ACCOUNTS:
                return GoDoughApp.getUserSettings().getUserMenu().getAccounts().getText();
            case ACH:
                return GoDoughApp.getUserSettings().getUserMenu().getAch().getText();
            case ALERTS:
                return GoDoughApp.getUserSettings().getUserMenu().getAlerts().getText();
            case BILLPAY:
                return GoDoughApp.getUserSettings().getUserMenu().getBillPay().getText();
            case LOCATIONS:
                return GoDoughApp.getUserSettings().getUserMenu().getLocations().getText();
            case MAINTENANCE:
                return GoDoughApp.getUserSettings().getUserMenu().getManageCards().getText();
            case RDA:
                return GoDoughApp.getUserSettings().getUserMenu().getRda().getText();
            case TRANSFERS:
                return GoDoughApp.getUserSettings().getUserMenu().getTransfers().getText();
            case WIRES:
                return GoDoughApp.getUserSettings().getUserMenu().getWires().getText();
            case P2P:
                return GoDoughApp.getUserSettings().getUserMenu().getP2P().getText();
            case ABOUT:
                return GoDoughApp.getUserSettings().getUserMenu().getAbout().getText();
            case STATEMENTS:
                return GoDoughApp.getUserSettings().getUserMenu().getStatements().getText();
            case PREFERENCES:
                return GoDoughApp.getUserSettings().getUserMenu().getPreferences().getText();
            default:
                return text2;
        }
    }

    public int getImageID() {
        switch (getType()) {
            case ACCOUNTS:
                return C1493ah.ic_accounts;
            case ACH:
                return C1493ah.ic_ach;
            case ALERTS:
                return C1493ah.ic_alerts;
            case BILLPAY:
                return C1493ah.ic_billpay;
            case LOCATIONS:
                return C1493ah.ic_target;
            case MAINTENANCE:
                return C1493ah.ic_cards;
            case RDA:
                return C1493ah.ic_rda;
            case TRANSFERS:
                return C1493ah.ic_transfers;
            case WIRES:
                return C1493ah.ic_wires;
            case P2P:
                return C1493ah.ic_p2p;
            case ABOUT:
                return C1493ah.ic_about;
            case STATEMENTS:
                return C1493ah.menu_statements;
            case PREFERENCES:
                return C1493ah.cog_wheel;
            default:
                return C1493ah.ic_about;
        }
    }

    public int getIndex() {
        return this.index;
    }

    public String getOverlayText() {
        return this.overlayText;
    }

    public String getText() {
        return this.text;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setOverlayText(String str) {
        this.overlayText = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(Type type2) {
        this.type = type2;
    }
}
