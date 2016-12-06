import java.math.BigDecimal;
import java.util.Arrays;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;


public class main {
    public static void main(String[] args) {
        System.out.println("hello world");
        BigDecimal top = new BigDecimal(args[0]);
        String[] prime_str;
        try {
            List<String> input = Files.readAllLines(Paths.get("clean_primes.txt"));
            prime_str = input.get(0).split(",");
        }
        catch (IOException e) {
            System.out.println("error");
            return;
        }

        Integer[] primes = new Integer[prime_str.length];
        for (int i=0 ; i<prime_str.length ; i++) {
            primes[i] = Integer.parseInt(prime_str[i]);
        }

        String[] progress = new String[] {"|","/","-","\'"};

        // compute all 3 combos less than 100
        long count = 0;
        BigDecimal prev = new BigDecimal(0);
// x=1, y=1, z=1    
        for (int i=0 ; i<primes.length ; i++) {
            BigDecimal num1 = new BigDecimal(primes[i]);

            for (int j=i+1 ; j<primes.length ; j++) {
                BigDecimal num2 = new BigDecimal(primes[j]);

                if (num1.multiply(num2).compareTo(top) == 1) {
                    break;
                }

                for (int k=j+1 ; k<primes.length ; k++) {
System.out.print("\r"+ count + " " + progress[k % 4]);
                    BigDecimal num3 = new BigDecimal(primes[k]);

                    if (num1.multiply(num2).multiply(num3).compareTo(top) < 1) {
                        count++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
// x=3, y=1, z=0
        for (int i=0 ; i<primes.length ; i++) {

            BigDecimal num1 = new BigDecimal(primes[i]);
            num1 = num1.pow(3);

            for (int j=0 ; j<primes.length ; j++) {

                if (i == j)
                    continue;
System.out.print("\r"+ count + " " + progress[i % 4]);
                BigDecimal num2 = new BigDecimal(primes[j]);
                if (num1.multiply(num2).compareTo(top) < 1) {
                        count++;
                }
                else{
                   break;
                }
            }
        }
// x=7, y=0, z=0
        for (int i=0 ; i<primes.length ; i++) {
            BigDecimal num1 = new BigDecimal(primes[i]);
            num1 = num1.pow(7);
System.out.print("\r"+ count + " " + progress[i % 4]);
            if (num1.compareTo(top) == 1)
                    break;
            else if (num1.compareTo(top) <= 0) {
                count++;
                //System.out.println(primes[i] + " to the 7");
            }
        }
        System.out.println("count: " + count);
    }

}