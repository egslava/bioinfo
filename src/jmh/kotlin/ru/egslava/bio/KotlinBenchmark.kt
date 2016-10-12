package ru.egslava.bio

import org.openjdk.jmh.annotations.*

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1)
open class KotlinBenchmark {
    var value: Double = 0.0

    @Setup
    fun setUp(): Unit {
        value = 3.0
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    fun sqrtBenchmark(): Double = Math.sqrt(value)

}