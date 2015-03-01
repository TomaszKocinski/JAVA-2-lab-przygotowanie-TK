/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 Napisz klasę reprezentującą konto oszczędnościowe, na które można wpłacać i z którego można wypłacać pieniądze. 
 Konto powinno mieć swój numer (numer konta powinien być liczbą całkowitą większą niż 10000). 
 Numery kont powinny być unikalne w skali globalnej (każde nowoutworzone konto powinno mieć unikalny numer). 
 Do klasy dopisz konstruktory domyślny i argumentowy.
 Do klasy dodaj metodę naliczania odsetek (w zależności od ilości dni, które upłynęły - argument metody) i oprocentowania (atrybut konta).
 */
package przygotowaniedolab2;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Kot
 */
public class PrzygotowaniedoLab2 {

    public static LinkedList<Account> listA = new LinkedList();

    public static Account CreateAccount() {
        int i, j;
        System.out.println("You are creating an Account, please write two integers that will be your money");
        Scanner in = new Scanner(System.in);
        i = in.nextInt();
        j = in.nextInt();
        return new Account(i, j);
    }

    public static void AddMoney(Account arg) {
        int i, j;
        System.out.println("You are adding money to account, please write two integers that will be your money");
        Scanner in = new Scanner(System.in);
        i = in.nextInt();
        j = in.nextInt();
        arg.addMoney(i, j);
    }

    public static void SubstractMoney(Account arg) {
        int i, j;
        System.out.println("You are removing money to account, please write two integers that will be your money");
        Scanner in = new Scanner(System.in);
        i = in.nextInt();
        j = in.nextInt();
        arg.substractMoney(i, j);

    }

    public static void OptionsToTypeWhileInAccount() {
        System.out.println("Your options: 1.Add money: a 2.Substract money: s 3.Exit: e");
    }

    public static void OptionsToType() {
        System.out.println("Your options: 1.Enter account 2.Add Account 3.Exit");
    }

    public static void ShowListA() {
        ListIterator<Account> listIterator = listA.listIterator();
        for (int i = 1; listIterator.hasNext(); i++) {
            Account temp=listIterator.next();
            System.out.print(temp.get_number() + ": " + temp.get_stringMoney() + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        while (true) {
            OptionsToType();
            String s;
            Scanner in = new Scanner(System.in);
            s = in.next();
            if (s.equals("1") && !listA.isEmpty()) {
                ShowListA();
                System.out.println("Give number of Account");
                int inte;
                inte = in.nextInt();
                inte = inte - 10001;
                Account selctedAccount = listA.get(inte);
                while (true) {
                    OptionsToTypeWhileInAccount();
                    ShowListA();
                    s = in.next();
                    if (s.equals("a")) {
                       AddMoney(selctedAccount);
                    } else if (s.equals("s")) {
                       SubstractMoney(selctedAccount);
                    } else if (s.equals("e")) {
                        break;
                    }
                }

            } else if (s.equals("2")) {
                listA.add(CreateAccount());
            } else if (s.equals("3")) {
                break;
            }
            ListIterator<Account> listIterator = listA.listIterator();
            for (int i = 1; listIterator.hasNext(); i++) {
                listIterator.next().interest(5);
            }
        }
        /*System.out.println(sa.get_number());
         System.out.println(sa2.get_number());
         System.out.println(sa.get_stringMoney());
         System.out.println(sa2.get_stringMoney());*/
    }

}
