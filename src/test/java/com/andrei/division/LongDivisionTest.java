package com.andrei.division;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LongDivisionTest {

    @Test
    void calculationShouldReturnRightResult() {
        LongDivision longDivision = new LongDivision();
        int divider = 4;
        int dividend = 78945;
        int reminder = 1;
        List<Integer> listWithIndex = Arrays.asList(3, 2, 1, 2, 1);
        List<Integer> listWithMinuend = Arrays.asList(7, 38, 29, 14, 25);
        List<Integer> listWithSubtrahend = Arrays.asList(4, 36, 28, 12, 24);
        List<Integer> listWithDividend = Arrays.asList(7, 8, 9, 4, 5);

        Result expected = new Result(divider, dividend,
                listWithMinuend, listWithSubtrahend, listWithDividend, reminder, listWithIndex);
        Result actual = longDivision.calculation(dividend, divider);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void dividerBiggerThenDividend() {
        LongDivision longDivision = new LongDivision();
        int divider = 1234567;
        int dividend = 12345;
        int reminder = 12345;
        List<Integer> listWithIndex = Collections.singletonList(12345);
        List<Integer> listWithMinuend = Collections.singletonList(12345);
        List<Integer> listWithSubtrahend = Collections.singletonList(0);
        List<Integer> listWithDividend = Arrays.asList(1, 2, 3, 4, 5);
        Result expected = new Result(divider, dividend,
                listWithMinuend, listWithSubtrahend, listWithDividend, reminder, listWithIndex);
        Result actual = longDivision.calculation(dividend, divider);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void noBodyOnlyHead() {
        LongDivision longDivision = new LongDivision();
        int divider = 1234567;
        int dividend = 123456789;
        int reminder = 89;
        List<Integer> listWithIndex = Arrays.asList(0, 89);
        List<Integer> listWithMinuend = Arrays.asList(1234567, 89);
        List<Integer> listWithSubtrahend = Arrays.asList(1234567, 0);
        List<Integer> listWithDividend = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Result expected = new Result(divider, dividend,
                listWithMinuend, listWithSubtrahend, listWithDividend, reminder, listWithIndex);
        Result actual = longDivision.calculation(dividend, divider);
        Assertions.assertEquals(expected, actual);
    }

}
