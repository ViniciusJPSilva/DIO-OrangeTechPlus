package set.rainbowInTheDark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RainbowInTheDark {
	
	public static String[] rainbowColors = {"Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Anil", "Violeta"};
	
	public static void main(String[] args) {
		new RainbowInTheDark();
	} // main()
	
	public RainbowInTheDark() {		
		showRainbowReport(new LinkedHashSet<>(Arrays.asList(rainbowColors)));
	} // RainbowInTheDark()
	
	// Displays a verbose report.
	private void showRainbowReport(Set<String> myRainbow) {
		System.out.println("Cores do arco-iris:");
		showElements(myRainbow);
		
		System.out.printf("\nO arco-iris possui %d cores.\n", myRainbow.size());
		
		System.out.println("\nCores do arco-iris em ordem alfabetica:");
		showElements(new TreeSet<>(myRainbow));
		
		System.out.println("\nCores do arco-iris na ordem inversa da que foi informada:");
		showElements(reverseCollection(myRainbow));
		
		System.out.println("\nCores do arco-iris que comecam com a letra V:");
		myRainbow.stream().forEach(e -> {
			if(e.charAt(0) == 'V') System.out.printf("\t%s\n", e);
		});
		
		System.out.println("\nRemovendo todas as cores que nao comecam com a letra V:");
		myRainbow.removeIf(e -> e.charAt(0) != 'V');
		showElements(myRainbow);
		
		myRainbow.clear();
		System.out.printf("\nConjunto vazio? %s\n", (myRainbow.isEmpty()) ? "Sim" : "Não");
	} // showRainbowReport()

	/*
	 * Reverses the order of elements in any collection.
	 * Return:
	 * 		LinkedHashSet<> with inverted elements.
	 * 		null if any exceptions occurs.
	 */
	private Collection<?> reverseCollection(Collection<?> collection) {
		try {
			List<?> reverseCollection = new ArrayList<>(collection);
			Collections.reverse(reverseCollection);
			return new LinkedHashSet<>(reverseCollection);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * Displays all elements of the informed Collection in the standard output device.
	 */
	public static void showElements(Collection<?> elements) {
		if(elements != null) elements.stream().forEach(e -> System.out.printf("\t%s\n", e));
	} // showSetElements()
	
} // class RainbowInTheDark
