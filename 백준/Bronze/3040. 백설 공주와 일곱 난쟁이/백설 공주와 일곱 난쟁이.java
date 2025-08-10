import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int total=0;
        int[] arr = new int[10];
        for(int i=0; i<9; i++){
            arr[i]= sc.nextInt();
            total+=arr[i];
        }
        int overnum = total-100;
        int tar1=0, tar2=0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int cur = arr[i]+arr[j];
                if(cur == overnum){
                    tar1 = i;
                    tar2 = j;
                    break;
                }
            }
            if(tar1!=0) break;
        }
        for(int i=0; i<9; i++){
            if(i!=tar1 && i!=tar2) System.out.println(arr[i]);
        }
    }
}