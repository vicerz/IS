package controller;

import java.io.IOException;
import java.util.ArrayList;

import ssactividades.Actividad;
import ssactividades.Iniciativa;
import ssusuarios.Agrupacion;
import ssusuarios.Alumno;
import view.AppUi;
import view.LoginListener;
import DAO.DAO;

public class Controller implements LoginListener{
	private DAO dao;
	private ArrayList<Actividad> actividades;
	private ArrayList<Iniciativa> iniciativas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Agrupacion> agrupaciones;
	private int alumnoLogged;
	private int agrupacionLogged;
	private AppUi appui;
	
	public Controller(){
		alumnoLogged = -1;
		agrupacionLogged = -1;
		try {
			dao = new DAO();
			actividades = dao.getActividades();
			iniciativas = dao.getIniciativas();
			alumnos = dao.getAlumnos();
			agrupaciones = dao.getAgrupaciones();
			appui = new AppUi(this);
		} catch (IOException e) { }
	}

	@Override
	public boolean loggear(String usuario, String password) {
		int i = 0, j = 0;
		while (!alumnos.get(i).logIn(usuario, password)) ++i;
		if (i == alumnos.size()){
			while (!agrupaciones.get(j).logIn(usuario, password)) ++j;
			
			if (j != agrupaciones.size())
				agrupacionLogged = j;
		}
		else
			alumnoLogged = i;
		
		return alumnoLogged != -1 || agrupacionLogged != -1;
	}

	@Override
	public void entrarSinLog() {
		
	}

	@Override
	public boolean registrarse(String usuario, String password) {
		int i = 0, j = 0;
		while (!alumnos.get(i).getName().equals(usuario)) ++i;
		while (!agrupaciones.get(j).getName().equals(usuario)) ++j;
		
		boolean registroCorrecto = (i == alumnos.size() && j == agrupaciones.size());
		if (registroCorrecto)
			alumnos.add(new Alumno(usuario, password, null));
		return registroCorrecto;
	}
}
