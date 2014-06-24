package drule.org.ipvfix;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runButton = (Button) findViewById(R.id.run_btn);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncCommandRunner task = new AsyncCommandRunner(MainActivity.this);
                task.execute(new CommandRunner.MtuSetter("wlan0", 1472));
            }
        });



    }



}
