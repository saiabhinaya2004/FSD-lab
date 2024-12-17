/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

/**
 *
 * @author dell
 */

public class FactorialBean {
    private Long number;  // Use Long (wrapper class) instead of primitive long

    // Getter that calculates the factorial
    public long getNumber() {
        long factorial = 1;
        if (number != null) {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }

    // Setter for the number (now accepts Long instead of long)
    public void setNumber(Long number) {
        this.number = number;
    }
}
