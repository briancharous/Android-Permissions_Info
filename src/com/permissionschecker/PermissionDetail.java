package com.permissionschecker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.util.Log;

import java.util.ArrayList;

public class PermissionDetail {

    public ArrayList<App> matchingApps;
    private PermissionInfo permissionInfo;
    public String permissionName;

    public PermissionDetail(String _permissionName, Context c) {
        permissionName = _permissionName;
        matchingApps = new ArrayList<App>();

        PermissionInfo pi = null;
        try {
            pi = c.getPackageManager().getPermissionInfo(permissionName, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            //Log.i("debug", "permission not found: " + e.getLocalizedMessage());
        }

        this.permissionInfo = pi;
    }

    public PermissionDetail() {
        permissionInfo = null;
        matchingApps = new ArrayList<App>();
    }

    public boolean addApp(App a) {
        return matchingApps.add(a);
    }
}
