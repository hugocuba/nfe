package br.com.nfe.model;

import java.util.ArrayList;
import java.util.List;

public class Nota {
	private Integer idNota;
	private Pessoa emitente;
	private List<Produto> produtos = new ArrayList<>();
	private boolean consumidorFinal;
}
