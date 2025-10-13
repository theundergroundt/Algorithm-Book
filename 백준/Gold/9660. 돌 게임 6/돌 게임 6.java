import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 메모이제이션 하기에는 너무 큰 범위 
		long n = Long.parseLong(br.readLine());
		if(n%7 == 0||n%7 == 2) System.out.println("CY");
		else System.out.println("SK");
	}
}