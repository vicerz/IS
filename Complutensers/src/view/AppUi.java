package view;

import java.util.ArrayList;

import controller.Controller;
import ssactividades.Actividad;
import ssusuarios.Agrupacion;

public class AppUi implements SearchButtonListener{
	private LoginFrame log;
	private AEFrame ae;
	private StudentFrame student;
	private ResultadosFrame results;
	private FrameSinLog withoutLog;
	private Controller controller;
	
	public AppUi(Controller c){
		controller = c;
		log = new LoginFrame(controller);
	}
	@Override
	public ArrayList<Actividad> buscarActividad(String keyWords) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Agrupacion> buscarAgrupacion(String keyWords) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Actividad> buscarIniciativa(String keyWords) {
		// TODO Auto-generated method stub
		return null;
	}
}
