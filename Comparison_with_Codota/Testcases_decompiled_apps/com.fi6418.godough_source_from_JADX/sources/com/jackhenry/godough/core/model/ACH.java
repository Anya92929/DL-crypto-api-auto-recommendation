package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;
import java.util.List;

public class ACH implements GoDoughType {
    private String code;
    private String companyName;
    private List<Calendar> effectiveDates;

    /* renamed from: id */
    private String f6500id;
    private boolean isOffsetAllowed;
    private String name;
    private List<OffsetAccount> offsetAccounts;
    private String preInitMessage;
    private boolean preInitSuccess = true;
    private ACHStatus status;
    private long totalCredits;
    private long totalDebits;

    public ACH() {
    }

    public ACH(String str, String str2, String str3, String str4, long j, long j2, boolean z, boolean z2, String str5, List<OffsetAccount> list, List<Calendar> list2) {
        this.f6500id = str;
        this.name = str2;
        this.code = str3;
        this.companyName = str4;
        this.totalDebits = j;
        this.totalCredits = j2;
        this.isOffsetAllowed = z;
        this.preInitSuccess = z2;
        this.preInitMessage = str5;
        this.offsetAccounts = list;
        this.effectiveDates = list2;
    }

    public String getCode() {
        return this.code;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public List<Calendar> getEffectiveDates() {
        return this.effectiveDates;
    }

    public String getId() {
        return this.f6500id;
    }

    public String getName() {
        return this.name;
    }

    public List<OffsetAccount> getOffsetAccounts() {
        return this.offsetAccounts;
    }

    public String getPreInitMessage() {
        return this.preInitMessage;
    }

    public ACHStatus getStatus() {
        return this.status;
    }

    public long getTotalCredits() {
        return this.totalCredits;
    }

    public String getTotalCreditsFormatted() {
        return C1580i.m6152a(this.totalCredits);
    }

    public long getTotalDebits() {
        return this.totalDebits;
    }

    public String getTotalDebitsFormatted() {
        return C1580i.m6152a(-this.totalDebits);
    }

    public boolean isOffsetAllowed() {
        return this.isOffsetAllowed;
    }

    public boolean isPreInitSuccess() {
        return this.preInitSuccess;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public void setEffectiveDates(List<Calendar> list) {
        this.effectiveDates = list;
    }

    public void setId(String str) {
        this.f6500id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOffsetAccounts(List<OffsetAccount> list) {
        this.offsetAccounts = list;
    }

    public void setOffsetAllowed(boolean z) {
        this.isOffsetAllowed = z;
    }

    public void setPreInitMessage(String str) {
        this.preInitMessage = str;
    }

    public void setPreInitSuccess(boolean z) {
        this.preInitSuccess = z;
    }

    public void setStatus(ACHStatus aCHStatus) {
        this.status = aCHStatus;
    }

    public void setTotalCredits(long j) {
        this.totalCredits = j;
    }

    public void setTotalDebits(long j) {
        this.totalDebits = j;
    }
}
