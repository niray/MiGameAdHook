package niray.hook.migameadhook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Main implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(final LoadPackageParam loadPackageParam) throws Throwable {
        //Hook Mi Games
        if (loadPackageParam.packageName.contains("com.xiaomi.gamecenter.sdk.service")) {
            Log.e("hook MI", "hookX Success In gamecenter " + loadPackageParam.packageName);
            findAndHookMethod("com.xiaomi.gamecenter.sdk.ui.actlayout.ViewForLoginMessage", loadPackageParam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                    Log.e("hook MI", "afterHookedMethod In  " + loadPackageParam.packageName);
                    XposedHelpers.callMethod(param.thisObject, "a", true, true);
                }
            });
        }
        //Hook Word Lock Screen
        if (loadPackageParam.packageName.contains("com.jiongji.andriod.card")) {
            Log.e("hook word", "hookX Success In hundred word " + loadPackageParam.packageName);
            findAndHookMethod("com.baicizhan.client.wordlock.activity.WordLockClient", loadPackageParam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                    Log.e("hook word", "afterHookedMethod In  " + loadPackageParam.packageName);
                    Activity activity = (Activity) param.thisObject;
                    activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
            });
        }
    }

}
