import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Program {

	public static void main(String[] args) {
		Curso curso1 = new Curso("Curso Java", "Descrição Curso Java", 8);
		Curso curso2 = new Curso("Curso JavaScript", "Descrição Curso JavaScript", 6);
		
		Mentoria mentoria1 = new Mentoria("Mentoria Java", "Descrição Mentoria Java", LocalDate.now());
//		Mentoria mentoria2 = new Mentoria("Mentoria JavaScript", "Descrição Mentoria JavaScript", LocalDate.now());
//		
//		Conteudo conteudo1 = new Curso();
//		Conteudo conteudo2 = new Mentoria();
		
		Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria1);
		
		Dev devVinicius = new Dev("Vinicius");
		Dev devJose = new Dev("José");
		
		devVinicius.inscreverBootcamp(bootcamp);
		devJose.inscreverBootcamp(bootcamp);
		
		System.out.println("Conteúdos Inscritos Vinicius : " + devVinicius.getConteudoInscritos());
		devVinicius.progredir();
		System.out.println("Conteúdos Inscritos Vinicius : " + devVinicius.getConteudoInscritos());
		System.out.println("Conteúdos Concluídos Vinicius: " + devVinicius.getConteudoConcluidos());
		System.out.println("XP: " + devVinicius.calcularTotalXp());
		
		System.out.println("\nConteúdos Inscritos José     : " + devJose.getConteudoInscritos());
		devJose.progredir();
		devJose.progredir();
		devJose.progredir();
		System.out.println("Conteúdos Inscritos José     : " + devJose.getConteudoInscritos());
		System.out.println("Conteúdos Concluídos José    : " + devJose.getConteudoConcluidos());
		System.out.println("XP: " + devJose.calcularTotalXp());
		
	} // main()
	
} // class Program
