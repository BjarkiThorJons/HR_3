package s2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Arrays;

public class Fast {
    private static void swap(Point[][] arr, int min, int s){
        Point[] temp_min = arr[min];
        arr[min] = arr[s];
        arr[s] = temp_min;
    }

    private static void merge(Point[] arr, int low, int mid, int high){
        
    }

    private static void merge_sort(Point[] arr, int l, int h){
        if (l < h){
            int mid = l + (h-l)/2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid+1, h);
            merge(arr, l, mid ,h);
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
            Point[] arrr = new Point[n];

        }
        /*dab*/
        print_sorted_array(to_be_sorted_arr, line_counter);
    }
}
