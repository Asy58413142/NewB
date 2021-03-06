package q.recyclerviewitem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by ann on 2016/11/3.
 */

public class TwoViewHolder extends BaseViewHolder {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.name)
    TextView name;
    public TwoViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindView(ModelData modelData) {
        img.setBackgroundResource(modelData.img);
        name.setText(modelData.name);
    }
}
