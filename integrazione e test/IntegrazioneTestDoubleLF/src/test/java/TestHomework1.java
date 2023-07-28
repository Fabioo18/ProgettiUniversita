
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import org.example.Homework1;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class TestHomework1
{
    //T1 e T2
    @Test
    @DisplayName("arrIsNullorEmpty")
    void arrIsNullorEmpty()
    {
        assertNull(Homework1.mergeSort(null, new int[]{1}, new int[]{2,3}));
        assertArrayEquals(new int[]{}, Homework1.mergeSort(new int[]{}, new int[]{}, new int[]{}));
    }

    //T3 e T4
    @Test
    @DisplayName("lIsNullorEmpty")
    void lIsNullorEmpty()
    {
        assertNull(Homework1.mergeSort(new int[]{3,5,7}, null, new int[]{5,7}));
        assertArrayEquals(new int[]{3,5,7}, Homework1.mergeSort(new int[]{3,5,7}, new int[]{}, new int[]{5,7}));
    }

    //T5 e T6
    @Test
    @DisplayName("rIsNullorEmpty")
    void rIsNullorEmpty()
    {
        assertNull(Homework1.mergeSort(new int[]{3,5,7}, new int[]{3}, null));
        assertArrayEquals(new int[]{3,5,7}, Homework1.mergeSort(new int[]{3,5,7}, new int[]{}, new int[]{}));
    }

    //T7
    @Test
    @DisplayName("lIsMajorr")
    void lIsMajorr()
    {
        assertArrayEquals(new int[]{3,5,7}, Homework1.mergeSort(new int[]{3,5,7}, new int[]{3}, new int[]{}));
    }

    //Boundary tests T8,79,T10,T11
    @ParameterizedTest
    @MethodSource("intArrayProvider")
    @DisplayName("arrOfLengthEqual1")
    void arrOfLengthEqual1(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr, Homework1.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider()
    {
        return Stream.of(
                arguments(new int[]{2}, new int[]{}, new int[]{2}),//T8
                arguments(new int[]{2}, new int[]{0}, new int[]{2}), //T9
                arguments(new int[]{1000}, new int[]{}, new int[]{1001}), //T10
                arguments(new int[]{1000}, new int[]{0}, new int[]{1001}));// T11
    }

    //T12,T13
    @ParameterizedTest
    @MethodSource("intArrayProvider2")
    @DisplayName("arrOfLengthMajorThan1")
    void arrOfLengthMajorThan1(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr, Homework1.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider2()
    {
        return Stream.of(
                arguments(new int[]{4,5,10,7,1,2}, new int[]{4,5,10}, new int[]{7,1,2}),//T12
                arguments(new int[]{4,5,10,7,1,2,6}, new int[]{4,5,10}, new int[]{7,1,2,6}));//T13

    }

    //T14,T15,T16,T17,T18,T19,T20,T21,T22
    @ParameterizedTest
    @MethodSource("intArrayProvider4")
    @DisplayName("AugmentedTests")
    void AugmentedTests(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr, Homework1.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider4()
    {
        return Stream.of(
                arguments(new int[]{1,5,10,27,30,35}, new int[]{1,5,10}, new int[]{27,30,35}),//T14
                arguments(new int[]{35,5,10,27,30}, new int[]{35,5}, new int[]{10,27,30}),//T15
                arguments(new int[]{-1,25,-100,-270,3000,15}, new int[]{-1,25,-100}, new int[]{-270,3000,15}),//T16
                arguments(new int[]{-1000,-10,-2034,-1,-30}, new int[]{-1000,-10}, new int[]{-2034,-1,-30}),//T17
                arguments(new int[]{1,5,10,5,30,40}, new int[]{1,5,10}, new int[]{5,30,40}),//T18
                arguments(new int[]{40,35,20,4,0}, new int[]{40,35}, new int[]{20,4,0}),//T19
                arguments(new int[]{Integer.MAX_VALUE,5,10}, new int[]{Integer.MAX_VALUE}, new int[]{5,10}),//T20
                arguments(new int[]{Integer.MIN_VALUE,5,10}, new int[]{Integer.MIN_VALUE}, new int[]{5,10}),//T21
                arguments(new int[]{Integer.MIN_VALUE,5,Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE}, new int[]{5,Integer.MAX_VALUE}));//T22
    }

}
