/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislatest;

/**
 *
 * @author Lenny
 */
public class CislaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyInput aloneClass = new MyInput();
        NumberGroup grupa = new NumberGroup (aloneClass.getArrayNumbers(), aloneClass.getNObjects());
        aloneClass.printResult(grupa.calculate(false), false);
        aloneClass.printResult(grupa.calculate(true), true);
    }
    
}
