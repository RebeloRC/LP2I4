/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

package lp2i4_tp03;

import java.awt.event.*;
import javax.swing.JTextField;

public class CalculateAction implements ActionListener
{

    private JTextField campoA;
    private JTextField campoB;
    private JTextField campoSoma;
    private JTextField campoSubtracao;
    private JTextField campoMultiplicacao;
    private JTextField campoDivisao;

    public CalculateAction(JTextField campoA, JTextField campoB) {
        super();

        this.campoA = campoA;
        this.campoB = campoB;
    }

    public CalculateAction setCampoSoma(JTextField campoSoma)
    {
        this.campoSoma = campoSoma;
        return this;
    }

    public CalculateAction setCampoSubtracao(JTextField campoSubtracao)
    {
        this.campoSubtracao = campoSubtracao;
        return this;
    }

    public CalculateAction setCampoMultiplicacao(JTextField campoMultiplicacao)
    {
        this.campoMultiplicacao = campoMultiplicacao;
        return this;
    }

    public CalculateAction setCampoDivisao(JTextField campoDivisao)
    {
        this.campoDivisao = campoDivisao;
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e){
            double a = Double.parseDouble(campoA.getText());
            double b = Double.parseDouble(campoB.getText());

            campoSoma.setText((a + b) + "");
            campoSubtracao.setText((a - b) + "");
            campoMultiplicacao.setText((a * b) + "");
            campoDivisao.setText((a / b) + "");
    }
}