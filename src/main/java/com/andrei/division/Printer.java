package com.andrei.division;

public class Printer {

    private String symbolWrite(String symbol, int quantityOfSymbol) {
        StringBuilder stringOfSymbol = new StringBuilder();
        for (int i = 0; i < quantityOfSymbol; i++) {
            stringOfSymbol.append(symbol);
        }
        return stringOfSymbol.toString();
    }

    private String printReminder(Result result) {
        StringBuilder reminder = new StringBuilder();
        int dividentPlus = result.getDividend();
        if (dividentPlus < 0) {
            dividentPlus = dividentPlus * -1;

        }

        if ((int) Math.log10(result.getReminder()) < 0) {
            reminder.append("\n").append(symbolWrite(" ", (int) Math.log10(dividentPlus) + 1)).append("0");
            return reminder.toString();
        }
        reminder.append("\n").append(symbolWrite(" ", (int) Math.log10(dividentPlus) + 1
                - (int) Math.log10(result.getReminder()))).append(result.getReminder());


        return reminder.toString();
    }

    public String printLongDivision(Result result) {
        String longDivision = printHead(result);
        int dividentPlus = result.getDividend();
        if (dividentPlus < 0) {
            dividentPlus = dividentPlus * -1;

        }

        double quantityOfNumberInDividend = Math.log10(dividentPlus);
        double quantityOfNumberInDivider = Math.log10(result.getDivider());
        if (quantityOfNumberInDividend / 2 < quantityOfNumberInDivider || result.getDivider() > dividentPlus) {
            return longDivision;
        }

        longDivision += printBody(result);
        longDivision += printReminder(result);
        return longDivision;
    }

    private String printBody(Result result) {
        StringBuilder body = new StringBuilder();
        int steps = (int) Math.log10(result.getMinuend().get(0)) - (int) Math.log10(result.getListWithIndex().get(0));
        if (steps < 0) {
            steps = (int)Math.log10(result.getMinuend().get(0))+1;
        }
        if (Math.log10(result.getDivider()) <= 0) {
            int dividerCheck = result.getDivider();
            dividerCheck = dividerCheck * -1;
            steps = (int) Math.log10(result.getMinuend().get(0)) - (int) Math.log10(result.getListWithIndex().get(0));
            if (Math.log10(dividerCheck) >= 0) {
                steps =  (int) Math.log10(result.getMinuend().get(0)) - (int) Math.log10(result.getListWithIndex().get(0));
            }
        }
        if (result.getDividend() == result.getMinuend().get(0) || result.getDividend() * -1 == result.getMinuend().get(0)) {
            return "";
        }
        if(result.getDivider()==1||result.getDivider()==-1){
            steps=1;
        }


        int i = 1;
        while (result.getSubtract().get(i) >= result.getDivider()) {
            body.append("\n").append(symbolWrite(" ", steps)).append("_").append(result.getMinuend().get(i));
            body.append("\n").append(symbolWrite(" ", steps + 1)).append(result.getSubtract().get(i));
            body.append("\n").append(symbolWrite(" ", steps + 1)).append(symbolWrite("-", (int) Math.log10(result.getSubtract().get(i)) + 1));
            if ((int)Math.log10(result.getMinuend().get(i))==0||result.getDivider()==1||result.getDivider()==-1) {
                steps++;
            } else
                {
                steps += (int) Math.log10(result.getMinuend().get(i)) - (int) Math.log10(result.getListWithIndex().get(i));
            }

            if (i == result.getListWithIndex().size() - 1) {
                break;
            }

            i++;
        }
        return body.toString();
    }

    private String printHead(Result result) {
        StringBuilder head = new StringBuilder();
        int dividendPlus = result.getDividend();
        if (result.getDividend() < 0) {
            dividendPlus = dividendPlus * -1;
        }
        if (result.getDivider() > dividendPlus) {
            head.append(result.getDividend()).append("|").append(result.getDivider()).append("\n");
            head.append(symbolWrite(" ", (int) Math.log10(dividendPlus))).append("0").append("|").append("-").append("\n");
            head.append(symbolWrite("-", (int) Math.log10(dividendPlus) + 1)).append("|").append("0").append("\n");
            head.append(result.getDividend());
            return head.toString();

        }
        double quantityOfNumberInDividend = Math.log10(dividendPlus);
        double quantityOfNumberInDivide = Math.log10(result.getDivider());
        int quantityOfSpace = (int) Math.log10(dividendPlus) -
                (int) Math.log10(result.getSubtract().get(0));
        int resultOfDivision = dividendPlus / result.getDivider();
        String slash;
        if (result.getDivider() < 0) {
            slash = symbolWrite("-", (int) Math.log10(resultOfDivision * -1) + 2);
        } else {
            slash = symbolWrite("-", (int) Math.log10(resultOfDivision) + 1);
        }
        int quantityOfSlashUnder = (int) Math.log10(result.getSubtract().get(0)) + 1;
        String slashUnder = symbolWrite("-", quantityOfSlashUnder);
        int quantityOfSpaceFromSlash = (int) Math.log10(dividendPlus) - quantityOfSlashUnder;


        head.append("_").append(dividendPlus).append("|").append(result.getDivider()).append("\n");
        int spaceFromSubtract = (int) Math.log10(result.getMinuend().get(0)) - (int) Math.log10(result.getSubtract().get(0));

        String SpaceFromSlash = symbolWrite(" ", quantityOfSpaceFromSlash + 1 - spaceFromSubtract);
        String Space = symbolWrite(" ", quantityOfSpace - spaceFromSubtract);
        if (result.getDividend() < 0) {
            slash += "-";
        }
        head.append(symbolWrite(" ", spaceFromSubtract + 1)).append(result.getSubtract().get(0)).append(Space).append("|").append(slash).append("\n");
        if (result.getDividend() < 0) {
            resultOfDivision = resultOfDivision * -1;
        }
        head.append(symbolWrite(" ", spaceFromSubtract + 1)).append(slashUnder).append(SpaceFromSlash).append("|").append(resultOfDivision);
        if (quantityOfNumberInDividend / 2 < quantityOfNumberInDivide) {
            int reminder = dividendPlus % result.getDivider();
            if (result.getDividend() < 0) {
                reminder = reminder * -1;
                int spaceFromReminder = (int) Math.log10(dividendPlus) - (int) Math.log10(dividendPlus % result.getDivider()) + 1;
                head.append("\n").append(symbolWrite(" ", spaceFromReminder)).append(reminder);
                return head.toString();
            }
            if (reminder == 0) {
                head.append("\n").append(symbolWrite(" ", (int) Math.log10(dividendPlus) + 1)).append(reminder);
                return head.toString();
            }
            int spaceFromReminder = (int) Math.log10(dividendPlus) - (int) Math.log10(reminder) + 1;
            head.append("\n").append(symbolWrite(" ", spaceFromReminder)).append(reminder);

        }
        return head.toString();
    }
}
