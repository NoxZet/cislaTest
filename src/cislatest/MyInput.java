/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislatest;
import java.util.Scanner;
/**
 *
 * @author Honza
 */
public class MyInput 
{
    Scanner sc = new Scanner (System.in, "Windows-1250");
    
    MyInput()
    {
    askEverything ();
    }
    
    
    
    
    
    
    
    private void askEverything ()
        {
            int numberOf = onlyNatural("U kolika čísel hledáš nejmenší společný jmenovatel: ");
            System.out.println("Postupně vkládej čísla");
            int[] values = new int[numberOf];
            for (int i = 0; i < numberOf; i++)
                {
                    values[i] = onlyNatural((i+1) + ". číslo: ");
                }
            
            
        }
    
    /** Zkontroluje, zde je vstup přirozené číslo
     * 
     * @return ArrayList s prvočísly, nebo prázdnou, pokud nebylo provedeno rozdělení (např. funkcí Split())
     */
    private int onlyNatural (String entered)
    {
        int result = -1;
        boolean contin = true;
        boolean missed = false;
        System.out.print(entered);
        while (contin)
        {
            try
            {
                result = Integer.parseInt(sc.nextLine());
                if (result < 1){int breakIt = Integer.parseInt("s");}
                    else {contin = false;};

            }
            catch (Exception e)
            {
            System.out.println(result + " není přirozené číslo!");
            missed = true;
            }
        }
        if (missed){System.out.println(entered + result);}
        
        return result;
    }
    
}


