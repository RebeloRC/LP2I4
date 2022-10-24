/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

package lp2i4_tp03;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.util.List;

 
public class Form extends JFrame implements ActionListener {

	private JLabel labelA, labelB, labelSoma, labelSubtracao, labelMultiplicacao, labelDivisao;
	private JTextField textFA, textFB, textFSoma, textFSubtracao, textFMultiplicacao, textFDivisao;
	private JPanel panelComponents, PanelButtons;
	private JButton btnLimpar, btnCalcular, btnSair;
	
	public Form() {

		setFormLayout();
		initializingComponents();
		addingComponentsOnForm();
		ActionEvents();
		Calculate();
	}

	private void setFormLayout() {
		setSize(400, 300);
		setTitle("Teste");
		setLayout(new BorderLayout(10, 10));
	}
	
	private void initializingComponents() {
		labelA = new JLabel("A :");
		textFA = new JTextField("");
		
		labelB = new JLabel("B :");
		textFB = new JTextField("");
		
		labelSoma = new JLabel("Soma :");
		textFSoma = new JTextField("0");
		
		labelSubtracao = new JLabel ("Subtração: ");
		textFSubtracao= new JTextField ("0");
		
		labelMultiplicacao = new JLabel("Multiplicação :");
		textFMultiplicacao = new JTextField("0");
		
		labelDivisao = new JLabel("Divisão :");
		textFDivisao = new JTextField("0");
	
        btnLimpar = new JButton("Limpar");
        btnCalcular = new JButton("Calcular");
        btnSair = new JButton("Sair");
	}
	
	private void addingComponentsOnForm() {
		panelComponents = new JPanel();
		panelComponents .setLayout(new GridLayout(6,2, 0, 0));

		
		panelComponents.add(labelA);
		panelComponents.add(textFA);

		panelComponents.add(labelB);
		panelComponents.add(textFB);

		panelComponents.add(labelSoma);
		panelComponents.add(textFSoma);

		panelComponents.add(labelSubtracao);
		panelComponents.add(textFSubtracao);

		panelComponents.add(labelMultiplicacao);
		panelComponents.add(textFMultiplicacao);

		panelComponents.add(labelDivisao);
		panelComponents.add(textFDivisao);
		
		add(panelComponents, BorderLayout.CENTER);
		
		PanelButtons = new JPanel();
		PanelButtons .setLayout(new GridLayout(1, 3, 0, 0));
		
		PanelButtons.add(btnLimpar);
		PanelButtons.add(btnCalcular);
		PanelButtons.add(btnSair); 

        add(PanelButtons, BorderLayout.SOUTH);
	}
	
	private void ActionEvents() {
		addWindowListener(new ExitAction());
		
		btnLimpar.addActionListener(this);
		btnSair.addActionListener(this);
	}

	public static void main(String args[])
	{
		Form Form = new Form();
		Form.setVisible(true);
	}
	
    private void Calculate(){

        List<JTextField> campos = new ArrayList<JTextField>();

        campos.add(textFA);
        campos.add(textFB);
        campos.add(textFSoma);
        campos.add(textFSubtracao);
        campos.add(textFMultiplicacao);
        campos.add(textFDivisao);

        CalculateAction Calcular = new CalculateAction(textFA, textFB)
                                                .setCampoSoma(textFSoma)
                                                .setCampoSubtracao(textFSubtracao)
                                                .setCampoMultiplicacao(textFMultiplicacao)
                                                .setCampoDivisao(textFDivisao);
        
        btnCalcular.addActionListener(Calcular);
    }
	
	private void Limpar() {
	    textFA.setText("");
	    textFB.setText("");
	    textFSoma.setText("0");
	    textFSubtracao.setText("0");
	    textFMultiplicacao.setText("0");
		textFDivisao.setText("0");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnLimpar) {
	        Limpar();
	      }
	    
	    if (e.getSource() == btnSair) {
	        System.exit(0);
	      }
	}
}