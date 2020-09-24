package s2;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;


public class Brute {

    private static void swap(Point[][] arr, int min, int s){
        Point[] temp_min = arr[min];
        arr[min] = arr[s];
        arr[s] = temp_min;
    }

    private static void print_sorted_array(Point[][] arr, int counter){
        for (int i = 0; i < counter; i++){
            int min = i;
            for(int j = i+1; j < counter; j++){
                int index_counter = 0;
                while(true){
                    int compare = arr[j][index_counter].compareTo(arr[min][index_counter]);
                    if(compare == -1){
                        min = j;
                        break;
                    }
                    else if(arr[j][index_counter].y == arr[min][index_counter].y){
                        index_counter++;
                    }
                    else{
                        break;
                    }
                }
            }
            swap(arr, min, i);
        }
        for (int i = 0; i < counter; i++){
            Point[] line = arr[i];
            new Out().println("("+line[0].x+", "+line[0].y+") -> "+
                        "("+line[1].x+", "+line[1].y+") -> "+
                        "("+line[2].x+", "+line[2].y+") -> "+
                        "("+line[3].x+", "+line[3].y+")");
        }
    }

    public static void main(String[] args) {
        In in = new In();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        Point[][] to_be_sorted_arr = new Point[n][];
        int line_counter = 0;
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
                                to_be_sorted_arr[line_counter] = arr;
                                line_counter += 1;
                            }
                        }
                    }
                }
            }
        }
        /*here we sort the lines dab*/
        print_sorted_array(to_be_sorted_arr, line_counter);
    }
}

