package cislatest;
    
import java.util.ArrayList;

/** Class Number ukládá jedno číslo a pracuje s ním */
public class Number {
    private int number;
    private ArrayList<Integer> primes = new ArrayList();
    private ArrayList<Integer> workList = new ArrayList();
    /**
     * @param number číslo, se kterým se bude pracovat
     */
    Number (int number)
    {
        this.number = number;
        Split();
        workList.addAll(primes);
    }
    /** Rozdělí číslo na prvočísla pro vnitřní použití (ArrayList primes).
     * Ošetřeno proti dvojitému použití.*/
    private void Split()
    {
        primes.clear();
        int worknum = number;
        if (number == 1) {primes.add(1);}
        for(Integer i = 2; i <= number;)
        {
            if (worknum % i == 0)
            {
                primes.add(i);
                worknum /= i;
            }
            else
                i++;
            if(i == 1){break;}
        }
    }
    /** Vyhodí číslo
     * 
     * @return číslo
     */
    public int getNumber()
    {
        return number;
    }
    /**
     * Resetuje pracovní ArrayList
     */
    public void resetWorkList()
    {
        workList.clear();
        workList.addAll(primes);
        //Collections.copy(workList, primes);        
    }
    /** Vyhodí vnitřní proměnnou primes s prvočísly
     * 
     * @return ArrayList s prvočísly, nebo prázdnou, pokud nebylo provedeno rozdělení (např. funkcí Split())
     */
    public ArrayList<Integer> getPrimes()
    {
        return primes;
    }
    /** Vyhodí pracovní ArrayList
     * 
     * @return ArrayList s prvočísly, nebo prázdnou, pokud nebylo provedeno rozdělení (např. funkcí Split())
     */
    public ArrayList<Integer> getWorkList()
    {
        return workList;
    }
    
}
