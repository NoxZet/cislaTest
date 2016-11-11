/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislatest;

import java.util.ArrayList;
/** Skupina objektů Number (absolutní maximum 1024) */
public class NumberGroup {
    int count;
    Number[] nums;
    NumberGroup(Number[] numbers, int count) {
        this.count = count;
        nums = numbers;
    }
    /** Zjistí nejvyšší výskyt jednoho daného prvočísla v ArrayListech všech čísel
     * 
     * @param low Pokud je true, zjistí nejnižší počet
     * @param num Číslo, které se hledá (musí být nejnižší v pracovním ArrayListu)
     * @return počet
     */
    private int nextCount(int num, boolean low)
    {
        ArrayList<Integer> workList;
        int[] numCount = new int[count];
        int i, size, local, total;
        if (low)
            total = -1; // Udává nejvyšší/nejnižší počet prvočísel
        else
            total = 0;
        for(i = 0; i < count; i++)
        {
            workList = nums[i].getWorkList(); // Kopie ArrayListu čísla, ze kterého se umazávají již sečtená prvočísla
            size = workList.size(); // Počet všech prvočísel v čísle
            if (size>0)
            {
                local = 0; // Udává počet prvočísel v jednom čísle
                while(local < size)
                {
                    if (workList.get(0)==num)
                    {
                        local++;
                        workList.remove(0);
                    }
                    else
                        break;
                }
                if (low)
                {
                    if (total==-1 || local<total)
                        total=local;
                }
                else
                {
                    if (local>total)
                        total=local;
                }
            }
            else if (low)
                total = 0;
        }
        return total;
    }
    /** Zjistí nejnižší číslo ze všech pracovních ArrayListů
     * 
     * @return nejnižší číslo
     */
    private int lowestNumber()
    {
        ArrayList<Integer> workList;
        int i, local; // local - udává nejnižší prvočíslo v právě prohledávaném čísle
        int total = -1;
        for(i = 0; i < count; i++)
        {
            workList = nums[i].getWorkList();
            if (!workList.isEmpty())
            {
                local = workList.get(0);
                if (total==-1 || local<total)
                    total = local;
            }
        }
        return total;
    }
    /** Spočítá společné čitatele čísel ve skupině
     * 
     * @param low Pokud je true, zjistí nejvyššího dělitele
     * @return ArrayList s prvočísly
     */
    public ArrayList<Integer> calculate(boolean low)
    {
        ArrayList<Integer> result = new ArrayList();
        int check, num;
        boolean loop = true;
        while (loop)
        {
            check = lowestNumber();
            if (check>0)
            {
                num = nextCount(check, low);
                for(int i = 0; i<num; i++)
                    result.add(check); // edit
            }
            else
                loop = false;
        }
        for(int i=0; i<count; i++)
            nums[i].resetWorkList();
        return result;
    }
    
    
}
