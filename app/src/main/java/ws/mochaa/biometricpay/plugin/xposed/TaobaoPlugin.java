package ws.mochaa.biometricpay.plugin.xposed;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import ws.mochaa.biometricpay.BuildConfig;
import ws.mochaa.biometricpay.plugin.TaobaoBasePlugin;
import ws.mochaa.biometricpay.util.log.L;

/**
 * Created by Jason on 2017/9/8.
 */

public class TaobaoPlugin extends TaobaoBasePlugin {


    @Keep
    public void main(final Context context, final XC_LoadPackage.LoadPackageParam lpparam) {
        L.d("Xposed plugin init version: " + BuildConfig.VERSION_NAME);
        try {
            XposedHelpers.findAndHookMethod(AppCompatActivity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    onActivityResumed((AppCompatActivity) param.thisObject);
                }
            });
            XposedHelpers.findAndHookMethod(AppCompatActivity.class, "onCreate", Bundle.class, new XC_MethodHook() {

                protected void afterHookedMethod(MethodHookParam param) {
                    onActivityCreated((AppCompatActivity) param.thisObject);
                }
            });
        } catch (Throwable l) {
            XposedBridge.log(l);
        }
    }
}
