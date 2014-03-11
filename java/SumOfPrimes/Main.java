public class Main {

    public static void main(String[] args) {
        int count = 0;
        int total = 0;

        String primes = "";
        String nonPrimes = "";

        for (int i = 2; count < 1000; i++) {

            boolean notPrime = false;

            for (int j = 2; j < i; j++) {
                if (i % j == 0 && j != i) { 
                    notPrime = true;
                    break; 
                }
            }

            if (notPrime) { continue; }

            total = total + i;
            count++;
        }

        System.out.println(total);
    }
}

