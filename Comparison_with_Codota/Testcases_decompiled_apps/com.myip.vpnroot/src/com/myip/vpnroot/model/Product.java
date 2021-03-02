package com.myip.vpnroot.model;

import com.myip.vpnroot.C2344R;

public class Product {
    String hostname;

    /* renamed from: id */
    int f4693id = 0;
    int imageRes = C2344R.C2345drawable.ic_launcher;
    String ipv4;
    String ipv6;
    String name = "sample name";
    String sku;
    String status;

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku2) {
        this.sku = sku2;
    }

    public int getId() {
        return this.f4693id;
    }

    public void setId(int id) {
        this.f4693id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname2) {
        this.hostname = hostname2;
    }

    public String getIpv4() {
        return this.ipv4;
    }

    public void setIpv4(String ipv42) {
        this.ipv4 = ipv42;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getIpv6() {
        return this.ipv6;
    }

    public void setIpv6(String ipv62) {
        this.ipv6 = ipv62;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public void setImageRes(int imageRes2) {
        this.imageRes = imageRes2;
    }
}
