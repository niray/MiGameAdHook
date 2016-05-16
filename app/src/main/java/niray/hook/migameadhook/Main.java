package niray.hook.migameadhook;

import android.app.Activity;
import android.content.Intent;
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
        //Hook HuaWei Music
        if (loadPackageParam.packageName.contains("com.android.mediacenter")) {
            Log.e("hook Music", "hookX Success In Music " + loadPackageParam.packageName);
            findAndHookMethod("com.android.mediacenter.PageActivity", loadPackageParam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                //                @Override
//                protected Object replace(MethodHookParam methodHookParam) throws Throwable {
//                    Log.e("hook Music", "afterHookedMethod In  " + loadPackageParam.packageName);
//                    XposedBridge.invokeOriginalMethod(methodHookParam.method, methodHookParam.thisObject, methodHookParam.args);
//                    return null;
//                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Activity activity = (Activity) param.thisObject;
                    Intent it = new Intent();
                    it.setClassName("com.android.mediacenter", "com.android.mediacenter.ui.local.AllSongsTabActivity");
                    activity.startActivity(it);
                    // activity.finish();
                }
            });

        }
    }

}
