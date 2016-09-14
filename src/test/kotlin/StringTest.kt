import common.hamming
import common.split
import common.split2
import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.security.InvalidAlgorithmParameterException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Created by egslava on 13/09/16.
 */

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
//        assertEquals()
    }

    @Test fun splitByCount(){
        assertArrayEquals( arrayOf("123", "456"       ), "123456"    .split2(3) )
        assertArrayEquals( arrayOf("123", "456", "789"), "123456789" .split2(3) )
    }

}