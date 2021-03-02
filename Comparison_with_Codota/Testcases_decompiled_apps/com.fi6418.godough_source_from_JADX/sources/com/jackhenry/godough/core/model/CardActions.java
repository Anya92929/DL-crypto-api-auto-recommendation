package com.jackhenry.godough.core.model;

public class CardActions {
    private boolean canActivate;
    private boolean canReorder;
    private boolean canReportLostStolen;
    private boolean canSuspend;

    public enum Action {
        ACTIVATE,
        REORDER,
        REPORT,
        SUSPEND;

        public String toString() {
            String name = name();
            return name.substring(0, 1) + name.substring(1).toLowerCase();
        }
    }

    public boolean isCanActivate() {
        return this.canActivate;
    }

    public boolean isCanReorder() {
        return this.canReorder;
    }

    public boolean isCanReportLostStolen() {
        return this.canReportLostStolen;
    }

    public boolean isCanSuspend() {
        return this.canSuspend;
    }

    public void setCanActivate(boolean z) {
        this.canActivate = z;
    }

    public void setCanReorder(boolean z) {
        this.canReorder = z;
    }

    public void setCanReportLostStolen(boolean z) {
        this.canReportLostStolen = z;
    }

    public void setCanSuspend(boolean z) {
        this.canSuspend = z;
    }
}
