package q.recyclerviewitem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by ann on 2016/11/3.
 */

public class ThreeViewHolder extends BaseViewHolder {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.img2)
    ImageView img2;
    public ThreeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindView(ModelData modelData) {
        img.setBackgroundResource(modelData.img);
        name.setText(modelData.name);
        content.setText(modelData.context);
        img2.setBackgroundResource(modelData.background);
    }
}
