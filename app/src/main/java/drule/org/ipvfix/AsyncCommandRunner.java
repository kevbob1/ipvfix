package drule.org.ipvfix;

import android.os.AsyncTask;
import android.content.Context;
import android.support.v4.app.NotificationCompat;


/**
 * Created by kev on 6/23/14.
 */
public class AsyncCommandRunner extends AsyncTask<CommandRunner.MtuSetter,Void,Boolean> {

    private final Context context;

    public AsyncCommandRunner(final Context ctx_) {
        super();
        this.context = ctx_;
    }

    @Override
    protected Boolean doInBackground(CommandRunner.MtuSetter... params) {
        CommandRunner runner = new CommandRunner();
        return runner.changeMTU(params[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
    }
}
