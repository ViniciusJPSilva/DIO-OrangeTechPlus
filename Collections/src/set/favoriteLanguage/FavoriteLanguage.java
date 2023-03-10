package set.favoriteLanguage;

import java.util.Objects;

public class FavoriteLanguage implements Comparable<FavoriteLanguage> {
	
	private String name;
	private int creationYear;
	private String ide;
	
	public FavoriteLanguage(String name, int creationYear, String ide) {
		this.name = name;
		this.creationYear = creationYear;
		this.ide = ide;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}

	public String getIde() {
		return ide;
	}

	public void setIde(String ide) {
		this.ide = ide;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationYear, ide, name);
	}
	
	@Override
	public String toString() {
		return String.format("Language %s - Created in %d - IDE: %s", name, creationYear, ide);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteLanguage other = (FavoriteLanguage) obj;
		return creationYear == other.creationYear && Objects.equals(ide, other.ide) && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(FavoriteLanguage favoriteLanguage) {
		int name = this.getName().compareTo(favoriteLanguage.getName());
		if(name != 0) return name;
		
		return Integer.compare(this.getCreationYear(), favoriteLanguage.getCreationYear());
	}

} // class FavoriteLanguage
