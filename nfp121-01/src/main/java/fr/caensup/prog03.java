package fr.caensup;

import domain.TimeV2;

public class prog03 {
    public static void main(String arg[]) {
        TimeV2 times[] = new TimeV2[arg.length];

        for(int i = 0; i < arg.length; i++) {
            try {
                times[i] = new TimeV2(arg[i]);
            } catch (Exception e) {
                times[i] = null;
            }
        }

        for(TimeV2 t: times) {
            System.out.println(t);
        }
    }
}
