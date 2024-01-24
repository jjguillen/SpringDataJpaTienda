package com.jaroso.springjpa;

import com.jaroso.springjpa.entities.*;
import com.jaroso.springjpa.repositories.LineaPedidoRepository;
import com.jaroso.springjpa.repositories.PedidoRepository;
import com.jaroso.springjpa.repositories.ProductoRepository;
import com.jaroso.springjpa.repositories.ProveedorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);

        //Añadir los repositorios JPA
        var productoRepository = context.getBean(ProductoRepository.class);
        var lpRepository = context.getBean(LineaPedidoRepository.class);
        var pedidoRepository = context.getBean(PedidoRepository.class);
        var proveedorRepository = context.getBean(ProveedorRepository.class);

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

        //Probar las consultas personalizadas
        List<Producto> productosbc = productoRepository.findAllByCategoriaOrderByNombre(Categoria.TECNOLOGIA);
        productosbc.stream().forEach(System.out::println);
        productoRepository.findProductoByNombre("Iphone 15").ifPresent(System.out::println);

        //Update
        Producto iphone = productoRepository.findById(3l).get();
        System.out.println(iphone);
        iphone.setPrecio(2000);
        productoRepository.save(iphone);

        //Probar RELACIONES
        Producto teclado = productoRepository.findById(4l).get();

        Pedido ped1 = new Pedido(null, LocalDate.now().plusDays(1), "Su casa");
        pedidoRepository.save(ped1);

        LineaPedido lp1 = new LineaPedido(null, 2, teclado, null);
        lpRepository.save(lp1);

        LineaPedido lp2 = new LineaPedido(null, 1, iphone, null);
        lpRepository.save(lp2);

        ped1.addLinea(lp1);
        ped1.addLinea(lp2);
        pedidoRepository.save(ped1);

        Pedido ped2 = new Pedido(null, LocalDate.now().minusDays(2), "Su casa");
        pedidoRepository.save(ped2);

        LineaPedido lp3 = new LineaPedido(null, 2, teclado, ped2);
        lpRepository.save(lp3);

        pedidoRepository.findPedidoByFechaAfter(LocalDate.now()).stream().forEach( p -> {
            System.out.println(p.getId());
        });

        Proveedor prv1 = new Proveedor(null, "Pccomponentes", "Alhama", "656252114", "pc@gmail.com");
        proveedorRepository.save(prv1);

        iphone.addProveedor(prv1);
        productoRepository.save(iphone);





    }

}
