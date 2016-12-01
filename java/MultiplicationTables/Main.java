public class Main {
    final static int UPPER_BOUND = 12;

    public static void main(String[] args) {
        for(int i = 1; i <= UPPER_BOUND; i++) {
            System.out.println(createRow(i));
        }
    }

    static private String createRow(int rowNumber) {
        String row = "";

        for(int i = 1; i <= UPPER_BOUND; i++) {
            String newVal = Integer.toString(i * rowNumber);

            row += paddedNumber(newVal);

            if (i == UPPER_BOUND) {
                row += "\n";
            }
        }

        return row;
    }

    static private String paddedNumber(String number) {
        int digits = number.length();
        String padding = "";

        for (int i = 4; i > digits; i--) {
            padding += " ";
        }

        return padding + number;
    }
}
