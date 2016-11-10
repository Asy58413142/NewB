package q.pintudemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AidlService extends Service {
    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public int Add(int num1, int num2) throws RemoteException {
            return num1+num2;
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder==null?new AddIBinder():iBinder;
    }

    class AddIBinder extends IMyAidlInterface.Stub {
        @Override
        public int Add(int num1, int num2) throws RemoteException {
            return num1+num2;
        }
    }

}
