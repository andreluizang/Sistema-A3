package models;

import java.util.ArrayList;

public class Disciplina {
    
    private int id;
    private String nome;
    private ArrayList<Atividade> atividades;
    private ArrayList<Conteudo> conteudos;

    public Disciplina(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
