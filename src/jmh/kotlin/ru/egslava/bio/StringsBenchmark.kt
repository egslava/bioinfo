package ru.egslava.bio

import org.openjdk.jmh.annotations.*
import ru.egslava.bio.genes.*
import java.util.*

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1)
open class StringsBenchmark {
    var s201 = ""
    var dna1000000 = ""

    @Setup
    fun setUp(): Unit {
        val a = java.lang.String(CharArray(200){it.toChar()})
        s201 = String(CharArray(201) { "12345"[it % 5] })
        dna1000000 = randomDna(1000000)
    }

    // ===
    @Benchmark fun hamming() = "Hello World" hamming "World Hello"

    @Benchmark fun longestCommonString() = s201 longestCommonSubstring "_12345_"

//    @Test fun longestCommonSequence(){
//        assertEquals( "I love s and s", "I love cats and dogs" longestCommonSubsequence "I love dogs and cats" )
//    }
//
//
    @Benchmark fun splitByCount() = s201.split2(2)

    @Benchmark fun reverseComplement3() = dna1000000.reverseComplement3
    @Benchmark fun reverseComplement4() = dna1000000.reverseComplement4
    @Benchmark fun reverseComplement5() = dna1000000.reverseComplement5
    @Benchmark fun reverseComplement6() = dna1000000.reverseComplement6
    @Benchmark fun reverseComplement7() = dna1000000.reverseComplement7
    @Benchmark fun reverseComplement8() = dna1000000.reverseComplement8

    @Benchmark fun reverseComplement9() = dna1000000.reverseComplement9
    @Benchmark fun reverseComplement10() = dna1000000.reverseComplement10
    @Benchmark fun reverseComplement11() = dna1000000.reverseComplement11
    @Benchmark fun reverseComplement12() = ReverseComplementTest.reverseComplement12(dna1000000)
    @Benchmark fun reverseComplement13() = ReverseComplementTest.reverseComplement13(dna1000000)
    @Benchmark fun reverseComplement14() = dna1000000.reverseComplement14


}

/*
One million DNA:
Benchmark                               Mode     Cnt       Score       Error   Units
KotlinBenchmark.sqrtBenchmark          thrpt      10  134796.726 ± 14036.915  ops/ms
StringsBenchmark.hamming               thrpt      10   65235.818 ±  5568.665  ops/ms
StringsBenchmark.longestCommonString   thrpt      10     160.055 ±    15.358  ops/ms
StringsBenchmark.reverseComplement10   thrpt      10       0.385 ±     0.043  ops/ms
StringsBenchmark.reverseComplement11   thrpt      10       0.612 ±     0.051  ops/ms
StringsBenchmark.reverseComplement12   thrpt      10       0.597 ±     0.063  ops/ms
StringsBenchmark.reverseComplement13   thrpt      10       0.571 ±     0.076  ops/ms
StringsBenchmark.reverseComplement14   thrpt      10       0.551 ±     0.047  ops/ms
StringsBenchmark.reverseComplement3    thrpt      10       0.561 ±     0.084  ops/ms
StringsBenchmark.reverseComplement4    thrpt      10       0.570 ±     0.072  ops/ms
StringsBenchmark.reverseComplement5    thrpt      10       0.562 ±     0.055  ops/ms
StringsBenchmark.reverseComplement6    thrpt      10       0.563 ±     0.066  ops/ms
StringsBenchmark.reverseComplement7    thrpt      10       0.379 ±     0.036  ops/ms
StringsBenchmark.reverseComplement8    thrpt      10       0.404 ±     0.053  ops/ms
StringsBenchmark.reverseComplement9    thrpt      10       0.379 ±     0.036  ops/ms
StringsBenchmark.splitByCount          thrpt      10     478.463 ±    30.888  ops/ms
KotlinBenchmark.sqrtBenchmark           avgt      10      ≈ 10⁻⁵               ms/op
StringsBenchmark.hamming                avgt      10      ≈ 10⁻⁵               ms/op
StringsBenchmark.longestCommonString    avgt      10       0.006 ±     0.001   ms/op
StringsBenchmark.reverseComplement10    avgt      10       2.523 ±     0.275   ms/op
StringsBenchmark.reverseComplement11    avgt      10       1.602 ±     0.102   ms/op
StringsBenchmark.reverseComplement12    avgt      10       1.731 ±     0.148   ms/op
StringsBenchmark.reverseComplement13    avgt      10       1.772 ±     0.184   ms/op
StringsBenchmark.reverseComplement14    avgt      10       1.819 ±     0.212   ms/op
StringsBenchmark.reverseComplement3     avgt      10       1.770 ±     0.253   ms/op
StringsBenchmark.reverseComplement4     avgt      10       1.749 ±     0.182   ms/op
StringsBenchmark.reverseComplement5     avgt      10       1.833 ±     0.312   ms/op
StringsBenchmark.reverseComplement6     avgt      10       1.827 ±     0.294   ms/op
StringsBenchmark.reverseComplement7     avgt      10       2.436 ±     0.301   ms/op
StringsBenchmark.reverseComplement8     avgt      10       2.552 ±     0.261   ms/op
StringsBenchmark.reverseComplement9     avgt      10       2.619 ±     0.314   ms/op
StringsBenchmark.splitByCount           avgt      10       0.002 ±     0.001   ms/op
KotlinBenchmark.sqrtBenchmark         sample  334731      ≈ 10⁻⁴               ms/op
StringsBenchmark.hamming              sample  271079      ≈ 10⁻³               ms/op
StringsBenchmark.longestCommonString  sample  206721       0.008 ±     0.001   ms/op
StringsBenchmark.reverseComplement10  sample    3925       2.564 ±     0.054   ms/op
StringsBenchmark.reverseComplement11  sample    6292       1.596 ±     0.039   ms/op
StringsBenchmark.reverseComplement12  sample    6200       1.623 ±     0.037   ms/op
StringsBenchmark.reverseComplement13  sample    5671       1.774 ±     0.042   ms/op
StringsBenchmark.reverseComplement14  sample    5494       1.830 ±     0.044   ms/op
StringsBenchmark.reverseComplement3   sample    5805       1.729 ±     0.040   ms/op
StringsBenchmark.reverseComplement4   sample    5645       1.779 ±     0.045   ms/op
StringsBenchmark.reverseComplement5   sample    5635       1.782 ±     0.040   ms/op
StringsBenchmark.reverseComplement6   sample    4772       2.095 ±     0.060   ms/op
StringsBenchmark.reverseComplement7   sample    3894       2.574 ±     0.055   ms/op
StringsBenchmark.reverseComplement8   sample    4038       2.485 ±     0.052   ms/op
StringsBenchmark.reverseComplement9   sample    3890       2.577 ±     0.057   ms/op
StringsBenchmark.splitByCount         sample  284837       0.003 ±     0.001   ms/op
KotlinBenchmark.sqrtBenchmark             ss      10       0.021 ±     0.008   ms/op
StringsBenchmark.hamming                  ss      10       7.031 ±     0.446   ms/op
StringsBenchmark.longestCommonString      ss      10      14.618 ±     2.076   ms/op
StringsBenchmark.reverseComplement10      ss      10      12.535 ±     2.764   ms/op
StringsBenchmark.reverseComplement11      ss      10      15.001 ±     0.699   ms/op
StringsBenchmark.reverseComplement12      ss      10      11.467 ±     2.084   ms/op
StringsBenchmark.reverseComplement13      ss      10      14.286 ±     2.921   ms/op
StringsBenchmark.reverseComplement14      ss      10      14.945 ±     3.814   ms/op
StringsBenchmark.reverseComplement3       ss      10      13.987 ±     1.420   ms/op
StringsBenchmark.reverseComplement4       ss      10      15.658 ±     2.927   ms/op
StringsBenchmark.reverseComplement5       ss      10      14.253 ±     1.248   ms/op
StringsBenchmark.reverseComplement6       ss      10      13.623 ±     1.852   ms/op
StringsBenchmark.reverseComplement7       ss      10      13.361 ±     2.241   ms/op
StringsBenchmark.reverseComplement8       ss      10      12.061 ±     1.720   ms/op
StringsBenchmark.reverseComplement9       ss      10      12.267 ±     5.720   ms/op
StringsBenchmark.splitByCount             ss      10       1.389 ±     0.498   ms/op

 */

/*
Benchmark                               Mode     Cnt       Score      Error   Units
KotlinBenchmark.sqrtBenchmark          thrpt      10  137786.429 ± 4567.102  ops/ms
StringsBenchmark.hamming               thrpt      10   67472.738 ± 2993.642  ops/ms
StringsBenchmark.longestCommonString   thrpt      10     158.654 ±    4.936  ops/ms
StringsBenchmark.reverseComplement10   thrpt      10      38.349 ±    2.264  ops/ms
StringsBenchmark.reverseComplement11   thrpt      10      65.012 ±    2.451  ops/ms
StringsBenchmark.reverseComplement12   thrpt      10      61.966 ±    3.075  ops/ms
StringsBenchmark.reverseComplement13   thrpt      10      59.723 ±    2.778  ops/ms
StringsBenchmark.reverseComplement14   thrpt      10      51.607 ±    5.765  ops/ms
StringsBenchmark.reverseComplement3    thrpt      10      56.266 ±    5.443  ops/ms
StringsBenchmark.reverseComplement4    thrpt      10      55.243 ±    2.906  ops/ms
StringsBenchmark.reverseComplement5    thrpt      10      55.715 ±    5.426  ops/ms
StringsBenchmark.reverseComplement6    thrpt      10      56.197 ±    5.520  ops/ms
StringsBenchmark.reverseComplement7    thrpt      10      40.567 ±    3.249  ops/ms
StringsBenchmark.reverseComplement8    thrpt      10      39.329 ±    3.276  ops/ms
StringsBenchmark.reverseComplement9    thrpt      10      39.303 ±    1.892  ops/ms
StringsBenchmark.splitByCount          thrpt      10     465.462 ±   27.235  ops/ms
KotlinBenchmark.sqrtBenchmark           avgt      10      ≈ 10⁻⁵              ms/op
StringsBenchmark.hamming                avgt      10      ≈ 10⁻⁵              ms/op
StringsBenchmark.longestCommonString    avgt      10       0.006 ±    0.001   ms/op
StringsBenchmark.reverseComplement10    avgt      10       0.026 ±    0.001   ms/op
StringsBenchmark.reverseComplement11    avgt      10       0.015 ±    0.001   ms/op
StringsBenchmark.reverseComplement12    avgt      10       0.016 ±    0.001   ms/op
StringsBenchmark.reverseComplement13    avgt      10       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement14    avgt      10       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement3     avgt      10       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement4     avgt      10       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement5     avgt      10       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement6     avgt      10       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement7     avgt      10       0.025 ±    0.002   ms/op
StringsBenchmark.reverseComplement8     avgt      10       0.025 ±    0.002   ms/op
StringsBenchmark.reverseComplement9     avgt      10       0.026 ±    0.001   ms/op
StringsBenchmark.splitByCount           avgt      10       0.002 ±    0.001   ms/op
KotlinBenchmark.sqrtBenchmark         sample  317740      ≈ 10⁻⁴              ms/op
StringsBenchmark.hamming              sample  264864       0.001 ±    0.001   ms/op
StringsBenchmark.longestCommonString  sample  202933       0.008 ±    0.001   ms/op
StringsBenchmark.reverseComplement10  sample  196570       0.026 ±    0.001   ms/op
StringsBenchmark.reverseComplement11  sample  162145       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement12  sample  157634       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement13  sample  195287       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement14  sample  229697       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement3   sample  278901       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement4   sample  283849       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement5   sample  282465       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement6   sample  265449       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement7   sample  202105       0.025 ±    0.001   ms/op
StringsBenchmark.reverseComplement8   sample  194762       0.026 ±    0.001   ms/op
StringsBenchmark.reverseComplement9   sample  197218       0.026 ±    0.001   ms/op
StringsBenchmark.splitByCount         sample  280578       0.003 ±    0.001   ms/op
KotlinBenchmark.sqrtBenchmark             ss      10       0.019 ±    0.004   ms/op
StringsBenchmark.hamming                  ss      10       8.809 ±    5.759   ms/op
StringsBenchmark.longestCommonString      ss      10      14.287 ±    1.353   ms/op
StringsBenchmark.reverseComplement10      ss      10       2.209 ±    0.153   ms/op
StringsBenchmark.reverseComplement11      ss      10       2.418 ±    0.283   ms/op
StringsBenchmark.reverseComplement12      ss      10       1.369 ±    0.783   ms/op
StringsBenchmark.reverseComplement13      ss      10       1.253 ±    0.095   ms/op
StringsBenchmark.reverseComplement14      ss      10       2.333 ±    0.354   ms/op
StringsBenchmark.reverseComplement3       ss      10       2.490 ±    0.249   ms/op
StringsBenchmark.reverseComplement4       ss      10       2.246 ±    0.149   ms/op
StringsBenchmark.reverseComplement5       ss      10       2.297 ±    0.297   ms/op
StringsBenchmark.reverseComplement6       ss      10       2.175 ±    0.197   ms/op
StringsBenchmark.reverseComplement7       ss      10       2.473 ±    0.194   ms/op
StringsBenchmark.reverseComplement8       ss      10       2.303 ±    0.180   ms/op
StringsBenchmark.reverseComplement9       ss      10       2.351 ±    0.203   ms/op
StringsBenchmark.splitByCount             ss      10       1.475 ±    0.223   ms/op

 */

/*====
Benchmark                               Mode     Cnt       Score      Error   Units
KotlinBenchmark.sqrtBenchmark          thrpt      10  139206.604 ± 5567.008  ops/ms
StringsBenchmark.hamming               thrpt      10   68270.010 ± 3447.257  ops/ms
StringsBenchmark.longestCommonString   thrpt      10     142.732 ±   43.372  ops/ms
StringsBenchmark.reverseComplement10   thrpt      10      35.343 ±   11.946  ops/ms
StringsBenchmark.reverseComplement11   thrpt      10      63.999 ±    2.097  ops/ms
StringsBenchmark.reverseComplement12   thrpt      10      60.685 ±    3.668  ops/ms
StringsBenchmark.reverseComplement13   thrpt      10      59.580 ±    2.025  ops/ms
StringsBenchmark.reverseComplement14   thrpt      10      53.002 ±   10.028  ops/ms
StringsBenchmark.reverseComplement3    thrpt      10      54.247 ±    8.715  ops/ms
StringsBenchmark.reverseComplement4    thrpt      10      55.737 ±    4.900  ops/ms
StringsBenchmark.reverseComplement5    thrpt      10      55.477 ±    3.305  ops/ms
StringsBenchmark.reverseComplement6    thrpt      10      55.264 ±    5.531  ops/ms
StringsBenchmark.reverseComplement7    thrpt      10      41.586 ±    3.352  ops/ms
StringsBenchmark.reverseComplement8    thrpt      10      40.195 ±    3.201  ops/ms
StringsBenchmark.reverseComplement9    thrpt      10      41.740 ±    4.282  ops/ms
StringsBenchmark.splitByCount          thrpt      10     475.162 ±   14.854  ops/ms
KotlinBenchmark.sqrtBenchmark           avgt      10      ≈ 10⁻⁵              ms/op
StringsBenchmark.hamming                avgt      10      ≈ 10⁻⁵              ms/op
StringsBenchmark.longestCommonString    avgt      10       0.006 ±    0.001   ms/op
StringsBenchmark.reverseComplement10    avgt      10       0.025 ±    0.002   ms/op
StringsBenchmark.reverseComplement11    avgt      10       0.015 ±    0.001   ms/op
StringsBenchmark.reverseComplement12    avgt      10       0.015 ±    0.001   ms/op
StringsBenchmark.reverseComplement13    avgt      10       0.016 ±    0.001   ms/op
StringsBenchmark.reverseComplement14    avgt      10       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement3     avgt      10       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement4     avgt      10       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement5     avgt      10       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement6     avgt      10       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement7     avgt      10       0.024 ±    0.002   ms/op
StringsBenchmark.reverseComplement8     avgt      10       0.025 ±    0.001   ms/op
StringsBenchmark.reverseComplement9     avgt      10       0.024 ±    0.001   ms/op
StringsBenchmark.splitByCount           avgt      10       0.002 ±    0.001   ms/op
KotlinBenchmark.sqrtBenchmark         sample  331492      ≈ 10⁻⁴              ms/op
StringsBenchmark.hamming              sample  264267      ≈ 10⁻³              ms/op
StringsBenchmark.longestCommonString  sample  198237       0.008 ±    0.001   ms/op
StringsBenchmark.reverseComplement10  sample  198280       0.026 ±    0.001   ms/op
StringsBenchmark.reverseComplement11  sample  161990       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement12  sample  172397       0.017 ±    0.001   ms/op
StringsBenchmark.reverseComplement13  sample  221569       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement14  sample  283731       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement3   sample  284018       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement4   sample  207752       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement5   sample  291105       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement6   sample  266114       0.018 ±    0.001   ms/op
StringsBenchmark.reverseComplement7   sample  207478       0.025 ±    0.001   ms/op
StringsBenchmark.reverseComplement8   sample  201085       0.026 ±    0.001   ms/op
StringsBenchmark.reverseComplement9   sample  201685       0.025 ±    0.001   ms/op
StringsBenchmark.splitByCount         sample  280115       0.003 ±    0.001   ms/op
KotlinBenchmark.sqrtBenchmark             ss      10       0.020 ±    0.005   ms/op
StringsBenchmark.hamming                  ss      10       8.606 ±    1.305   ms/op
StringsBenchmark.longestCommonString      ss      10      16.384 ±    1.957   ms/op
StringsBenchmark.reverseComplement10      ss      10       2.393 ±    0.369   ms/op
StringsBenchmark.reverseComplement11      ss      10       2.402 ±    0.390   ms/op
StringsBenchmark.reverseComplement12      ss      10       1.382 ±    0.305   ms/op
StringsBenchmark.reverseComplement13      ss      10       1.355 ±    0.228   ms/op
StringsBenchmark.reverseComplement14      ss      10       2.593 ±    0.231   ms/op
StringsBenchmark.reverseComplement3       ss      10       2.923 ±    0.285   ms/op
StringsBenchmark.reverseComplement4       ss      10       2.619 ±    0.445   ms/op
StringsBenchmark.reverseComplement5       ss      10       2.474 ±    0.355   ms/op
StringsBenchmark.reverseComplement6       ss      10       2.446 ±    0.294   ms/op
StringsBenchmark.reverseComplement7       ss      10       2.526 ±    0.211   ms/op
StringsBenchmark.reverseComplement8       ss      10       3.196 ±    1.290   ms/op
StringsBenchmark.reverseComplement9       ss      10       2.871 ±    0.551   ms/op
StringsBenchmark.splitByCount             ss      10       1.977 ±    1.098   ms/op
 */