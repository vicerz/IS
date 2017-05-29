package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ssbuscador.Buscable;
import controller.Controller;
import ssactividades.Actividad;
import view.ModificarFrame;

public class AppUi {
	private LoginFrame log;
	private AEFrame ae;
	private StudentFrame student;
	private ResultadosFrame results;
	private HistorialFrame historial;
	private FrameSinLog withoutLog;
	private PropIniFrame propini;
	private Controller controller;
	private ModificarFrame modact;
	
	public AppUi(Controller controller){
		this.controller = controller;
		log = new LoginFrame(this.controller);
		ae = null;
		student = null;
		results = null;
		withoutLog = null;
		propini = null;
		
		log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		log.addWindowListener(controller);
	}
	public void entrarSinLog(){
		log.setVisible(false);
		withoutLog = new FrameSinLog(controller);
		withoutLog.setVisible(true);
		withoutLog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		withoutLog.addWindowListener(controller);
	}
	public void iniciarStudentFrame(){
		log.setVisible(false);
		student = new StudentFrame(controller);
		student.setVisible(true);
		student.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		student.addWindowListener(controller);
	}
	public void iniciarAEFrame(String nombre){
		log.setVisible(false);
		ae = new AEFrame(controller, nombre);
		ae.setVisible(true);
		ae.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ae.addWindowListener(controller);
	}
	public void iniciarResultadosFrame(ArrayList<Buscable> resultado){
		results = new ResultadosFrame(resultado, controller);
		results.setVisible(true);
	}
	
	public void iniciarHistorialFrame(String nombre, ArrayList<Actividad> actividades){
		historial = new HistorialFrame(actividades, nombre, controller);
		historial.setVisible(true);
	}
	
	public void modificarActividad(Actividad act){
		modact = new ModificarFrame(act, controller);
		modact.setVisible(true);
	}
	
	public void mostrarMensaje(String mensaje){
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, mensaje);
	}
	public void iniciarPropIniFrame(){
		new PropIniFrame(controller).setVisible(true);
	}
	public void iniciarActIniFrame(){
		new CrearActividadFrame(controller).setVisible(true);
	}
}
