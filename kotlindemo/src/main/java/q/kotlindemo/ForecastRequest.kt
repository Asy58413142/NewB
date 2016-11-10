package q.kotlindemo

/**
 * Created by ann on 2016/10/22.
 */
public class ForecastRequest(val zipCode : String) {
    companion object{
        private val appId="222222"
        private val url="&Id5555555"
    }
//    fun execute() : ForecastRequest{
//        return (URL(url).readText())
//    }
}