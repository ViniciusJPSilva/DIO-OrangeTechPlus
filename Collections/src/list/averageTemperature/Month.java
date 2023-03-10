package list.averageTemperature;

public enum Month {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4),MAY(5),JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),  NOVEMBER(11), DECEMBER(12);
	public static String[] monthsNames = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	public static final int MONTHS_QUANTITY = DECEMBER.number;
	
	private final int number;

    private Month (int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
    public static String getMonthName(int month) {
    	if(month < JANUARY.number || month > DECEMBER.number) return null;
    	return monthsNames[month - 1];
    }
	
 }
