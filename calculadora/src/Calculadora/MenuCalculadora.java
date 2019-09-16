package Calculadora;

public class MenuCalculadora {
	private Calculadora calculadora;
	private int opcao;
	private ConversorNumeros conversor;
	private EntradaSaidaDados io;
	
	public MenuCalculadora() {
		this.calculadora = new Calculadora();
		this.opcao = -1;
		this.conversor = new ConversorNumeros();
		this.io = new EntradaSaidaDados();
	}
	public void executarCalculadora() {
		do {
			this.executarMenuPrincipal();
			this.avaliarOpcaoEscolhida();
		}while(this.opcao!=0);
	}
	//menu para a entrada e escolha do tipo de operação via numeros
	private void executarMenuPrincipal() {
		String mensagemMenu = "Selecione uma opção"
				+"\n 1 - Somar"
				+"\n 2 - Subtrair"
				+"\n 3 - Multiplicar"
				+"\n 4 - Dividir"
				+"\n 5 - Sair";
		String entradaDados = io.entradaDados(mensagemMenu);
		this.opcao = conversor.StringToInt(entradaDados);
	}
	//avaliação da opção escolhida
	public void avaliarOpcaoEscolhida() {
		String saida;
		double num1=0, num2=0;
	//entrada e leitura de numeros a ser calculados
		if(this.opcao != 0 && this.opcao<=4) {
			String mensagemEntrada = "Digite o 1º numero";
			num1 = conversor.stringToDouble(io.entradaDados(mensagemEntrada));
			calculadora.setNumero01(num1);
			mensagemEntrada = "Digite o 2° numero";
			num2 = conversor.stringToDouble(io.entradaDados(mensagemEntrada));
			calculadora.setNumero02(num2);
		}
		//avaliação da opção escolhido e numeros inseridos para realização do calculo
			switch(this.opcao) {
			case 1:
				calculadora.somar(num1,num2);
				saida="Resultado da soma: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 2:
				calculadora.subtrair(num1,num2);
				saida="Resultado da subtração: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 3:
				calculadora.multiplicar(num1,num2);
				saida="Resultado da multiplicação: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 4:
				calculadora.dividir(num1,num2);
				saida="Resultado da divisão: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 5:
				calculadora.sair();
			default:
				io.saidaDados("Opção invalida");
				break;
			}
	}
}

