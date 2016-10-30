/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislatest;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Honza
 */
public class MyInput 
{
    /** Pro funkčnost vstupu */
    Scanner sc = new Scanner (System.in, "Windows-1250");
    /** List čísel, naplní se podle vstupu od uživatele */
    Number[] arrayNumbers;
    
    /** Konstruktor, vytvoří rovnou pole objektů Number */
    MyInput()
    {
    toObjects(askEverything ());
    }
    
    /** getter na ukazatel do pole objektů Number */
    public Number[] getArrayNumbers()
    {
    return arrayNumbers;
    }
    
    public int getNObjects()
    {
    return arrayNumbers.length;
    }
    
    
    /** Metoda, která dostane pole hodnot a vytvoří z nich objekty Number */
    private void toObjects (int[] values)
    {
        //určí délku pole objetů Number
        arrayNumbers = new Number[values.length];
        for (int i = 0; i < values.length; i++)
        {
            //postupně dosazuje hodnoty
            arrayNumbers[i] = new Number(values[i]);
        }
    }
    
    public void printResult (ArrayList<Integer> list, boolean lower)
    {
        int totalResult = 1;
        String postup;
        for (int i : list)
        {
            totalResult *= i;
            System.out.println(i);
        }
        
        if(lower)
        {System.out.println("Největší společný dělitel je " + totalResult);}
        else {System.out.println("Nejmenší společný násobek je " + totalResult);}
        
        
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
        // Výsledné číslo 
        int result = -1;
        // Pomocný String, pro případ, že uživatel zadá špatný vstup, tak vstup vypíše
        String helpString = "";
        // True, dokud uživatel nezadá správný vstup
        boolean contin = true;
        while (contin)
        {
            try
            {
                System.out.print(entered);
                helpString = sc.nextLine();
                result = Integer.parseInt(helpString);
                // vyhodí program do catch, pokud je číslo menší než jedna, jinak zajistí výstup ze smyčky
                if (result < 1){int breakIt = Integer.parseInt("s");}
                    else {contin = false;};

            }
            catch (Exception e)
            {
            System.out.println(helpString + " není přirozené číslo");
            }
        }
        
        return result;
    }
    
}


