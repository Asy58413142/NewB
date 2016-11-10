package q.recyclerviewitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ann on 2016/11/3.
 */

public class DemoAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public List<ModelData> modelDatas;
    private final LayoutInflater layoutInflater;

    public DemoAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setModelDatas(List<ModelData> modelDatas) {
        this.modelDatas = modelDatas;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ModelData.TYPE_ONE:
                return new OneViewHolder(layoutInflater.inflate(R.layout.item_one, parent, false));
            case ModelData.TYPE_TWO:
                return new TwoViewHolder(layoutInflater.inflate(R.layout.item_two,parent,false));
            case ModelData.TYPE_THREE:
                return new ThreeViewHolder(layoutInflater.inflate(R.layout.item_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBindView(modelDatas.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return modelDatas.get(position).type;
    }

    @Override
    public int getItemCount() {
        return modelDatas.size();
    }
}
