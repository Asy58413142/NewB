package q.kotlindemo

/**
 * Created by ann on 2016/10/27.
 */

enum class Lang(val lang:String?){
    ENGLISH("Hello"),
    CHINESE("你好"),
    JAPANESE("你好日文");


    fun sayOne(){
        println(lang)
    }

    companion object{
        fun parse(name: String): Lang {
            return Lang.valueOf(name.toUpperCase())
        }
    }
}

class sasad{
}

fun main(args: Array<String>) {
    if (args.size==0) return
    var lang=Lang.parse(args[0])
    println(lang)
    lang.sayOne()
    lang.sayBye()
}


fun Lang.sayBye() {
    val bye = when (this) {
        Lang.ENGLISH -> "bye"
        Lang.CHINESE -> "再见"
        Lang.JAPANESE -> "哈尼asEI月"
    }
    println(bye)
}
fun sasad.assada(){

}