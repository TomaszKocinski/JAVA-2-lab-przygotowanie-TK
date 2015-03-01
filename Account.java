/*
 Napisz klasę reprezentującą konto oszczędnościowe, na które można wpłacać i z którego można wypłacać pieniądze. 
 Konto powinno mieć swój numer (numer konta powinien być liczbą całkowitą większą niż 10000). 
 Numery kont powinny być unikalne w skali globalnej (każde nowoutworzone konto powinno mieć unikalny numer). 
 Do klasy dopisz konstruktory domyślny i argumentowy.
 Do klasy dodaj metodę naliczania odsetek (w zależności od ilości dni, które upłynęły - argument metody) i oprocentowania (atrybut konta).
 */
package przygotowaniedolab2;

 //@author Kot
 
public class Account {

    private Integer integer, decimal;
    static private int numberOfAccountStatic = 10001;
    private final int numberOfAccount = numberOfAccountStatic++;

    Account() {
        integer = 0;
        decimal = 0;
//    numberOfAccount=numberOfAccountStatic++;
    }

    Account(int arg_int, int arg_dec) {

        integer = arg_int;
        decimal = arg_dec;
        conversionOfDecimal();
    }

    int get_number() {
        return this.numberOfAccount;
    }

    String get_stringMoney() {
        if (this.decimal == 0) {
            return this.integer.toString();
        }
        if (decimal >= 10) {
            return this.integer.toString() + ',' + this.decimal.toString();
        }
        return this.integer.toString() + "," + this.decimal.toString();
    }

    void conversionOfDecimal() {
        while (decimal >= 100) {
            decimal = decimal - 100;
            integer++;
        }
        while (decimal < 0) {
            decimal = decimal + 100;
            if (integer < 1) {
                System.out.println("Something is wrong, you shouldnt be able to do this kind of operation, this program is fucked up");

            }
            integer--;
        }
    }
    void conversionOfDecimal(int arg_int, int arg_dec) {
        while (arg_dec >= 100) {
            arg_dec = arg_dec - 100;
            arg_int++;
        }
    }
    void interest(double arg) {
        double temp = (integer + decimal / 100) * arg / 100;
        System.out.print("Interest: " + arg + "% of " + get_stringMoney() + " is " + (int) Math.round(temp) + ".");
        integer = integer + (int) Math.round(temp);
        temp = temp - (int) temp;
        temp = temp * 100;
        decimal = decimal + (int) Math.round(temp);
        conversionOfDecimal();
        System.out.print((int) Math.round(temp) + " result is" + get_stringMoney() + "\n");
    }

    void addMoney(int arg_int, int arg_dec) {
        integer = integer + arg_int;
        decimal = decimal + arg_dec;
        conversionOfDecimal();
    }

    void substractMoney(int arg_int, int arg_dec) {
        conversionOfDecimal(arg_int, arg_dec);
        if (integer < arg_int || integer == arg_int && decimal < arg_dec) {
            System.out.println("You tried to withdrow more money than you have");
            return;
        }
        integer = integer - arg_int;
        decimal = decimal - arg_dec;
        conversionOfDecimal();
    }

}
