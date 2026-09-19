package es.oaemdl.cavoshcafe2026.controller;

import java.util.List;

import es.oaemdl.cavoshcafe2026.ui.Producto;

public class ProdcutoController {
    this.context =context,
    db =new Db(context);
}

public List<Producto> getProductos(boolean bNuevos) {
    if (bNuevos )db.Sentencias("select * from Productos where");
    else db.Sentencial( "select * from Productos where Frecuentes")
    Cursor cursor = db.getCursor();

    List<Producto> productos = null;
    while ( cursor.moveTonext() ){
        if ( productos == null)
            productos
    }

    cursor.close();
    return

}
