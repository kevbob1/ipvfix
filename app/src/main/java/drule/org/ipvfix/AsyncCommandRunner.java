package drule.org.ipvfix;

import android.os.AsyncTask;

/**
 * Created by kev on 6/23/14.
 */
public class AsyncCommandRunner extends AsyncTask<CommandRunner.MtuSetter,Void,Boolean> {

    @Override
    protected Boolean doInBackground(CommandRunner.MtuSetter... params) {
        CommandRunner runner = new CommandRunner();
        return runner.changeMTU(params[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

    }
}
