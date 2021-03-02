package com.jackhenry.godough.core.model;

import java.util.List;

public class WiresList implements GoDoughType {
    private List<Wire> wires;

    public WiresList() {
    }

    public WiresList(List<Wire> list) {
        this.wires = list;
    }

    public List<Wire> getWires() {
        return this.wires;
    }

    public void setWires(List<Wire> list) {
        this.wires = list;
    }
}
