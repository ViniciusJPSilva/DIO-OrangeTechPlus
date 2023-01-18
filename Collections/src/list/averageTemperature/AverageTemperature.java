package list.averageTemperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageTemperature {
	
	public static final int MONTH_AMOUNT = 6;
	
	public static void main(String[] args) {
		new AverageTemperature();
	} // main()

	
	// Construtor: Responsável pela execução do programa.
	public AverageTemperature() {
		// Lendo as temperaturas.
		List<MonthTemperature> monthList = readMonthsTemperature();
		
		// Exibindo os resultados.
		if(monthList != null) showSemesterAvarage(monthList);
		
	} // AverageTemperature()
	
	/*
	 * Lê do dispositivo de entrada padrão (stdin) a temperatura de MONTH_AMOUNT meses, instancia objetos do tipo MonthTemperature e retorna uma lista deles.
	 * Retorna NULL caso ocorra algum erro.
	 */
	public List<MonthTemperature> readMonthsTemperature() {
		Scanner scanf = new Scanner(System.in);
		List<MonthTemperature> monthList = new ArrayList<>();
		
		try {
			System.out.printf("Forneça a temperatura dos meses a seguir:\n");
			for(int index = 0; index < MONTH_AMOUNT; index++) {
				System.out.printf("%s: ", Month.getMonthName(index + 1));
				monthList.add(new MonthTemperature(index + 1, scanf.nextDouble()));
			}
		} catch (Exception e) {
			System.out.printf("\nUm erro ocorreu durante a leitura dos dados!\n");
			monthList = null;
		}
		
		scanf.close();
		return monthList;
	} // readMonthsTemperature()
	
	/*
	 * Exibe no dispositivo de saída padrão (stdout) a média das temperaturas e os meses cuja temperatura foi maior que a média.
	 * Se a lista estiver vazia nenhuma mensagem é exibida.
	 */
	public void showSemesterAvarage(List<MonthTemperature> monthList) {
		if(monthList.size() == 0) return;
		
		Double avarage = MonthTemperature.getAvarageTemperature(monthList);
		
		System.out.printf("\nMeses com temperatura acima de %.2f °C:", avarage);
		for(MonthTemperature month : monthList)
			if(month.getTemperature() > avarage) System.out.printf("\n%d - %s - %.2f °C", month.getMonth(), month.getMonthName(), month.getTemperature());
	} // showSemesterAvarage()
	
}


