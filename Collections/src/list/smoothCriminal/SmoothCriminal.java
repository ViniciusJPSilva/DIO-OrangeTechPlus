package list.smoothCriminal;

import java.util.Scanner;

public class SmoothCriminal {
	
	public static final String[] QUESTIONS = {"Telefonou para a vitima?", "Esteve no local do crime?", "Mora perto da vitima?", "Devia para a vitima?", "Ja trabalhou com a vitima?"};
	
	public static void main(String[] args) {
		new SmoothCriminal();
	} // main()

	public SmoothCriminal() {
		// Lendo as respostas.
		Integer count = askTheSuspect();
		
		// Exibindo os resultados.
		if(count != null) System.out.printf("\nVoce foi classificado como: %s\n", getRespondentRating(count));
		
	} // SmoothCriminal()

	/*
	 * Efetua todas as perguntas de QUESTIONS para o usuário e retorna o número de respostas positivas.
	 * Retorna NULL caso ocorra alguma exceção.
	 */
	public static Integer askTheSuspect() {
		Integer positiveAnswers = 0;
		char answer;
		boolean checkOption;
		Scanner scanf = new Scanner(System.in);
		
		try {
			for(String question : QUESTIONS)
				do {
					System.out.printf("%s (S/N): ", question);
					answer = scanf.next().charAt(0);
					
					checkOption = isValidAnswer(answer);
					if(!checkOption)
						System.out.println("\nResposta inválida! Responda com \'S\' para Sim ou \'N\' para Não.");
					else 
						if(isPositiveAnswer(answer)) positiveAnswers++;
						
				} while (!checkOption);
		} catch (Exception e) {
			System.out.printf("\nUm erro ocorreu durante a leitura dos dados!\n");
			positiveAnswers = null;
		}
		
		scanf.close();
		return positiveAnswers;
	} // askTheSuspect()
	
	public static String getRespondentRating(Integer count) {
		if(count >= 5) return "Assassina";
		
		switch(count) {
		case 2: return "Suspeita";
		case 3:
		case 4: return "Cumplice";
		default: return "Inocente";
		}
	}
	
	public static boolean isValidAnswer(char answer) {
		return !(answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
	}
	
	public static boolean isPositiveAnswer(char answer) {
		return answer == 's' || answer == 'S';
	}
	
}
