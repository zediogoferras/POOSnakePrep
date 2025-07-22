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
        ArrayList<Double> angles = new ArrayList<>();
        ArrayList<Ponto> pointsOfRotation = new ArrayList<>();
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
            aos = s.split(" ", 3);
            //if only the angle was introduced
            if(aos.length == 1){
                angles.add(Double.parseDouble(aos[0]));
                pointsOfRotation.add(null);
            }
            //if angle and point were introduced
            else if(aos.length == 3){
                angles.add(Double.valueOf(aos[0]));
                pointsOfRotation.add(new Ponto(Double.parseDouble(aos[1]), Double.parseDouble(aos[2])));
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        sc.close();
        if(checkDuplicates(p)){
            System.out.println("Duplicado");
        }
        else{
            Poligono[] rotatedPoligonos = new Poligono[p.size()];
            for(int i = 0; i < p.size(); i++){
                //use centroid if no point was introduced in i position
                if(pointsOfRotation.get(i) == null){
                    rotatedPoligonos[i] = p.get(i).rotate(angles.get(i));
                }
                //use point given by user
                else{
                    rotatedPoligonos[i] = p.get(i).rotate(angles.get(i), pointsOfRotation.get(i));
                }
                System.out.println(rotatedPoligonos[i]);
            }
        }
    }
}