package com.jackhenry.godough.core.model;

import java.util.List;

public class P2PPayeesResponse {
    private List<P2PPayee> p2PPayees;

    public List<P2PPayee> getP2PPayees() {
        return this.p2PPayees;
    }

    public void setP2PPayees(List<P2PPayee> list) {
        this.p2PPayees = list;
    }
}
