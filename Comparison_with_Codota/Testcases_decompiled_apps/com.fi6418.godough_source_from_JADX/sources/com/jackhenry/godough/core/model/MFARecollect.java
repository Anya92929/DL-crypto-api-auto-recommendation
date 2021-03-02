package com.jackhenry.godough.core.model;

public class MFARecollect implements GoDoughType, Cloneable {
    private static final long serialVersionUID = 1;
    private MFAPhone phoneFour;
    private MFAPhone phoneOne;
    private MFAPhone phoneThree;
    private MFAPhone phoneTwo;
    private MFAQuestion questionOne;
    private MFAQuestion questionThree;
    private MFAQuestion questionTwo;
    private String requestToken;
    private String riskTransactionId;

    public MFARecollect() {
    }

    public MFARecollect(MFA mfa) {
        setRiskTransactionId(mfa.getRiskTransactionId());
    }

    public MFAPhone getPhoneFour() {
        return this.phoneFour;
    }

    public MFAPhone getPhoneOne() {
        return this.phoneOne;
    }

    public MFAPhone getPhoneThree() {
        return this.phoneThree;
    }

    public MFAPhone getPhoneTwo() {
        return this.phoneTwo;
    }

    public MFAQuestion getQuestionOne() {
        return this.questionOne;
    }

    public MFAQuestion getQuestionThree() {
        return this.questionThree;
    }

    public MFAQuestion getQuestionTwo() {
        return this.questionTwo;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public String getRiskTransactionId() {
        return this.riskTransactionId;
    }

    public void setPhoneFour(MFAPhone mFAPhone) {
        this.phoneFour = mFAPhone;
    }

    public void setPhoneOne(MFAPhone mFAPhone) {
        this.phoneOne = mFAPhone;
    }

    public void setPhoneThree(MFAPhone mFAPhone) {
        this.phoneThree = mFAPhone;
    }

    public void setPhoneTwo(MFAPhone mFAPhone) {
        this.phoneTwo = mFAPhone;
    }

    public void setQuestionOne(MFAQuestion mFAQuestion) {
        this.questionOne = mFAQuestion;
    }

    public void setQuestionThree(MFAQuestion mFAQuestion) {
        this.questionThree = mFAQuestion;
    }

    public void setQuestionTwo(MFAQuestion mFAQuestion) {
        this.questionTwo = mFAQuestion;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }

    public void setRiskTransactionId(String str) {
        this.riskTransactionId = str;
    }
}
