package set.favoriteLanguage;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import set.rainbowInTheDark.RainbowInTheDark;

public class Program {
	
	public static void main(String[] args) {
		new Program();
	} // main()

	public Program() {
		Set<FavoriteLanguage> favoriteLangs = createSimpleFavoriteLanguageCollection();
		
		showFavoriteLangReport(favoriteLangs);
	} // Program constructor.
	
	/*
	 * Creates a linkedHashSet collection of FavoriteLanguage's.
	 * Returns a Set<FavoriteLanguage>
	 */
	public static Set<FavoriteLanguage> createSimpleFavoriteLanguageCollection() {
		Set<FavoriteLanguage> favoriteLangs = new LinkedHashSet<>();
	
		favoriteLangs.add(new FavoriteLanguage("Java", 1995, "IntelliJ"));
		favoriteLangs.add(new FavoriteLanguage("C", 1972, "CodeBlocks"));
		favoriteLangs.add(new FavoriteLanguage("Java", 1991, "Eclipse"));
		favoriteLangs.add(new FavoriteLanguage("Fortran", 1954, "VS Code"));
		
		return favoriteLangs;
	} // createSimpleFavoriteLanguageCollection()
	
	// Displays a verbose report.
	private void showFavoriteLangReport(Set<FavoriteLanguage> favoriteLangs) {
		System.out.println("Insertion order:");
		RainbowInTheDark.showElements(favoriteLangs);
		
		System.out.println("\nNatural order:");
		RainbowInTheDark.showElements(new TreeSet<>(favoriteLangs));
		
		System.out.println("\nOrder by IDE:");
		Set<FavoriteLanguage> otherOrders = new TreeSet<>(
				new Comparator<FavoriteLanguage>() {

					@Override
					public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
						return o1.getIde().compareTo(o2.getIde());
					}
	
				});
		
		otherOrders.addAll(favoriteLangs);
		RainbowInTheDark.showElements(otherOrders);
		
		System.out.println("\nOrder by year and name:");
		otherOrders = new TreeSet<>(
				new Comparator<FavoriteLanguage>() {

					@Override
					public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
						int year = Integer.compare(o1.getCreationYear(), o2.getCreationYear());
						if(year != 0) return year;
						
						return o1.getName().compareTo(o2.getName());
					}
	
				});
		
		otherOrders.addAll(favoriteLangs);
		RainbowInTheDark.showElements(otherOrders);
		
		System.out.println("\nOrder by name, year and IDE:");
		otherOrders = new TreeSet<>(
				new Comparator<FavoriteLanguage>() {

					@Override
					public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
						int name = o1.getName().compareTo(o2.getName());
						if(name != 0) return name;
						
						int year = Integer.compare(o1.getCreationYear(), o2.getCreationYear());
						if(year != 0) return year;
						
						return o1.getIde().compareTo(o2.getIde());
					}
	
				});
		
		otherOrders.addAll(favoriteLangs);
		RainbowInTheDark.showElements(otherOrders);
	} // showFavoriteLangReport()
	
}
