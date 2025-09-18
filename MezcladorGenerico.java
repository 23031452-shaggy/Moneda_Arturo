import java.util.*;
//Ejemplo de uso de programacion generica
public class MezcladorGenerico {
    public static <T> List mezclar(List<T> lista1, List<T> lista2) {
        List<T> resultado = new ArrayList<>();
        int max = Math.max(lista1.size(), lista2.size());
        for (int i = 0; i < max; i++) {
            if (i < lista1.size()) resultado.add(lista1.get(i));
            if (i < lista2.size()) resultado.add(lista2.get(i));
        }
        return resultado;
    }
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Luis", "Maria");
        List<String> apellidos = List.of("Lopez", "Ramirez");
        System.out.println(mezclar(nombres, apellidos));
        List<Integer> nums1 = List.of(1, 3, 5);
        List<Integer> nums2 = List.of(2, 4, 6, 8);
        System.out.println(mezclar(nums1, nums2));
    }
}
