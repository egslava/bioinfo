import java.security.InvalidParameterException

/**
 * Created by egslava on 27/7/16.
 */
object Third {
    val dataset     = """TCTGGGCGGGAGTAGGTTGTTACCATGGGCGCCAGTGACCGAAGGCTGGCAGTTGTATACGTACTCCGACCGCCACTCCTTGGGATGCAGGCTCCCCTACCACTCCGTAGGCAAACGTGTATTGATTCGCCGTGCGGGAGGTCCCCGAGTCCGATCAATCTCTTTGGACTACGCGTCCTATAATAATGTTAAAACTGACTATTAGCGTTCTGATTTTAACTAGGGAAGTACAAAGACTACGACATCCCAAGTGTTCTTCAATCGCGGTCACACTGCCGGAAACTCCCATGCAGCAAATCTTGCGGTCGACGCGGGGCTTCGATGAGCTCGGTCCTATCGAATACAAACAATGACCCTCTAACCAGAGCCAAACTTGCCCTGGTAAGCGTAGGCGTCGTATGCCTGACGCTTGCGAGTCATAATACACCGGGACTGTCGAGAAGGAGTATCCCGGATGCAACAGCAGGTTTTAGTCCAACAGTTTAAGTCCTGTACAGGAATTCGTTCATAATTCCTTCTTCGGGGTGACCCTCCCTTTACGAGAACGCCTAATCGCGGTAAGCTTACGTCAAATAGCGGGCCCCGATCGGTTCGGTCTCAAACTGACCGCTTTGTGGGCGCCGGACTCCATAATGTCGCGCAATTCCAAAGCCATAGCATGGGCCACCGACCCGGCCCCTGAGGATCTCCTTCATAAACCTCGCGGTCCCGTTCCCTATACAACTGGTGAGTTGCTATCCTTGCAGAAGATTCGTCGGTACATATCGCCTCTACATGATATTAGTCTTCCACGAGTATTCGCGAGGTGTCAGGTGACGTTGCGCCCTTACGTCATTCCATCGTCCTGGATAATCCCAGA"""
    val result      = """TCTGGGATTATCCAGGACGATGGAATGACGTAAGGGCGCAACGTCACCTGACACCTCGCGAATACTCGTGGAAGACTAATATCATGTAGAGGCGATATGTACCGACGAATCTTCTGCAAGGATAGCAACTCACCAGTTGTATAGGGAACGGGACCGCGAGGTTTATGAAGGAGATCCTCAGGGGCCGGGTCGGTGGCCCATGCTATGGCTTTGGAATTGCGCGACATTATGGAGTCCGGCGCCCACAAAGCGGTCAGTTTGAGACCGAACCGATCGGGGCCCGCTATTTGACGTAAGCTTACCGCGATTAGGCGTTCTCGTAAAGGGAGGGTCACCCCGAAGAAGGAATTATGAACGAATTCCTGTACAGGACTTAAACTGTTGGACTAAAACCTGCTGTTGCATCCGGGATACTCCTTCTCGACAGTCCCGGTGTATTATGACTCGCAAGCGTCAGGCATACGACGCCTACGCTTACCAGGGCAAGTTTGGCTCTGGTTAGAGGGTCATTGTTTGTATTCGATAGGACCGAGCTCATCGAAGCCCCGCGTCGACCGCAAGATTTGCTGCATGGGAGTTTCCGGCAGTGTGACCGCGATTGAAGAACACTTGGGATGTCGTAGTCTTTGTACTTCCCTAGTTAAAATCAGAACGCTAATAGTCAGTTTTAACATTATTATAGGACGCGTAGTCCAAAGAGATTGATCGGACTCGGGGACCTCCCGCACGGCGAATCAATACACGTTTGCCTACGGAGTGGTAGGGGAGCCTGCATCCCAAGGAGTGGCGGTCGGAGTACGTATACAACTGCCAGCCTTCGGTCACTGGCGCCCATGGTAACAACCTACTCCCGCCCAGA"""

    @JvmStatic fun main(args: Array<String>) {

        val output = dataset.map { when (it){
            'A' -> 'T'
            'T' -> 'A'
            'G' -> 'C'
            'C' -> 'G'
            else -> throw InvalidParameterException("String contains invalid symbols")
        }}.reversed().joinToString("")

        println(output)
        println(result)
        println(output == result)
    }
}
