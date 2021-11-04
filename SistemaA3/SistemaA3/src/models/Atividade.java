package models;

import java.time.LocalDate;

public class Atividade {
    private String nome;
    private String descricao;
    private Disciplina disciplina;
    private LocalDate prazo;
    private boolean concluida;

    public Atividade(String nome, String descricao, Disciplina disciplina, LocalDate prazo, boolean concluida) {
        this.nome = nome;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.prazo = prazo;
        this.concluida = concluida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }  
    
}
