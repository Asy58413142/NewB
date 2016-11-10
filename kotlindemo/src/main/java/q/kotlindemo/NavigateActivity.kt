package q.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_navigate.*

class NavigateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigate)
        var data=intent.getStringExtra("id")
        toast(data)

        show.text=sum(9,3).toString()+"\n"+ sum1(4,6).toString()+"\n"+ sum2(1,2)
        val arrays: List<String> = listOf<String>("dddXAaa","bbb","ccc")
        var text:String
        for (arg in arrays) {
            println(arg)
            Log.d(arg,arg)
        }

    }



}
