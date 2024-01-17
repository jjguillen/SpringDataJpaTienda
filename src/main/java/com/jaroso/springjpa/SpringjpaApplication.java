package com.jaroso.springjpa;

import com.jaroso.springjpa.entities.Categoria;
import com.jaroso.springjpa.entities.LineaPedido;
import com.jaroso.springjpa.entities.Producto;
import com.jaroso.springjpa.repositories.LineaPedidoRepository;
import com.jaroso.springjpa.repositories.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);

        var productoRepository = context.getBean(ProductoRepository.class);
        var lpRepository = context.getBean(LineaPedidoRepository.class);

        //Crear objetos para insertar en BBDD
        List<Producto> productos = List.of(
                new Producto(null, "Play5", Categoria.TECNOLOGIA, 450, "Consola de Sony"),
                new Producto(null, "Nintendo Switch Oled", Categoria.TECNOLOGIA, 350, "Consola de Nintendo 2024"),
                new Producto(null, "Iphone 15", Categoria.TECNOLOGIA, 950, "Applephone"),
                new Producto(null, "Teclado Logitech", Categoria.ORDENADORES, 50, "Teclado normal"),
                new Producto(null, "Teclado Ducky v3", Categoria.ORDENADORES, 150, "El mejor mecánico en español"),
                new Producto(null, "Ratón Razer", Categoria.ORDENADORES, 100, "Ratón gamer")
                );

        productoRepository.saveAll(productos);

        List<Producto> productosbc = productoRepository.findAllByCategoriaOrderByNombre(Categoria.TECNOLOGIA);
        productosbc.stream().forEach(System.out::println);

        productoRepository.findProductoByNombre("Iphone 15").ifPresent(System.out::println);

        Producto iphone = productoRepository.findById(3l).get();
        System.out.println(iphone);
        iphone.setPrecio(2000);
        productoRepository.save(iphone);

        Producto teclado = productoRepository.findById(4l).get();
        LineaPedido lp1 = new LineaPedido(null, 2, teclado);
        lpRepository.save(lp1);



    }

}
