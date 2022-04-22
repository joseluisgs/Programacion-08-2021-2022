package es.joseluisgs.dam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.joseluisgs.dam.model.Menu;
import es.joseluisgs.dam.model.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hola Json con Gson");

        // escribirJSON();
        
        leerJSON();

    }

    private static void leerJSON() {
        System.out.println("Leer un objeto JSON");
        var gson = new GsonBuilder().setPrettyPrinting().create();
        Producto p1 = new Producto("Patata", "Patata de la verdura", 1.5);
        String json = gson.toJson(p1);
        System.out.println(json);
        Producto result = gson.fromJson(json, Producto.class);
        System.out.println(result);
        if (result.equals(p1)) {
            System.out.println("Son iguales");
        }

        System.out.println("Leer una lista de objeto JSON");
        Producto p2 = new Producto("Tomate", "Tomate de la verdura", 2.5);
        List<Producto> productos = List.of(p1, p2);
        json = gson.toJson(productos);
        System.out.println(json);
        List<Producto> resultList = gson.fromJson(json, List.class);
        Producto[] resultArray = gson.fromJson(json, Producto[].class);
        System.out.println(resultList);
        System.out.println(Arrays.toString(resultArray));

        Menu m1 = new Menu("Menu 1", "Descripcion del menu 1", productos);
        Menu m2 = new Menu("Menu 2", "Descripcion del menu 2", productos);
        List<Menu> menus = List.of(m1, m2);

        System.out.println("Leer una objeto compuesto JSON");
        json = gson.toJson(m1);
        System.out.println(json);
        Menu resultMenu = gson.fromJson(json, Menu.class);
        System.out.println(resultMenu);
        json = gson.toJson(menus);
        System.out.println(json);
        List<Menu> resultMenus = gson.fromJson(json, List.class);
        System.out.println(resultMenus);
        Menu[] resultMenusArray = gson.fromJson(json, Menu[].class);
        System.out.println(Arrays.toString(resultMenusArray));
    }

    private static void escribirJSON() {
        Producto p1 = new Producto("Patata", "Patata de la verdura", 1.5);
        Producto p2 = new Producto("Tomate", "Tomate de la verdura", 2.5);
        List<Producto> productos = List.of(p1, p2);
        System.out.println("Json de un producto");
        System.out.println(p1);

        Gson gson = new Gson();
        String json = gson.toJson(p1);
        System.out.println(json);

        System.out.println("Json de un lista de productos");
        json = gson.toJson(productos);
        System.out.println(json);

        gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println("Json de un producto PrettyPrinting");
        json = gson.toJson(p1);
        System.out.println(json);

        System.out.println("Json de una lista producto PrettyPrinting");
        json = gson.toJson(productos);
        System.out.println(json);

        Menu m1 = new Menu("Menu 1", "Descripcion del menu 1", productos);
        Menu m2 = new Menu("Menu 2", "Descripcion del menu 2", productos);
        List<Menu> menus = List.of(m1, m2);

        System.out.println("Json de un menú PrettyPrinting");
        json = gson.toJson(m1);
        System.out.println(json);

        System.out.println("Json de una lista de menús PrettyPrinting");
        json = gson.toJson(menus);
        System.out.println(json);
    }
}
