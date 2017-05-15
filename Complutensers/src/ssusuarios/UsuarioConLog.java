package ssusuarios;
import java.util.ArrayList;
import java.util.List;

import ssactividades.Actividad;

public abstract class UsuarioConLog implements Usuario {
    protected String nombre;
    protected String password;
    protected boolean logged;
    protected ArrayList<Actividad> actividadesPendientes = new ArrayList<Actividad>();
    protected ArrayList<Actividad> actividadesRealizadas = new ArrayList<Actividad>();
    protected ArrayList<Mensaje> mensaje = new ArrayList<Mensaje> ();
    
    public UsuarioConLog(String nombre,String password){
    	this.nombre=nombre;
    	this.password=password;
    	logged = false;
    }
    public void AccederBuzon() {
    }

    public boolean logIn(String nombre,String password) {
    	logged = this.nombre == nombre && this.password == password;
    	return logged;
    }

    public void logOut() {
    	logged=false;
    }

}
