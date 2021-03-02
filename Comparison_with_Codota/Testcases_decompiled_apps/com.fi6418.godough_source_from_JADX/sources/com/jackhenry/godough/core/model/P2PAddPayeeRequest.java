package com.jackhenry.godough.core.model;

public class P2PAddPayeeRequest implements GoDoughType {
    private String email;
    private String keyword;
    private String name;
    private String nickname;
    private String requestToken;

    public P2PAddPayeeRequest() {
    }

    public P2PAddPayeeRequest(P2PPayee p2PPayee) {
        setName(p2PPayee.getName());
        setNickname(p2PPayee.getNickname());
        setKeyword(p2PPayee.getKeyword());
        setEmail(p2PPayee.getEmail());
    }

    public String getEmail() {
        return this.email;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
