package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.prefmenu.model.PreferencesMenu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserMenu implements GoDoughType {
    private GodoughMenuItem about;
    private GodoughMenuItem accounts;
    private GodoughMenuItem ach;
    private GodoughMenuItem alerts;
    private GodoughMenuItem billPay;
    private GodoughMenuItem locations;
    private GodoughMenuItem manageCards;
    private GodoughMenuItem p2P;
    private PreferencesMenu preferences;
    private GodoughMenuItem rda;
    private GodoughMenuItem statements;
    private GodoughMenuItem transfers;
    private GodoughMenuItem wires;

    private static void addItem(GodoughMenuItem godoughMenuItem, List<GodoughMenuItem> list, GodoughMenuItem.Type type) {
        if (godoughMenuItem != null && godoughMenuItem.isEnabled()) {
            godoughMenuItem.setType(type);
            list.add(godoughMenuItem);
        }
    }

    public GodoughMenuItem getAbout() {
        return this.about;
    }

    public GodoughMenuItem getAccounts() {
        return this.accounts;
    }

    public GodoughMenuItem getAch() {
        return this.ach;
    }

    public GodoughMenuItem getAlerts() {
        return this.alerts;
    }

    public GodoughMenuItem getBillPay() {
        return this.billPay;
    }

    public GodoughMenuItem getLocations() {
        return this.locations;
    }

    public GodoughMenuItem getManageCards() {
        return this.manageCards;
    }

    public List<GodoughMenuItem> getMenuItems() {
        ArrayList arrayList = new ArrayList();
        addItem(this.accounts, arrayList, GodoughMenuItem.Type.ACCOUNTS);
        addItem(this.alerts, arrayList, GodoughMenuItem.Type.ALERTS);
        addItem(this.ach, arrayList, GodoughMenuItem.Type.ACH);
        addItem(this.billPay, arrayList, GodoughMenuItem.Type.BILLPAY);
        addItem(this.locations, arrayList, GodoughMenuItem.Type.LOCATIONS);
        addItem(this.manageCards, arrayList, GodoughMenuItem.Type.MAINTENANCE);
        addItem(this.rda, arrayList, GodoughMenuItem.Type.RDA);
        addItem(this.transfers, arrayList, GodoughMenuItem.Type.TRANSFERS);
        addItem(this.wires, arrayList, GodoughMenuItem.Type.WIRES);
        addItem(this.p2P, arrayList, GodoughMenuItem.Type.P2P);
        addItem(this.about, arrayList, GodoughMenuItem.Type.ABOUT);
        addItem(this.statements, arrayList, GodoughMenuItem.Type.STATEMENTS);
        addItem(this.preferences, arrayList, GodoughMenuItem.Type.PREFERENCES);
        Collections.sort(arrayList, new Comparator<GodoughMenuItem>() {
            public int compare(GodoughMenuItem godoughMenuItem, GodoughMenuItem godoughMenuItem2) {
                return Integer.valueOf(godoughMenuItem.getIndex()).compareTo(Integer.valueOf(godoughMenuItem2.getIndex()));
            }
        });
        return arrayList;
    }

    public GodoughMenuItem getP2P() {
        return this.p2P;
    }

    public PreferencesMenu getPreferences() {
        return this.preferences;
    }

    public GodoughMenuItem getRda() {
        return this.rda;
    }

    public GodoughMenuItem getStatements() {
        return this.statements;
    }

    public GodoughMenuItem getTransfers() {
        return this.transfers;
    }

    public GodoughMenuItem getWires() {
        return this.wires;
    }

    public boolean isMenuActive(GodoughMenuItem.Type type) {
        for (GodoughMenuItem next : getMenuItems()) {
            if (next.getType() == type && next.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public void setAbout(GodoughMenuItem godoughMenuItem) {
        this.about = godoughMenuItem;
    }

    public void setAccounts(GodoughMenuItem godoughMenuItem) {
        this.accounts = godoughMenuItem;
    }

    public void setAch(GodoughMenuItem godoughMenuItem) {
        this.ach = godoughMenuItem;
    }

    public void setAlerts(GodoughMenuItem godoughMenuItem) {
        this.alerts = godoughMenuItem;
    }

    public void setBillPay(GodoughMenuItem godoughMenuItem) {
        this.billPay = godoughMenuItem;
    }

    public void setLocations(GodoughMenuItem godoughMenuItem) {
        this.locations = godoughMenuItem;
    }

    public void setManageCards(GodoughMenuItem godoughMenuItem) {
        this.manageCards = godoughMenuItem;
    }

    public void setP2P(GodoughMenuItem godoughMenuItem) {
        this.p2P = godoughMenuItem;
    }

    public void setPreferences(PreferencesMenu preferencesMenu) {
        this.preferences = preferencesMenu;
    }

    public void setRda(GodoughMenuItem godoughMenuItem) {
        this.rda = godoughMenuItem;
    }

    public void setStatements(GodoughMenuItem godoughMenuItem) {
        this.statements = godoughMenuItem;
    }

    public void setTransfers(GodoughMenuItem godoughMenuItem) {
        this.transfers = godoughMenuItem;
    }

    public void setWires(GodoughMenuItem godoughMenuItem) {
        this.wires = godoughMenuItem;
    }

    public void updateAlertCount(int i) {
        if (this.alerts == null) {
            return;
        }
        if (i == 0) {
            this.alerts.setOverlayText((String) null);
        } else {
            this.alerts.setOverlayText(String.valueOf(i));
        }
    }
}
