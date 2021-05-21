package math;

public class RectangleArea {

    /*1, To know whether the two areas are not overlapped:

    We actually only need to consider four situations: B>=H or E>=C or F>=D or A>=G. For example, if B is larger than H, the area (A,B,C,D) is definitely not overlapped with area (E,F,G,H), and we even know that area (A,B,C,D) is on the upper area of the plot compared with area (E,F,G,H). You can also check if other situations work.
    2. To calculate the overlapped area:

    When the two areas are overlapped, we only need to know the bottom left corner and top right corner of the overlapped area:
    the larger one of A and E, the larger one of B and F, the smaller one of C and G, and the smaller one of D and H.
    For example, in the case of the given figure of the original problem,
    we just consider the point (E,B) and the point (C,H), and the overlapped area is (E,B,C,H) which could be calculated intuitively.
    So how about other kinds of overlapping? The formula given above never change! You can try imagining other kind of overlapped area,
    you will see that in any case we only need to know max(A,E), max(B,F), min(C,G), and min(D,H) to calculate the overlapped area.*/

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        if (A >= G || B >= H || C <= E || D <= F) {
            return areaA + areaB;
        }

        int overlapWidth = Math.min(C, G) - (Math.max(A, E));
        int overlapHeight = Math.min(D, H) - Math.max(B, F);

        int areaO = Math.abs(overlapWidth) * Math.abs(overlapHeight);
        return areaA + areaB - areaO;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
