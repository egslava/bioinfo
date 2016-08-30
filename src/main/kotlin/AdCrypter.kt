import java.util.*

/**
 * Created by egslava on 25/7/16.
 */

object  AdCrypter {
//    val debugKey = """}|I~MQ\^\\`^cdcg`fddeedljjospsvwu"""
//    val debugKey = """ca-app-pub-7854748869163221/6326957996"""
    val debugKey = """}|I~MQ\^\\`^cdcg`fddee³nkhissntwo"""
//    val isInDebugMode = true

    fun userCountry() = "TJ"

//    fun isInDebugMode(): Boolean {
//        val m = if (userCountry() == "TJ") 0.1 else 1.0;
//
//        //   t =    1429629783877
//        val s = 1434751971000L
//        val d = 86400000L
//        val t = System.currentTimeMillis();
//        if (Random().nextDouble() <= 0.1 * m * from0to1(s + 2 * d, 30 * d, t)){ return true; }
//        return false;
//    }

    fun minimax (value: Double, min: Double, max: Double) : Double{
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    fun from0to1(start: Long, period: Long, value: Long) = from0to1( start.toDouble(), period.toDouble(), value.toDouble() );
    fun from0to1(start: Double, period: Double, value: Double) = minimax((value - start ) / period, 0.0, 1.0)

    fun a(s: String, v: Int, _in: Int): String {
        val r = StringBuffer(s.length);

        var _v = v
        for (i in 0..s.length-1){
            _v += _in;
            r.append( (s[i] + _v).toChar() );
        }
        return r.toString();
    }

    data class Key(val name: String, val key: String);
    @JvmStatic fun main (args: Array<String>){
        val keys = arrayOf(
                Key("ru.egslava.tatar_dictionary (app id)", """ca-app-pub-7854748869163221~8400982790"""),
                Key ("ru.egslava.tatar_dictionary (Ad unit id)", """ca-app-pub-7854748869163221/9877715998"""),
                Key("ru.egslava.azerbaijani_dictionary (App ID", """ca-app-pub-7854748869163221~2354449199"""),
                Key("ru.egslava.azerbaijani_dictionary (Ad unit ID)" , """ca-app-pub-7854748869163221/3831182398"""),
                Key("ru.egslava.armenian_dictionary not exist(App ID)", """ca-app-pub-7854748869163221~5307915594"""),
                Key("ru.egslava.armenian_dictionary not exist (Ad unit ID)", """ca-app-pub-7854748869163221/6784648790"""),
                Key("ru.egslava.kazah_dictionary (App ID", """ca-app-pub-7854748869163221~8261381994"""),
                Key("ru.egslava.kazah_dictionary (Ad unit ID)", """ca-app-pub-7854748869163221/9738115196"""),
                Key("ru.egslava.kirgiz_dictionary (App ID)", """ca-app-pub-7854748869163221~2214848395"""),
                Key("ru.egslava.kirgiz_dictionary (Ad unit ID)", """ca-app-pub-7854748869163221/3691581595"""),
                Key("ru.egslava.tajik_dictionary (App ID)", """ca-app-pub-7854748869163221~5168314798"""),
                Key("ru.egslava.tajik_dictionary (Ad unit ID)", """ca-app-pub-7854748869163221/6645047997"""),
                Key("ru.egslava.uzbek_dictionary (App ID)", """ca-app-pub-7854748869163221~8121781197"""),
                Key("ru.egslava.uzbek_dictionary (Ad unit ID", """ca-app-pub-7854748869163221/9598514392"""),

                Key("ru.egslava.dictionary (App ID)", """ca-app-pub-7854748869163221~2978401193"""),
                Key("ru.egslava.dictionary (Ad unit ID", """ca-app-pub-7854748869163221/4455134390""")
        )

        keys.forEach {
            println("${it.name} (${it.key}) \n>>>${a(it.key, 25, 1)}<<<")
        }

        val crypted = a(debugKey, 25, 1)
        println(crypted)
        val decrypted = a(debugKey, -25, -1)
        println(decrypted)
        println(a(crypted, -25, -1))
    }
}