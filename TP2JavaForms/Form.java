import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Form extends JFrame implements ActionListener {

  private JLabel lblNome, lblIdade, lblEndereco;
  private JTextField txtNome, txtIdade, txtEndereco;
  private JButton btnOk, btnLimpar, btnMostrar, btnSair;
  private JPanel pnlCampos, pnlBotoes;

  private List<Aluno> alunos;

  public Form(String title) {
    super(title);

    alunos = new ArrayList<Aluno>();
    configurarLayoutForm();
    instanciarCampos();
    adicionandoCamposPanel();
    ActionEvents();
  }

  private void configurarLayoutForm() {
    setSize(400, 180);
    setLayout(new BorderLayout(10, 10));
  }

  private void instanciarCampos() {
    lblNome = new JLabel("Nome: ");
    txtNome = new JTextField(10);

    lblIdade = new JLabel("Idade: ");
    txtIdade = new JTextField(10);

    lblEndereco = new JLabel("Endereço: ");
    txtEndereco = new JTextField(10);

    btnOk = new JButton("OK");
    btnLimpar = new JButton("Limpar");
    btnMostrar = new JButton("Mostrar");
    btnSair = new JButton("Sair");
  }

  private void adicionandoCamposPanel() {
    pnlCampos = new JPanel();
    pnlCampos.setLayout(new GridLayout(3, 2, 10, 10));

    pnlCampos.add(lblNome);
    pnlCampos.add(txtNome);

    pnlCampos.add(lblIdade);
    pnlCampos.add(txtIdade);

    pnlCampos.add(lblEndereco);
    pnlCampos.add(txtEndereco);

    pnlBotoes = new JPanel();
    pnlBotoes.setLayout(new GridLayout(1, 4, 10, 1));

    pnlBotoes.add(btnOk);
    pnlBotoes.add(btnLimpar);
    pnlBotoes.add(btnMostrar);
    pnlBotoes.add(btnSair);

    add(pnlCampos, BorderLayout.CENTER);
    add(pnlBotoes, BorderLayout.SOUTH);
  }

  private void ActionEvents() {
    addWindowListener(new FecharFormAction());
    btnSair.addActionListener(this);

    btnOk.addActionListener(this);
    btnLimpar.addActionListener(this);
    btnMostrar.addActionListener(this);
  }

  public static void main(String[] args) {
    Form f = new Form("Listagem de alunos");
    f.setVisible(true);

  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == btnLimpar) {
      Limpar();
    }
    if (e.getSource() == btnMostrar) {
      Mostrar();
    }
    if (e.getSource() == btnOk) {
      Incluir();
    }

    if (e.getSource() == btnSair) {
      System.exit(0);
    }
  }

  private void Incluir() {
    Aluno aluno = new Aluno();

    aluno.setNome(txtNome.getText());
    aluno.setEndereco(txtEndereco.getText());
    aluno.setIdade(Integer.parseInt(txtIdade.getText()));

    alunos.add(aluno);
    Limpar();
  }

  private void Mostrar() {
    String mensagem = "";

    for (Aluno aluno : alunos) {
      mensagem += aluno.toString() + "\n";
    }
    JOptionPane.showMessageDialog(this, mensagem);
  }

  private void Limpar() {
    txtNome.setText("");
    txtIdade.setText("");
    txtEndereco.setText("");
  }
}