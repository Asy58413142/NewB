package q.recyclerviewitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_container)
    RecyclerView recyclerView;

    private int[] color = {android.R.color.holo_red_light,android.R.color.holo_green_light,android.R.color.holo_blue_dark};
    private DemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        GridLayoutManager layout = new GridLayoutManager(this,2);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getItemViewType(position) == 1) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(layout);
        adapter = new DemoAdapter(this);

        recyclerView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        List<ModelData> modelDatas = new ArrayList<>();
        for (int i=0;i<30;i++) {
            ModelData modelData = new ModelData();
//            int type = (int) (Math.random()*3 + 1);
            int type;
            if (i < 9) {
                type = 2;
            } else if (i >= 9 && i < 20) {
                type = 1;
            } else {
                type = 3;
            }
            modelData.type = type;

            modelData.img = color[type-1];
            modelData.background = color[(type+2)%3];
            modelData.name = "name" + i;
            modelData.context = "content" + i;
            modelDatas.add(modelData);
        }

        adapter.setModelDatas(modelDatas);
        adapter.notifyDataSetChanged();
    }
}
