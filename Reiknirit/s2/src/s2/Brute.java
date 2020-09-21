package s2;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;


public class Brute {
    public static void main(String[] args) {
        /*
         * Do modify
         */
        In in = new In();
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        for(int p = 0; p < points.length; p++){

            for(int q = p+1; q < points.length; q++){
                double qslope = points[p].slopeTo(points[q]);

                for(int r = q+1; r < points.length; r++){
                    double rslope = points[p].slopeTo(points[r]);
                    if (qslope == rslope) {
                        for (int s = r + 1; s < points.length; s++) {
                            double sslope = points[p].slopeTo(points[s]);
                            if (qslope == sslope){
                                Point[] arr = {points[p], points[q], points[r], points[s]};
                                Arrays.sort(arr);
                                out.println("("+arr[0].x+", "+arr[0].y+") -> "+
                                            "("+arr[1].x+", "+arr[1].y+") -> "+
                                            "("+arr[2].x+", "+arr[2].y+") -> "+
                                            "("+arr[3].x+", "+arr[3].y+")");
                            }
                        }
                    }
                }
            }
        }
    }
}
