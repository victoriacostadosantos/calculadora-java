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
	//menu para a entrada e escolha do tipo de opera��o via numeros
	private void executarMenuPrincipal() {
		String mensagemMenu = "Selecione uma op��o"
				+"\n 1 - Somar"
				+"\n 2 - Subtrair"
				+"\n 3 - Multiplicar"
				+"\n 4 - Dividir"
				+"\n 5 - Sair";
		String entradaDados = io.entradaDados(mensagemMenu);
		this.opcao = conversor.StringToInt(entradaDados);
	}
	//avalia��o da op��o escolhida
	public void avaliarOpcaoEscolhida() {
		String saida;
		double num1=0, num2=0;
	//entrada e leitura de numeros a ser calculados
		if(this.opcao != 0 && this.opcao<=4) {
			String mensagemEntrada = "Digite o 1� numero";
			num1 = conversor.stringToDouble(io.entradaDados(mensagemEntrada));
			calculadora.setNumero01(num1);
			mensagemEntrada = "Digite o 2� numero";
			num2 = conversor.stringToDouble(io.entradaDados(mensagemEntrada));
			calculadora.setNumero02(num2);
		}
		//avalia��o da op��o escolhido e numeros inseridos para realiza��o do calculo
			switch(this.opcao) {
			case 1:
				calculadora.somar(num1,num2);
				saida="Resultado da soma: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 2:
				calculadora.subtrair(num1,num2);
				saida="Resultado da subtra��o: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 3:
				calculadora.multiplicar(num1,num2);
				saida="Resultado da multiplica��o: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 4:
				calculadora.dividir(num1,num2);
				saida="Resultado da divis�o: " + calculadora.getResultado();
				io.saidaDados(saida);
				break;
				
			case 5:
				calculadora.sair();
			default:
				io.saidaDados("Op��o invalida");
				break;
			}
	}
}

