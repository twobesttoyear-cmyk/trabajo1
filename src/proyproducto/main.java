package proyproducto;

import java.util.List;
import mis.clases.Producto;

public class main {

    public static void main(String[] args) {
        
        List<Producto> productos = List.of(
                new Producto("Laptop", 2500, 5),
                new Producto("Mouse", 50, 0),
                new Producto("Teclado", 120, 8),
                new Producto("Monitor", 800, 3),
                new Producto("Cable", 15, 20)
        );
        
        //Ejercicio 1
        System.out.println("----- Ejercicio 1 ------");
        List<Producto> disponibles = productos.stream()
                .filter( p -> p.getStock() > 0)
                .toList();
        System.out.println(disponibles.toString());
        
        //Ejercicio 2
        System.out.println("----- Ejercicio 2 ------");
        List<Producto> precio = productos.stream()
                .filter( p -> p.getPrecio() > 100)
                .toList();
        System.out.println(precio.toString());
        
        //Ejercicio 3
        List<String> nombres = productos.stream()
                .map(p -> p.getNombre())
                .toList();
        System.out.println(nombres);
        
        //Ejercicio 4
        List<Double> preciosConIGV = productos.stream()
                .map( p -> p.getPrecio() * 1.18)
                .toList();
        
        System.out.println(preciosConIGV);
        
        //Ejercicio 5
        int stockTotal = productos.stream()
                .map(p -> p.getStock())
                .reduce(0, (a,b) -> a + b);
        System.out.println("Stock Total: " + stockTotal);
        
        //Ejercicio 6
        
        try{
            //valor negativo
            double precioProducto = -100;
            if(precioProducto < 0){
                throw new IllegalArgumentException("El precio no puede ser negativo");
            }
            
            Producto nuevoP = new Producto("Tablet", precioProducto, 5);
            
            System.out.println("Producto registrado" + nuevoP.toString());
            
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
    
}
