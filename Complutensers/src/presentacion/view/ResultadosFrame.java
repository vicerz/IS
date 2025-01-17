package presentacion.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import negocio.ssactividades.Actividad;
import negocio.ssbuscador.Buscable;
import negocio.ssusuarios.Agrupacion;

/*
 * para ver como queda ejecutar la clase prueba
 */
public class ResultadosFrame extends JFrame{
	
	ArrayList<Buscable> resultados;
	JPanel panelresultados;
	JPanel panelinfo;
	ResultadosListener rl;
	
	public ResultadosFrame(ArrayList<Buscable> a, ResultadosListener r){
		super("Resultados de b�squeda");
		resultados=a;
		rl=r;
		initGUI(a.size());
		
	}

	private void initGUI(int num) {
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
		JLabel header = new JLabel();
		header.setIcon(new ImageIcon("src/integracion/resources/header.jpg"));
		top.add(header);
		if(num==0)
			top.add(new JLabel("No se han encontrado resultados"));
		else if(num==1)
			top.add(new JLabel("Se ha obtenido un resultado:"));
		else
			top.add(new JLabel("Se han obtenido " + num + " resultados:"));
		
		JPanel results = new JPanel();
		results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));
		for(Buscable elem : resultados){
			
			JPanel resultado = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
			
			JButton info = new JButton("+ info");
			info.addActionListener((e)->{
				mostrarInfo(elem);
			});	
			resultado.add(new JLabel(elem.getName()));
			resultado.add(info);
			
			if (elem instanceof Actividad) {
				JButton apuntarse = new JButton("Apuntarse");
				apuntarse.addActionListener((e) -> {
					rl.apuntarseAct((Actividad) elem);
				});
				resultado.add(apuntarse);
			}
			else if(elem instanceof Agrupacion){
				JButton apuntarse = new JButton("Apuntarse");
				apuntarse.addActionListener((e) -> {
					rl.apuntarseAgrup((Agrupacion) elem);
				});
				resultado.add(apuntarse);
			}
			
			results.add(resultado);
		}
		
		JScrollPane panelBarra = new JScrollPane(results,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		mainPanel.add(top,BorderLayout.NORTH);
		mainPanel.add(panelBarra,BorderLayout.CENTER);
		
		panelresultados = mainPanel;
		this.setContentPane(panelresultados);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(new Dimension(384,620));
		this.pack();
		this.setVisible(true);
	}

	private void mostrarInfo(Buscable elem) {
		JPanel mainPanel=new JPanel(new BorderLayout());
		
		JPanel top =new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		top.add(new JLabel(elem.getName()));
		mainPanel.add(top,BorderLayout.NORTH);			
		
		JTextArea descripcion = new JTextArea(elem.getDescription());
		descripcion.setEditable(false);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);
		JScrollPane center = new JScrollPane(descripcion,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(center,BorderLayout.CENTER);		
		
		JPanel bot=new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		JButton volver = new JButton("Volver a resultados");
		volver.addActionListener((e)->{
			this.setContentPane(panelresultados);
			this.pack();
		});
		
		mainPanel.add(new JPanel(),BorderLayout.LINE_START);
		mainPanel.add(new JPanel(),BorderLayout.LINE_END);
		
		bot.add(volver);
		mainPanel.add(bot,BorderLayout.SOUTH);
		
		
		panelinfo=mainPanel;
		this.setContentPane(panelinfo);
		this.setPreferredSize(new Dimension(384,620));
		this.pack();
	}

}