package q.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by ann on 2016/11/4.
 */

public class DataBean extends BaseObservable{
    public String name;
    public String value;

    public DataBean(String name, String value) {
        this.name = name;
        this.value = value;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getValue() {
        return value;
    }
    @Bindable
    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }
}
