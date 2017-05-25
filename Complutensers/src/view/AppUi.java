package view;

import java.util.ArrayList;

import ssactividades.Actividad;
import ssbuscador.Buscable;
import controller.Controller;

public class AppUi {
	private LoginFrame log;
	private AEFrame ae;
	private StudentFrame student;
	private ResultadosFrame results;
	private FrameSinLog withoutLog;
	private PropIniFrame propini;
	private Controller controller;
	
	public AppUi(Controller controller){
		this.controller = controller;
		log = new LoginFrame(this.controller);
		ae = null;
		student = null;
		results = null;
		withoutLog = null;
		propini = null;
	}
	public void entrarSinLog(){
		withoutLog = new FrameSinLog();
	}
	public void iniciarStudentFrame(){
		student = new StudentFrame(controller);
	}
	public void iniciarAEFrame(){
		ae = new AEFrame(controller);
	}
	public void iniciarResultadosFrame(ArrayList<Buscable> resultado){
		results = new ResultadosFrame(resultado, controller);
	}
}
