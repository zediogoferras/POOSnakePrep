import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String capital(String s) {
        if (s == null || s.isEmpty())
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /**
     * Checks if there are any duplicated polygons in the arrayList of polygons
     * @param p arrayList of polygons
     * @return true if there are duplicates, false if not
     */
    public static boolean checkDuplicates(ArrayList<Poligono> p){
        Poligono[] poligonos = new Poligono[p.size()];
        int k = 0;
        for(Poligono p0 : p){
            poligonos[k++] = p0;
        }
        for(int i = 0; i < poligonos.length-1; i++){
            for(int j = i+1; j < poligonos.length; j++){
                if(poligonos[i].isDuplicate(poligonos[j])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Constructor<?> constructor;
        Class<?> cl;
        ArrayList<Poligono> p = new ArrayList<>();
        ArrayList<Ponto> c = new ArrayList<>();
        String s;
        String[] aos;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            if (s.isEmpty())
                break;
            aos = s.split(" ", 2);
            try {
                cl = Class.forName(capital(aos[0]));
                constructor = cl.getConstructor(String.class);
                p.add((Poligono) constructor.newInstance(aos[1]));
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Não foi encontrada a classe: " + cnfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            s = sc.nextLine();
            aos = s.split(" ", 2);
            try{
                c.add(new Ponto(Double.parseDouble(aos[0]), Double.parseDouble(aos[1])));
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        sc.close();
        if(checkDuplicates(p)){
            System.out.println("Duplicado");
        }
        else{
            Poligono[] translatedPoligonos = new Poligono[p.size()];
            for(int i = 0; i < p.size(); i++){
                translatedPoligonos[i] = p.get(i).translate(c.get(i));
                System.out.println(translatedPoligonos[i]);
            }
        }
    }
}