package niray.hook.migameadhook;

import android.os.Bundle;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Main implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(final LoadPackageParam loadPackageParam) throws Throwable {
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
    }

}
