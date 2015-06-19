package Data;


import java.util.Date;
import javax.swing.ImageIcon;
import vinacoteca.TipoUva;


/**
 *
 * @author Carlos Marchante
 */
public class Vino {
    private int id;
    private String nombre;
    private ImageIcon imagen;
    private double precio;
    private String origen;
    private String fecha;
    private TipoUva tipoUva;
    private boolean denominacion;
    

    public Vino() {
    }

    public Vino(int id, String nombre, double precio, String origen, String fecha, TipoUva tipoUva, boolean denominacion) {
        
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.origen = origen;
        this.fecha = fecha;
        this.tipoUva = tipoUva;
        this.denominacion = denominacion;
    }

    public Vino(int id, String nombre, ImageIcon imagen, double precio, String origen, String fecha, TipoUva tipoUva, boolean denominacion) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.origen = origen;
        this.fecha = fecha;
        this.tipoUva = tipoUva;
        this.denominacion = denominacion;
    }
    
    public int getId(int id){
        return id;
    }

    public void setId(int id){
        this.id = id;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public TipoUva getTipoUva() {
        return tipoUva;
    }

    public void setTipoUva(TipoUva tipoUva) {
        this.tipoUva = tipoUva;
    }

    public boolean isDenominacion() {
        return denominacion;
    }

    public void setDenominacion(boolean denominacion) {
        this.denominacion = denominacion;
    }
    
    
    
   
}
