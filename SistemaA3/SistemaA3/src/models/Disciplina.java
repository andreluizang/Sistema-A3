package models;

import java.util.ArrayList;

public class Disciplina {
    
    private String nome;
    private ArrayList<Atividade> atividades;
    private ArrayList<Conteudo> conteudos;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
