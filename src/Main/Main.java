package Main;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Lugar lugar1 = new Lugar("28-10-XP", "Renault", 28, false);
        Lugar lugar2 = new Lugar("22-SR-41", "Renault17", 36, true);

        Map<String, Lugar> lugares = new HashMap<>();
        lugares.put("20-10-XP", lugar1);
        lugares.put("22-SR-41", lugar2);

        Parque parque = new Parque("Lidl", lugares);

        System.out.println(parque.getNomeParque());
        System.out.println(parque.getLugares());

        // Map<String, Lugar> lugares1 = new HashMap<>();
        // Lugar lugar3 = new Lugar("23-35-WW", "Mercedes", 120, true);
        // lugares1.put("Continente", lugar3);

        // parque.setLugares(lugares1);
        // System.out.println(parque.getLugares());
        // System.out.println(lugares);

        // Parque parque1 = new Parque(parque);

        // System.out.println(parque1.toString());

        System.out.println(parque.getMatriculas());
        // parque.removeLugar("28-10-XP");
        // System.out.println(parque.getMatriculas());

        System.out.println(parque.totalMinutosE());
        System.out.println(parque.totalMinutosI());

        System.out.println(parque.infLugar("28-10-XP"));
        System.out.println(parque.infLugar("22-SR-41"));
    }

}
