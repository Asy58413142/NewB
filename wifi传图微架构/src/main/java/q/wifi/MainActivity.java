package q.wifi;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import q.pintudemo.IMyAidlInterface;
import q.wifi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ServiceConnection conn;
    private IMyAidlInterface stub;
    private ActivityMainBinding binding;
    private NumData numData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        numData = new NumData("", "");
        binding.setNumData(numData);
        binding.setVariable(BR.Presenter, new presenter());
        initService();
    }

    private void initService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("q.pintudemo", "q.pintudemo.AidlService"));
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                stub = IMyAidlInterface.Stub.asInterface(service) ;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                stub = null;
            }
        };
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

   public class presenter{
        public void onStartAdd(String num1,String num2) {
            try {
                int result = stub.Add(Integer.valueOf(num1), Integer.valueOf(num2));
                numData.setResult(String.valueOf(result));

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (conn != null) {
            unbindService(conn);
        }
    }
}