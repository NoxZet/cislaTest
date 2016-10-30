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
    /** Zjistí nejvyšší výskyt daného prvočísla v ArrayListech čísel
     * 
     * @param low Pokud je true, zjistí nejnižší počet
     * @param num Číslo, které se hledá (musí být nejnižší v pracovním ArrayListu)
     * @return počet
     */
    private int nextCount(int num, boolean low)
    {
        ArrayList<Integer> workList;
        int[] numCount = new int[count];
        int i, e, size, local, total;
        if (low)
            total = -1;
        else
            total = 0;
        for(i = 0; i < count; i++)
        {
            e = 0;
            local = 0;
            workList = nums[i].getWorkList();
            size = workList.size();
            if (size>0)
            {
                while(e < size)
                {
                    if (workList.get(0)==num)
                    {
                        e++;
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
        }
        return total;
    }
    private int lowestNumber()
    {
        ArrayList<Integer> workList;
        int i, local;
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
                    result.add(num);
            }
            else
                loop = false;
        }
        return result;
    }
}
