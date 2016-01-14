package com.nmj.att.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

    public static void showAlert(Activity act, String message, String positiveBtnText, DialogInterface.OnClickListener positiveBtnClickListener,
                                 String negativeBtnText, DialogInterface.OnClickListener negativeBtnClickListener, boolean cancelable) {

        AlertDialog.Builder ab = new AlertDialog.Builder(act);
        if (null != positiveBtnText && !positiveBtnText.isEmpty()) {
            ab.setPositiveButton(positiveBtnText, positiveBtnClickListener);
        }

        if (null != negativeBtnText && !negativeBtnText.isEmpty()) {
            ab.setNegativeButton(negativeBtnText, negativeBtnClickListener);
        }

        ab.setMessage(message);
        ab.setCancelable(cancelable);
        ab.show();
    }

    public static void showAlert(Activity act, String message, String positiveBtnText, DialogInterface.OnClickListener positiveBtnClickListener, boolean cancelable) {
        showAlert(act, message, positiveBtnText, positiveBtnClickListener, "", null, cancelable);
    }


}
