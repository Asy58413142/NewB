package q.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import q.databinding.databinding.ActivityTwowaybindBinding;

/**
 * Created by ann on 2016/11/7.
 */

public class TwoWayBindActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwowaybindBinding woWayBind=DataBindingUtil.setContentView(this, R.layout.activity_twowaybind);
        woWayBind.setUser(new DataBean("",""));
    }
}
