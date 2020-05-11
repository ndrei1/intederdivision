package com.andrei.division;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {
    private final int divider;
    private final int dividend;
    private final List<Integer> minuend;
    private final List<Integer> subtract;
    private final List<Integer> dividendList;
    private final int reminder;
    private final List<Integer> listWithIndex;


    public Result(int divider, int dividend, List<Integer> minuend, List<Integer> subtract, List<Integer> dividendList, int reminder, List<Integer> listWithIndex) {
        this.divider = divider;
        this.dividend = dividend;
        this.minuend = Collections.unmodifiableList(minuend);
        this.subtract = Collections.unmodifiableList(subtract);
        this.dividendList = Collections.unmodifiableList(dividendList);
        this.reminder = reminder;
        this.listWithIndex = Collections.unmodifiableList(listWithIndex);
    }

    public int getDivider() {
        return divider;
    }

    public int getDividend() {
        return dividend;
    }

    public List<Integer> getMinuend() {
        return minuend;
    }

    public List<Integer> getSubtract() {
        return subtract;
    }

    public List<Integer> getDividendList() {
        return dividendList;
    }

    public int getReminder() {
        return reminder;
    }

    public List<Integer> getListWithIndex() {
        return listWithIndex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return divider == result.divider &&
                dividend == result.dividend &&
                reminder == result.reminder &&
                minuend.equals(result.minuend) &&
                subtract.equals(result.subtract) &&
                dividendList.equals(result.dividendList) &&
                listWithIndex.equals(result.listWithIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divider, dividend, minuend, subtract, dividendList, reminder, listWithIndex);
    }
}
