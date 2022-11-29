/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

package tp04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Form extends JFrame  implements ActionListener {
	
	private JPanel panelPesquisa, panelPesquisaCampo, panelCampos, panelBotoes;
    private JLabel labelNomePesquisa, labelNome, labelSalario, labelCargo;
    
    private JTextField textNomePesquisa, textNome, textSalario, textCargo;
    private JButton btnPesquisar, btnAnterior, btnProximo;
    
    private ArrayList<Funcionario> funcionarios;
    private FuncionarioRepository funcionarioRepository;
    private int indexFuncionario;
    
    public Form () {
    	
		ActionEvents();
		setFormLayout();
		initializingComponents();
		addingComponentsOnForm();
		
        funcionarios = new ArrayList<Funcionario>();
        funcionarioRepository = new FuncionarioRepository();
        indexFuncionario = 0;
    }
    
	private void ActionEvents() {
		addWindowListener(new ExitAction());
        btnPesquisar.addActionListener(this);
        btnAnterior.addActionListener(this);
        btnProximo.addActionListener(this);
	}

	private void setFormLayout() {
		setSize(700, 400);
		setTitle("TP04");
		setLayout(new BorderLayout(10, 10));
	}
	
    private void initializingComponents(){
    	labelNomePesquisa = new JLabel( "Nome: ");
        textNomePesquisa = new JTextField(20);

        labelNome = new JLabel( "Nome: ");
        textNome = new JTextField(10);

        labelSalario = new JLabel( "Salário: ");
        textSalario = new JTextField(10);

        labelCargo = new JLabel( "Cargo: ");
        textCargo = new JTextField(10);

        btnPesquisar = new JButton("Pesquisar");
        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");
    }
    
    private void addingComponentsOnForm(){
        
    	panelPesquisaCampo = new JPanel();
    	panelPesquisaCampo.setLayout(new FlowLayout(FlowLayout.CENTER));

    	panelPesquisaCampo.add(labelNomePesquisa);
    	panelPesquisaCampo.add(textNomePesquisa);

        panelPesquisa = new JPanel();
        panelPesquisa.setLayout(new GridLayout(2, 1));

        panelPesquisa.add(panelPesquisaCampo);
        panelPesquisa.add(btnPesquisar);

        panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(3, 2, 10, 10));

        panelCampos.add(labelNome);
        panelCampos.add(textNome);

        panelCampos.add(labelCargo);
        panelCampos.add(textCargo);

        panelCampos.add(labelSalario);
        panelCampos.add(textSalario);

        panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(1, 2, 0, 0));

        panelBotoes.add(btnAnterior);
        panelBotoes.add(btnProximo);

        add(panelPesquisa, BorderLayout.NORTH);
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
    }

	public static void main(String args[])
	{
		Form Form = new Form();
		Form.setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnPesquisar){
            pesquisar();
        }

        if(e.getSource() == btnAnterior){
            anterior();
        }

        if(e.getSource() == btnProximo){
            proximo();
        } 
        
    }
    
    private void pesquisar(){
        indexFuncionario = 0;
        funcionarios = funcionarioRepository.getFuncionarios(textNomePesquisa.getText());

        if(funcionarios.size() <= 0)
        {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
            return;
        }
        textNomePesquisa.setText("");
        setFuncionarioCampos();
    }
    
    private void anterior(){
        if(indexFuncionario - 1 < 0){
            JOptionPane.showMessageDialog(null, "Você já está no inicio da lista!");
            return;
        }
        indexFuncionario--;
        setFuncionarioCampos();
    }
    
    private void proximo(){
        if(indexFuncionario  + 1 >= funcionarios.size()){
            JOptionPane.showMessageDialog(null, "Você já está no Fim da lista!");
            return;
        }
        indexFuncionario++;
        setFuncionarioCampos();
    }
    
    private void setFuncionarioCampos(){
        Funcionario funcionario = funcionarios.get(indexFuncionario);

        textNome.setText(funcionario.getNome());
        textSalario.setText(funcionario.getSalario() + "");
        textCargo.setText(funcionario.getCargo());

    }

}
