import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class PesquisaBinaria {

	public static int buscaBinaria(int[] data, int chave) {
		int baixo = 0;
		int alto = data.length - 1;
		int meio = (baixo + alto + 1) / 2;
		int localizacao = -1;

		do {
			System.out.print(elementosRestantes(data, baixo, alto));

			for (int i = 0; i < meio; i++)
				System.out.print("   ");
			System.out.println(" * ");

			if (chave == data[meio])
				localizacao = meio;
			else if (chave < data[meio])
				alto = meio - 1;
			else
				baixo = meio + 1;
			meio = (baixo + alto + 1) / 2;
		} while ((baixo <= alto) && (localizacao == -1));
		return localizacao;
	} // fim do metodo

	private static String elementosRestantes(int[] data, int baixo, int alto) {

		StringBuilder temporary = new StringBuilder();

		for (int i = 0; i < baixo; i++)
			temporary.append(" ");

		for (int i = baixo; i <= alto; i++)
			temporary.append(data[i] + " ");

		return String.format("%s%n", temporary);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();

		int[] data = new int[15];

		for (int i = 0; i < data.length; i++)
			data[i] = 10 + generator.nextInt(90);

		Arrays.sort(data);
		System.out.printf("%s%n%n", Arrays.toString(data));

		System.out.print("Digite um valor inteiro ou -1 para sair: ");
		int buscaInt = input.nextInt();

		while (buscaInt != -1) {

			int localizacao = buscaBinaria(data, buscaInt);

			if (localizacao == -1)
				System.out.printf("%d Não foi encontrado%n%n", buscaInt);
			else
				System.out.printf("%d Foi encontrado na posição %d%n%n", buscaInt, localizacao);

			System.out.print("Digite um valor inteiro ou -1 para sair: ");
			buscaInt = input.nextInt();
		}

	}

}
