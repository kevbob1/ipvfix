package drule.org.ipvfix;

import android.util.Log;
import java.io.IOException;
import java.io.DataOutputStream;

/**
 * Created by kev on 6/22/14.
 */
public class CommandRunner {

    public boolean changeMTU(final MtuSetter mtu_setter) {
        StringBuilder cmd = new StringBuilder();
        try{
            cmd.append("ifconfig ");
            cmd.append(mtu_setter.ifName);
            cmd.append(" mtu ");
            cmd.append(Integer.toString(mtu_setter.mtu));
            cmd.append('\n');
            
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());


            outputStream.writeBytes(cmd.toString());
            outputStream.flush();

            outputStream.writeBytes("exit\n");
            outputStream.flush();
            su.waitFor();
            int exitValue = su.exitValue();

            if (exitValue != 0) {
                return false;

            } else {
                return true;
            }
        }catch(Throwable e){
            Log.e("CommandRunner:changeMTU", "problem running command: " + cmd,  e);
            return false;
        }
    }


    public static class MtuSetter {
        private final String ifName;
        private final int mtu;

        public MtuSetter(final String if_name, final int mtu_) {
            this.ifName = if_name;
            this.mtu = mtu_;
        }
    }
}
