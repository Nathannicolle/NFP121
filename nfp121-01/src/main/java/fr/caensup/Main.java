package fr.caensup;

import domain.*;

import java.util.Scanner;

import static domain.Math.*;
public class Main {
    public static void main(String[] args) throws BadFormatException {
        System.out.println(square(PI));
        Time t;
        boolean ok = true;
        int h, m;
        Scanner sc = new Scanner(System.in);
        System.out.print("heure : ");
        h = sc.nextInt();
        System.out.print("minute : ");
        m = sc.nextInt();

        do {
            ok = true;
            try {
                t = new Time(h, m);
            } catch (BadHourException e) {
                ok = false;
                System.out.println(e);
                System.out.print("heure : ");
                h = sc.nextInt();
            } catch (BadMinuteException e) {
                ok = false;
                System.out.println(e);
                System.out.print("minute : ");
                m = sc.nextInt();
            }
        } while (!ok);
    }
}