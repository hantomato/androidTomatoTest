package com.nmj.androidtomatotest.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * Created by nmj on 15. 7. 4..
 */
public class Utils {

    public static boolean checkAppInstalled(Context ctx, String packageName) {
        PackageManager pm = ctx.getPackageManager();
        boolean appInstalled;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            appInstalled = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            appInstalled = false;
        }
        return appInstalled;
    }

    public static void launchApp(Context ctx, String packageName) {
        try {
            Intent i = ctx.getPackageManager().getLaunchIntentForPackage(packageName);
            ctx.startActivity(i);
        } catch (Exception e) {
            Logger.logw("launchApp fail : " + e);

        }
    }

}
