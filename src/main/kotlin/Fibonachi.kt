/**
 * Created by egslava on 22/08/16.
 */


object Fibonachi {

    fun fibonacchi(n: Int): Int = when (n){
        1 -> 1
        2 -> 1
        else -> fibonacchi(n - 1) + fibonacchi(n - 2)
    }

    @JvmStatic fun main(args: Array<String>) {
        println(fibonacchi(1))
        println(fibonacchi(2))
        println(fibonacchi(3))
        println(fibonacchi(4))
        println(fibonacchi(5))

        println(fibonacchi(6))
        println(fibonacchi(7))
        println(fibonacchi(8))
        println(fibonacchi(9))
    }
}
