package drule.org.ipvfix;

import android.util.Log;

/**
 * Created by kev on 6/22/14.
 */
public class CommandRunner {




    public boolean changeMTU(String interface, int mtu) {

        try{
            StringBuilder cmd = new StringBuilder();
            cmd.append("ifconfig ");
            cmd.append(interface);
            cmd.append(" mtu ");
            cmd.append(Integer.toString(mtu));
            cmd.append('\n');
            
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());


            outputStream.writeBytes("screenrecord --time-limit 10 /sdcard/MyVideo.mp4\n");
            outputStream.flush();

            outputStream.writeBytes("exit\n");
            outputStream.flush();
            su.waitFor();
        }catch(IOException e){
            Log.e("CommandRunner:changeMTU", e);
        }catch(InterruptedException e){
            throw new Exception(e);
        }


    }


}
