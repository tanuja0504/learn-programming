package array;

public class ExcelSheetColumn {
    public static int titleToNumber(String columnTitle) {
        int high = columnTitle.length();
        int len = columnTitle.length() - 1;
        int result = 0;
        while (high > 0) {
            high--;
            int temp = columnTitle.charAt(high);
            result = result + ((int) (Math.pow(26, len - high)) * (temp - 64));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("BB"));
    }
}
