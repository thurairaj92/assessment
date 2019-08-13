package com.thurairaj.moneylion.model.permission;

public class PermissionEnabledResponse {
    boolean canAccess;

    public PermissionEnabledResponse(Permission permission) {
        this.canAccess = permission != null && permission.isEnable();
    }

    public boolean isCanAccess() {
        return canAccess;
    }

    public void setCanAccess(boolean canAccess) {
        this.canAccess = canAccess;
    }
}
