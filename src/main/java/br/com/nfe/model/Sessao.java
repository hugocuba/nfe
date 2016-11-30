package br.com.nfe.model;

public class Sessao {

    private static Sessao instance = null;
    private Login usuario;
    private Emitente emitente;

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    private Sessao() {
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public Login getUsuario() {
        return usuario;
    }

    public static Sessao getInstance() {
        if (instance == null) {
            instance = new Sessao();
        }
        return instance;
    }
}
