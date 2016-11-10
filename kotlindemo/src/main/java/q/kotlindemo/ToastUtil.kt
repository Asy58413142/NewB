package q.kotlindemo

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.widget.Toast

/**
 * Created by ann on 2016/10/22.
 */
fun Activity.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Fragment.toast(msg : CharSequence , duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity,msg,duration).show()
}
inline public fun <reified T : Activity> Activity.navigate(id: String) {
    val intent= Intent(this, T::class.java)
    intent.putExtra("id",id)
    startActivity(intent)
}
fun sum(a : Int,b : Int): Int {
    return a+b
}
fun sum1(a:Int,b:Int):Int=a+b
fun sum2(a: Int, b: Int): Unit {
    print(a+b)
}
