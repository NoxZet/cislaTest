package cislatest;
    
import java.util.ArrayList;

/** Class Number ukládá jedno číslo a pracuje s ním */
public class Number {
    private int number;
    private ArrayList<Integer> primes = new ArrayList<Integer>();
    private boolean calculated;
    /**
     * @param number číslo
     */
    Number (int number)
    {
        this.number = number;
    }
    /** Rozdělí číslo na prvočísla pro vnitřní použití (ArrayList primes).
     *  Ošetřeno proti dvojitému použití.*/
    public void Split()
    {
        int limit;
        if (this.primes.isEmpty())
        {
            limit = this.number/2;
            for(Integer i = 1; i <= limit;)
            {
                if (this.number % i == 0)
                    this.primes.add(i);
                else
                    i++;
            }
            calculated = true;
        }
    }
    /** Zjistí, zda byl proveden rozklad na prvočísla
     * 
     * @return true pokud byl proveden rozklad
     */
    public boolean IsSplit()
    {
        return calculated;
    }
    /** Vyhodí vnitřní proměnnou primes s prvočísly
     * 
     * @return ArrayList s prvočísly, nebo prázdnou, pokud nebylo provedeno rozdělení (např. funkcí Split())
     */
    public ArrayList<Integer> Output()
    {
        return this.primes;
    }
}
