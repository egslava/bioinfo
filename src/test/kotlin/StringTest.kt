import ru.egslava.bio.genes.ReverseComplementTest.reverseComplement12
import ru.egslava.bio.genes.ReverseComplementTest.reverseComplement13
import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import ru.egslava.bio.genes.*
import java.security.InvalidAlgorithmParameterException
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Created by egslava on 13/09/16.
 */

val sampleDna1 = "ACTGACTGACTGACTG"
//val sampleDnas: Array<String>

class StringTest {

    @Test fun hammingTest(){
        assertEquals( 0, "" hamming  "")
        assertEquals( 0, "1234" hamming "1234" )
        assertFailsWith( InvalidAlgorithmParameterException::class) {"12345" hamming "1234"}
        assertEquals( 0, "cat" hamming  "cat")
        assertEquals( 2, "кот" hamming  "ток")
        assertEquals( 1, "кошка" hamming  "кишка")
        assertEquals( 2, "Кошка" hamming  "кишка")


        assertEquals( 6, "12456789" hamming "12345678" )
    }

    @Test fun levensteinTest() {
//        assertEquals( 0, "12345", "12345")
    }

    @Test fun longestCommonString(){
        for (i in 1..10000){
            "0123450012345001234500123450012345001234500123450012345001234500123450012345001234500123450012345001234500123450012345001234500123450012345001234500123450012345001234500123450012345001234500123450" longestCommonSubstring "_12345_"
        }
        assertEquals( "I love ", "I love cats and dogs" longestCommonSubstring "I love dogs and cats" )
        assertEquals( "bo", "about" longestCommonSubstring "boat" )
        assertEquals( "12345", "0123450" longestCommonSubstring "_12345_" )
        assertEquals( null, "cat" longestCommonSubstring "dog" )
        assertEquals( null, "" longestCommonSubstring "dog" )
        assertEquals( null, "cat" longestCommonSubstring "" )
    }

    @Test fun longestCommonSequence(){
//        assertEquals( "I love s and s", "I love cats and dogs" longestCommonSubsequence "I love dogs and cats" )
    }


    @Test fun splitByCount(){
        assertArrayEquals( arrayOf("123", "456"       ), "123456"    .split2(3) )
        assertArrayEquals( arrayOf("123", "456", "789"), "123456789" .split2(3) )
    }

    @Test fun testReverseComplement0(){
//        println("Using sampleDnas. sampleDnas[0] = ${sampleDnas[0]}")
        assertEquals("// just waiting for variable initialization", "// just waiting for variable initialization")
    }
//    @Test fun testReverseComplement1(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement1)
//        assertEquals("", "".reverseComplement1)
//        assertEquals("A", "T".reverseComplement1)
//        assertEquals("T", "A".reverseComplement1)
////        sampleDnas.forEach { it.reverseComplement1 }
//    }

//    @Test fun testReverseComplement2(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement2)
//        assertEquals("", "".reverseComplement2)
//        assertEquals("A", "T".reverseComplement2)
//        assertEquals("T", "A".reverseComplement2)
//        sampleDnas.forEach { it.reverseComplement2 }
//    }
//
//    @Test fun testReverseComplement3(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement3)
//        assertEquals("", "".reverseComplement3)
//        assertEquals("A", "T".reverseComplement3)
//        assertEquals("T", "A".reverseComplement3)
//        sampleDnas.forEach { it.reverseComplement3 }
//    }
//
//    @Test fun testReverseComplement4(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement4)
//        assertEquals("", "".reverseComplement4)
//        assertEquals("A", "T".reverseComplement4)
//        assertEquals("T", "A".reverseComplement4)
//        sampleDnas.forEach { it.reverseComplement4 }
//    }

    @Test fun testReverseComplement5(){
        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement5)
        assertEquals("", "".reverseComplement5)
        assertEquals("A", "T".reverseComplement5)
        assertEquals("T", "A".reverseComplement5)
//        sampleDnas.forEach { it.reverseComplement5 }
    }

//    @Test fun testReverseComplement6(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement6)
//        assertEquals("", "".reverseComplement6)
//        assertEquals("A", "T".reverseComplement6)
//        assertEquals("T", "A".reverseComplement6)
//        sampleDnas.forEach { it.reverseComplement6 }
//    }
//
//    @Test fun testReverseComplement7(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement7)
//        assertEquals("", "".reverseComplement7)
//        assertEquals("A", "T".reverseComplement7)
//        assertEquals("T", "A".reverseComplement7)
//        sampleDnas.forEach { it.reverseComplement7 }
//    }
//
//    @Test fun testReverseComplement8(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement8)
//        assertEquals("", "".reverseComplement8)
//        assertEquals("A", "T".reverseComplement8)
//        assertEquals("T", "A".reverseComplement8)
//        sampleDnas.forEach { it.reverseComplement8 }
//    }
//
//    @Test fun testReverseComplement9(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement9)
//        assertEquals("", "".reverseComplement9)
//        assertEquals("A", "T".reverseComplement9)
//        assertEquals("T", "A".reverseComplement9)
//        sampleDnas.forEach { it.reverseComplement9 }
//    }
//
//    @Test fun testReverseComplement10(){
//        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement10)
//        assertEquals("", "".reverseComplement10)
//        assertEquals("A", "T".reverseComplement10)
//        assertEquals("T", "A".reverseComplement10)
//        sampleDnas.forEach { it.reverseComplement10 }
//    }

    @Test fun testReverseComplement11(){
        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement11)
        assertEquals("", "".reverseComplement11)
        assertEquals("A", "T".reverseComplement11)
        assertEquals("T", "A".reverseComplement11)
//        sampleDnas.forEach { it.reverseComplement11 }
    }

    @Test fun testReverseComplement012(){
        assertEquals("CAGTCAGTCAGTCAGT", reverseComplement12(sampleDna1))
        assertEquals("", reverseComplement12(""))
        assertEquals("A", reverseComplement12("T"))
        assertEquals("T", reverseComplement12("A"))
//        sampleDnas.forEach { reverseComplement12(it) }
    }

    @Test fun testReverseComplement013(){
        assertEquals("CAGTCAGTCAGTCAGT", reverseComplement13(sampleDna1))
        assertEquals("", reverseComplement13(""))
        assertEquals("A", reverseComplement13("T"))
        assertEquals("T", reverseComplement13("A"))
//        sampleDnas.forEach { reverseComplement13(it) }
    }

    @Test fun testReverseComplement14(){
        assertEquals("CAGTCAGTCAGTCAGT", sampleDna1.reverseComplement14)
        assertEquals("", "".reverseComplement14)
        assertEquals("A", "T".reverseComplement14)
        assertEquals("T", "A".reverseComplement14)
//        sampleDnas.forEach { it.reverseComplement14 }
    }
}