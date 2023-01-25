package LazyEvaluationAndCache;

public class LazyNumbersDetails {

    // Campul obiectului
    private int number;
    private boolean primeCache;
    private int primeCacheCounter;
    private boolean perfectCache;
    private int perfectCacheCounter;
    private boolean magicCache;
    private int magicCacheCounter;


    // Starea obiectului
    public LazyNumbersDetails (int number) { // Constructor pentru initializarea campului "number"
        this.number = number;
    }

    public void updateNumber (int number) {  // Metoda pentru a putea actualiza valoarea campului "number"
        this.number = number;
        this.primeCacheCounter = 0;
        this.perfectCacheCounter = 0;
        this.magicCacheCounter = 0;
    }

    public boolean isPrime (int number) {  // Metoda pentru a verifica daca "number" este prim
        if (primeCacheCounter == 0) {
            return isPrimeAlgorithm(number);
        } else {
            return primeNumberCache();
        }
    }

    private boolean isPrimeAlgorithm(int number) { // Algoritm pentru calcularea numarului prim
        for (int i = 2; i < number / 2; i++) {
                if (number % i == 0) {
                    primeCacheCounter = 1;
                    primeCache = false;
                    return false;
                }
            }
        primeCacheCounter = 1;
        primeCache = true;
        return true;
    }

    private boolean primeNumberCache () {  // Cache pentru metoda "isPrime"
        cacheText();
        return this.primeCache;
    }

    public boolean isPerfect (int number) {  // Metoda pentru a verifica daca "number" este perfect
        if (perfectCacheCounter == 0) {
            return isPerfectAlgorithm(number);
        } else {
            return perfectNumberCache();
        }
    }

    private boolean isPerfectAlgorithm(int number) {
        int perfectSum = 0;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                perfectSum += i;
            }
        }
        if (number == perfectSum + 1) {
            perfectCacheCounter = 1;
            perfectCache = true;
            return true;
        }
        perfectCacheCounter = 1;
        perfectCache = false;
        return false;
    }

    private boolean perfectNumberCache () {  // Cache pentru metoda "isPerfect"
        cacheText();
        return this.perfectCache;
    }

    public boolean isMagic (int number) {  // Metoda pentru a verifica daca "number" este magic
        if (magicCacheCounter == 0) {
            return isMagicAlgorithm(number);
        } else {
            return magicNumberCache();
        }
    }

    private boolean isMagicAlgorithm(int number) {
        int oneDigitNumber = magicNumber(number);

        if (oneDigitNumber == 3 || oneDigitNumber == 7 || oneDigitNumber == 9) {
            magicCacheCounter = 1;
            magicCache = true;
            return true;
        }
        magicCacheCounter = 1;
        magicCache = false;
        return false;
    }

    private int magicNumber (int number) {  // Metoda face suma cifrelor lui "oneDigitNumber"
        int sum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;

            number /= 10;
        }
        if (sum >= 10) {
            sum = magicNumber(sum);
        }
        return sum;
    }

    public boolean magicNumberCache () {  // Cache pentru metoda "isMagic"
        cacheText();
        return this.magicCache;
    }

    private void cacheText () {  // Text descriptiv pentru a arata ca rezultatul a fost stocat in cache.
        System.out.println("Rezultatul a fost accesat din cache.");
    }

    public int getNumber() {
        return number;
    }
}
