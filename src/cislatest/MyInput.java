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
    Number[] arrayNumbers;
    
    MyInput()
    {
    toObjects(askEverything ());
    }
    
    public Number[] getArrayNumbers()
    {
    return arrayNumbers;
    }
    
    
    
    
    
    private void toObjects (int[] values)
    {
        arrayNumbers = new Number[values.length];
        for (int i = 0; i < values.length; i++)
        {
            arrayNumbers[i] = new Number(values[i]);
        }
    }
    
    
    /** Zeptá se uživalete na počet čísel a poté jejich hodnoty
     * 
     * @return navrátí pole s hodnotami čísel
     */
    private int[] askEverything ()
        {
            int numberOf = onlyNatural("U kolika čísel hledáš nejmenší společný jmenovatel: ");
            System.out.println("Postupně vkládej čísla");
            int[] values = new int[numberOf];
            for (int i = 0; i < numberOf; i++)
                {
                    values[i] = onlyNatural((i+1) + ". číslo: ");
                }
            
            return values;
        }
    
    /** Zkontroluje, zde je vstup přirozené číslo
     * @param String, který se ptá
     * @return navrátí vždy kladné celé číslo
     */
    private int onlyNatural (String entered)
    {
        int result = -1;
        String helpString = "";
        boolean contin = true;
        boolean missed = false;
        System.out.print(entered);
        while (contin)
        {
            try
            {
                helpString = sc.nextLine();
                result = Integer.parseInt(helpString);
                if (result < 1){int breakIt = Integer.parseInt("s");}
                    else {contin = false;};

            }
            catch (Exception e)
            {
            System.out.print(helpString + " není přirozené číslo, zkus to znovu: ");
            missed = true;
            }
        }
        if (missed){System.out.println(entered + result);}
        
        return result;
    }
    
}


