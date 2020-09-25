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

    private static void print_sorted_array(Point[][] arr, int counter){
        Out out = new Out();
        for (int i = 0; i < counter; i++){
            int min = i;
            for(int j = i+1; j < counter; j++){
                int compare = arr[j][0].compareTo(arr[min][0]);
                if(compare == -1){
                    min = j;
                }
                else if(arr[j][0].y == arr[min][0].y && arr[j][0].x == arr[min][0].x ){
                    if (arr[min][0].slopeTo(arr[min][1]) > arr[j][0].slopeTo(arr[j][1])){
                        min = j;
                    }
                }
            }
            swap(arr, min, i);
        }
        for (int i = 0; i < counter; i++){
            Point[] line = arr[i];
            for (int j = 0; j < line.length; j++){
                if (j == line.length-1){
                    out.print("("+line[j].x+", "+line[j].y+")");
                }
                else{
                    out.print("("+line[j].x+", "+line[j].y+") -> ");
                }
            }
            out.println();
        }
    }

    private static void merge(Point slope, Point[] arr, int low, int mid, int high){
        Point [] larray = Arrays.copyOfRange(arr, low, mid+1);
        Point [] rarray = Arrays.copyOfRange(arr, mid+1, high+1);

        int l = 0;
        int h = 0;
        int i = low;
        while (l < larray.length && h < rarray.length){
            if (slope.slopeTo(larray[l]) > slope.slopeTo(rarray[h])){
                arr[i] = rarray[h];
                h++;
            }
            else{
                arr[i] = larray[l];
                l++;
            }
            i++;
        }
        while (l < larray.length){
            arr[i] = larray[l];
            l++;
            i++;
        }
        while (h < rarray.length){
            arr[i] = rarray[h];
            h++;
            i++;
        }
    }

    private static void merge_sort(Point slope, Point[] arr, int l, int h){
        if (l < h){
            int mid = l + (h-l)/2;
            merge_sort(slope, arr, l, mid);
            merge_sort(slope, arr, mid+1, h);
            merge(slope, arr, l, mid ,h);
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
        Out o = new Out();
        for(int p = 0; p < points.length; p++){
            Point [] temp = Arrays.copyOfRange(points, p+1, points.length);
            merge_sort(points[p], temp,0,temp.length-1);
            for (int i = 0; i < temp.length; i++){
                int x = i+1;
                while (true){
                    if (x >= temp.length){
                        break;
                    }
                    else if (points[p].slopeTo(temp[i]) != points[p].slopeTo(temp[x])){
                        break;
                    }
                    else{
                        x++;
                    }
                }
                if (x-i >= 3){
                    Point[] ar = new Point[x-i+1];
                    ar[0] = points[p];
                    for(int s = 0; s < x-i; s++){
                        if (ar.length-1 == s){
                            break;
                        }
                        ar[s+1] = temp[i+s];

                    }
                    Arrays.sort(ar);
                    to_be_sorted_arr[line_counter] = ar;
                    line_counter++;

                }
            }

        }
        /*dab*/
        print_sorted_array(to_be_sorted_arr, line_counter);
    }
}
