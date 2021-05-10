package string;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int low1 = 0;
        int low2 = 0;
        int result = 0;
        while (low1 < v1.length && low2 < v2.length) {
            int t1 = Integer.parseInt(v1[low1]);
            int t2 = Integer.parseInt(v2[low2]);
            result = Integer.compare(t1, t2);
            if (result == 0) {
                low1++;
                low2++;
            } else {
                return result;
            }
        }

        if (result == 0) {
            if (low1 < v1.length) {
                while (low1 < v1.length) {
                    int t1 = Integer.parseInt(v1[low1]);
                    result = Integer.compare(t1, 0);
                    if (result == 0) {
                        low1++;
                    } else {
                        return result;
                    }
                }
            } else if (low2 < v2.length) {
                while (low2 < v2.length) {
                    int t2 = Integer.parseInt(v2[low2]);
                    result = Integer.compare(0, t2);
                    if (result == 0) {
                        low2++;
                    } else {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1"));
    }
}
