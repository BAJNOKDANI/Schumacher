import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Feladatok {
    ArrayList<Verseny> lista = new ArrayList<>();
    ArrayList<String> sikeres = new ArrayList<>(List.of("Finished", "+1 Lap", "+2 Laps", "Track rod"));
    public Feladatok() {
        beolvasas();
        System.out.println("3. feladat: " + lista.size());
        System.out.println("4. feladat: Magyar Nagydíj helyezései");
        nagyDij();
        System.out.println("5. feladat: Hibastatisztika");
        statisztika();
    }

    private void beolvasas(){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("schumacher.csv"));
            bf.readLine();
            String sor = bf.readLine();
            while (sor != null){
                lista.add(new Verseny(sor));
                sor = bf.readLine();
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void nagyDij(){
        for (Verseny item : lista){
            if (item.getHely().equals("Hungarian Grand Prix") && sikeres.contains(item.getStatusz())){
                System.out.println(item.getDatum()+":"+ item.getHelyezes()+". helyezés");
            }
        }
    }

    private void statisztika(){
        HashMap<String, Integer> stat = new HashMap<>();
        for (Verseny item : lista){
            String kulcs = item.getStatusz();
            stat.putIfAbsent(kulcs, 0); // ha még nincs ilyen kulcs létrehozza, egyébként nem csinál semmit
            int value = stat.get(kulcs)+1; //érték lekérdezése
            stat.put(kulcs, value); // uj értéket kap a kulcs
        }
        for (String item : sikeres){
            stat.remove(item);
        }
        for (String kulcs : stat.keySet()){
            if (stat.get(kulcs) > 2){
                System.out.println(kulcs+ ":" +stat.get(kulcs));
            }
        }
    }


}
