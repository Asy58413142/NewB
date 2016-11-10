package q.wifi;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Package :q.wifi.
 * Author :ann.
 * Time:2016/11/9_20:20.
 */

public class NumData extends BaseObservable{
    public String num1;
    public String num2;
    public String result;
    @Bindable
    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
        notifyPropertyChanged(BR.num1);
    }
    @Bindable
    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
        notifyPropertyChanged(BR.num2);
    }

    public NumData(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }
}
