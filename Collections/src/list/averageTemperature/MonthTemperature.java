package list.averageTemperature;

import java.util.List;

public class MonthTemperature {
	private int month;
	private Double temperature;
	
	public MonthTemperature(int month, Double temperature) {
		super();
		this.month = month;
		this.temperature = temperature;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public Double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	/*
	 * Itera sobre uma lista de objetos tipo MonthTemperature, calcula e retorna a média das temperaturas.
	 */
	public static Double getAvarageTemperature(List<MonthTemperature> months) {
		return months.stream().mapToDouble(month->month.getTemperature()).sum() / months.size();
	}
	
	/*
	 * Retorna o nome do mês do objeto instanciado.
	 */
	public String getMonthName() {
		return getMonthName(month);
	}
	
	public static String getMonthName(int month) {
		return Month.getMonthName(month);
	}
}