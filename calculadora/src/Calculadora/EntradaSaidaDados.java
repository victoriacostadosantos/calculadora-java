package Calculadora;

//caixa de dialogo

import javax.swing.JOptionPane;

public class EntradaSaidaDados {
	public String entradaDados(String mensagemEntrada) {
		return JOptionPane.showInputDialog(mensagemEntrada);
	}
	public void saidaDados(String mensagemSaida) {
		JOptionPane.showMessageDialog(null, mensagemSaida);
	}
}
