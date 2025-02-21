package ws.mochaa.biometricpay.util.log.handler;

import android.util.Log;

import ws.mochaa.biometricpay.util.log.inf.ILog;

/**
 * Created by Jason on 2017/9/10.
 */

public class GenericLog implements ILog {
    @Override
    public void debug(String tag, String msg) {
        Log.d(tag, msg);
    }

    @Override
    public void error(String tag, String msg) {
        Log.e(tag, msg);
    }
}
