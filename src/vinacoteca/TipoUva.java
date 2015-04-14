package vinacoteca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Carlos Marchante
 */
public class TipoUva {
    private int id;
    private String nombre;
    private String caracteristicas;
    private String color;

    public TipoUva() {
    }

    public TipoUva(int id ,String nombre, String caracteristicas, String color) {
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.color = color;
    }
    
    public int getId(){
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
