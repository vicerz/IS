package presentacion.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.ssactividades.Actividad;
import negocio.ssbuscador.Buscable;
import presentacion.controller.Controller;
import presentacion.view.ModificarFrame;

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
	private CrearActividadFrame regact;
	
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
	public void iniciarAEFrame(){
		log.setVisible(false);
		ae = new AEFrame(controller);
		ae.setVisible(true);
		ae.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ae.addWindowListener(controller);
	}
	public void iniciarResultadosFrame(ArrayList<Buscable> resultado){
		results = new ResultadosFrame(resultado, controller);
		results.setVisible(true);
	}
	
	public void iniciarHistorialFrame(ArrayList<Actividad> actividades){
		historial = new HistorialFrame(actividades, controller);
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
		propini= new PropIniFrame(controller);
		propini.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		propini.setVisible(true);
	}
	public void iniciarActIniFrame(){
		regact=new CrearActividadFrame(controller);
		regact.setVisible(true);
	}
	public void volverAStudentFrame(){
		propini.setVisible(false);
		student.setVisible(true);
	}
}
