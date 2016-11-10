package q.android6;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by ann on 2016/11/3.
 */

public class BaseActivity extends Activity {


    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    public void requestPermission(int requestCode,String... permissions) {
        ActivityCompat.requestPermissions(this,permissions,requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constants.CALL_PHONE_CODE:
                for (int i=0;i<permissions.length;i++) {
                    if (permissions[i].equals(Manifest.permission.CALL_PHONE)) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            doCallPhone(true);
                        } else {
                            doCallPhone(false);
                        }
                    }
                }
                break;
        }
    }

    public void doCallPhone(boolean isHas) {

    }
}
