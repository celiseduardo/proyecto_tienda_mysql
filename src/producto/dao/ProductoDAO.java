package producto.dao;

import java.util.List;
import producto.dominio.Producto;

public interface ProductoDAO {

    List<Producto> leerProductos();  //Read

    Producto getProductoPorCodigo( int codigo );

    boolean actualizarProducto(Producto producto, int codigo); // Update
}
