package com.jackhenry.godough.core.model;

import android.annotation.SuppressLint;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class Credentials implements GoDoughType {
    private static final String FORMAT_DATE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String FORMAT_DATE_HS = "MMddyyyyHHmmss";
    private String dateTime;
    transient String gcmRegId;
    private String handshake;
    private String password;
    private boolean rememberMe;
    private String salt;
    private String userName;

    public Credentials() {
    }

    @SuppressLint({"SimpleDateFormat"})
    public Credentials(String str, String str2, int i, String str3, boolean z) {
        this.userName = str;
        this.password = str2;
        this.salt = UUID.randomUUID().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date time = Calendar.getInstance().getTime();
        this.dateTime = simpleDateFormat.format(time);
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(FORMAT_DATE_HS);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
            String str4 = i + simpleDateFormat2.format(time) + this.salt + str3;
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.reset();
            this.handshake = bin2hex(instance.digest(str4.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.rememberMe = z;
    }

    private static String bin2hex(byte[] bArr) {
        String bigInteger = new BigInteger(1, bArr).toString(16);
        while (bigInteger.length() < 64) {
            bigInteger = "0" + bigInteger;
        }
        return bigInteger;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getHandshake() {
        return this.handshake;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSalt() {
        return this.salt;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getgcmRegId() {
        return this.gcmRegId;
    }

    public boolean isRememberMe() {
        return this.rememberMe;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setGcmRegId(String str) {
        this.gcmRegId = str;
    }

    public void setHandshake(String str) {
        this.handshake = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setRememberMe(boolean z) {
        this.rememberMe = z;
    }

    public void setSalt(String str) {
        this.salt = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
