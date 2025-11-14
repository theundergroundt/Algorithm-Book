import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int Y = 2024;
        int M = 8 + ((N - 1) * 7);

        int m = (M - 1) % 12 + 1;
        int y = Y + (M - 1) / 12;

        System.out.println(y + " " + m);
    }
}
