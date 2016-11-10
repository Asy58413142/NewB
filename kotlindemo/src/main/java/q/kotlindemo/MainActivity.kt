package q.kotlindemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var showText:TextView =findViewById(R.id.textViewShow) as TextView
        showText.setText("hhhhhhhhhh")
        showText.setOnClickListener { toast("aaaaaa",Toast.LENGTH_SHORT) }
        var num:Int=0
        btn_change.setOnClickListener { showNum.setText((num++).toString())
            toast("我是工具类里的Toast")
            navigate<NavigateActivity>("1233")
        }
    }

    fun Context.toast(msg: String, duration: Int=Toast.LENGTH_LONG) {
        Toast.makeText(this,msg,duration).show()
    }
}
