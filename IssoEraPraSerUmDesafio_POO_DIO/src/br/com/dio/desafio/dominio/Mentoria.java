package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
	
	LocalDate data;
	
	public Mentoria() {
		super();
	}

	public Mentoria(String titulo, String descricao, LocalDate data) {
		super(titulo, descricao);
		this.data = data;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Mentoria [titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", data=" + data + "]";
	}

	@Override
	public double calcularXp() {
		return XP_PADRAO + 20d;
	}

} // class Mentoria
