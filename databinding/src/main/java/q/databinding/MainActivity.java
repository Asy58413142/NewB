package q.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import q.databinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.showData.setText("dataBinding on the bind");
        binding.setDataBean(new DataBean("ann","this is xml set binding"));
        binding.setPresenter(new Presenter());
//        binding.setVariable(q.databinding., new DataBean("ann", "this is xml set binding"));
        binding.isShow.getViewStub().inflate();//加载ViewSub布局,刷新显示
    }

    public class Presenter{
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "这是用的引用方法", Toast.LENGTH_SHORT).show();
        }
        public void ShowToast(String str) {
            Toast.makeText(MainActivity.this, str+"这是自定义", Toast.LENGTH_SHORT).show();
        }
    }
}
