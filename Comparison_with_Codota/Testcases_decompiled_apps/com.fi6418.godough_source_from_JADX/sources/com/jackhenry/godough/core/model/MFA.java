package com.jackhenry.godough.core.model;

import java.util.List;

public class MFA implements GoDoughType, Cloneable {
    private boolean collectPhone;
    private List<MFAQuestion> collectQuestions;
    private boolean isChallenged;
    private boolean isCollect;
    private MFAQuestion questionOne;
    private MFAQuestion questionTwo;
    private String requestToken;
    private String riskTransactionId;

    public MFA clone() {
        return (MFA) super.clone();
    }

    public List<MFAQuestion> getCollectQuestions() {
        return this.collectQuestions;
    }

    public MFAQuestion getQuestionOne() {
        return this.questionOne;
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

    public boolean isChallenged() {
        return this.isChallenged;
    }

    public boolean isCollect() {
        return this.isCollect;
    }

    public boolean isCollectPhone() {
        return this.collectPhone;
    }

    public void setChallenged(boolean z) {
        this.isChallenged = z;
    }

    public void setCollect(boolean z) {
        this.isCollect = z;
    }

    public void setCollectPhone(boolean z) {
        this.collectPhone = z;
    }

    public void setCollectQuestions(List<MFAQuestion> list) {
        this.collectQuestions = list;
    }

    public void setQuestionOne(MFAQuestion mFAQuestion) {
        this.questionOne = mFAQuestion;
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
