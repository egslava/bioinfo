package ru.egslava.bio.genes;

/**
 * Created by egslava on 15/09/16.
 */
public class ReverseComplementTest {

    public static String reverseComplement12(String s){
        int lengthM1 = s.length() - 1;
        int length = s.length();
        char[] chars = new char[length ];
        for (int i = 0; i < length; i++){
            chars[i] = StringUtilsKt.getComplement1( s.charAt(lengthM1 - i) );
        }
        return new String( chars );
    }

    public static String reverseComplement13(String s){
        int lengthM1 = s.length() - 1;
        int length = s.length();
        char[] chars = new char[length ];
        for (int i = 0; i < length; i++){
            char complementedChar = StringUtilsKt.getComplement1(s.charAt(lengthM1 - i));

            if (complementedChar != '-') {
                chars[i] = complementedChar;
            } else throw new RuntimeException("${thisLength - 1} can not be in DNA");
        }
        return new String( chars );
    }


}
