package com.jackhenry.godough.core.model;

import java.util.List;

public class TransferToAccount implements GoDoughType {
    private Account account;
    private String offlineMessage;
    private String offlineWarning;
    private List<TransferOption> transferOptions;

    public TransferToAccount() {
    }

    public TransferToAccount(Account account2, List<TransferOption> list) {
        this.account = account2;
        this.transferOptions = list;
    }

    public Account getAccount() {
        return this.account;
    }

    public String getOfflineMessage() {
        return this.offlineMessage;
    }

    public String getOfflineWarning() {
        return this.offlineWarning;
    }

    public List<TransferOption> getTransferOptions() {
        return this.transferOptions;
    }

    public boolean hasTransferOptions() {
        return this.transferOptions != null && !this.transferOptions.isEmpty();
    }

    public void setAccount(Account account2) {
        this.account = account2;
    }

    public void setOfflineMessage(String str) {
        this.offlineMessage = str;
    }

    public void setOfflineWarning(String str) {
        this.offlineWarning = str;
    }

    public void setTransferOptions(List<TransferOption> list) {
        this.transferOptions = list;
    }

    public String toString() {
        return this.account.getName();
    }
}
