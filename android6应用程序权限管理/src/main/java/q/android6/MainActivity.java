package q.android6;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.call).setOnClickListener(this);
    }

    @Override
    public void doCallPhone(boolean isHas) {
        if (isHas) {
            Intent intent = new Intent();
            intent.setData(Uri.parse("tel:" + "10086"));
            startActivity(intent);
        } else {
            Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (hasPermission(Manifest.permission.CALL_PHONE)) {
            doCallPhone(true);
        } else {
            requestPermission(Constants.CALL_PHONE_CODE,Manifest.permission.CALL_PHONE);
        }
    }
}
