package com.andrei.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTest {

    @Test
    void printCorrectLongDivision() {
        Printer printer = new Printer();
        LongDivision longDivision = new LongDivision();
        Result result = longDivision.calculation(78945, 4);
        String actual = printer.printLongDivision(result);
        String expected =
                        "_78945|4\n" +
                        " 4    |-----\n" +
                        " -    |19736\n" +
                        "_38\n" +
                        " 36\n" +
                        " --\n" +
                        " _29\n" +
                        "  28\n" +
                        "  --\n" +
                        "  _14\n" +
                        "   12\n" +
                        "   --\n" +
                        "   _25\n" +
                        "    24\n" +
                        "    --\n" +
                        "     1";
        assertEquals(expected, actual);
    }

    @Test
    void printCorrectLongDivisionIfDividerBiggerThanDividend() {
        Printer printer = new Printer();
        LongDivision longDivision = new LongDivision();
        Result result = longDivision.calculation(1234567, 123456789);
        String actual = printer.printLongDivision(result);
        String expected =
                "1234567|123456789\n" +
                        "      0|-\n" +
                        "-------|0\n" +
                        "1234567";
        assertEquals(expected, actual);

    }

    @Test
    void printCorrectLongDivisionIfResultIsOnlyHead() {
        Printer printer = new Printer();
        LongDivision longDivision = new LongDivision();
        Result result = longDivision.calculation(123456789, 1234567);
        String actual = printer.printLongDivision(result);
        String expected =
                "_123456789|1234567\n" +
                        " 1234567  |---\n" +
                        " -------  |100\n" +
                        "        89";
        assertEquals(expected, actual);
    }

    @Test
    void printCorrectLongDivisionIfDividendApproximateNumber() {
        Printer printer = new Printer();
        LongDivision longDivision = new LongDivision();
        Result result = longDivision.calculation(-123, 1);
        String actual = printer.printLongDivision(result);
        String expected =
                        "_123|1\n" +
                        " 1  |----\n" +
                        " -  |-123\n" +
                        " _2\n" +
                        "  2\n" +
                        "  -\n" +
                        "  _3\n" +
                        "   3\n" +
                        "   -\n" +
                        "   0";
        assertEquals(expected, actual);
    }

    @Test
    void printCorrectLongDivisionIfDividerApproximateNumber() {
        Printer printer = new Printer();
        LongDivision longDivision = new LongDivision();
        Result result = longDivision.calculation(1234, -34);
        String actual = printer.printLongDivision(result);
        String expected =

                        "_1234|-34\n" +
                        " 102 |---\n" +
                        " --- |-36\n" +
                        " _214\n" +
                        "  204\n" +
                        "  ---\n" +
                        "   10";
        assertEquals(expected, actual);
    }
}
