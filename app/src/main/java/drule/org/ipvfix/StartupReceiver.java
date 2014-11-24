package drule.org.ipvfix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by kev on 6/23/14.
 */
public class StartupReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("StartupReceiver:onReceive", "startup received");
//        AsyncCommandRunner task = new AsyncCommandRunner(context);
//        task.execute(new CommandRunner.MtuSetter("wlan0", 1472));
    }



}
