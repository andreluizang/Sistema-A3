package models;

import java.time.LocalDate;

public class Atividade {
    private int id;
    private String nome;
    private String descricao;
    private Disciplina disciplina;
    private LocalDate prazo;
    private LocalDate dataconclusao;
    private boolean concluida;
    private double nota;
    private double notaMax;
    private String nomeDisciplina;
    
    public Atividade(int id, String nome, String descricao, Disciplina disciplina, LocalDate prazo, LocalDate dataConclusao,
            boolean concluida, double nota, double notaMax){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.disciplina = disciplina;
        nomeDisciplina = disciplina.getNome();
        this.prazo = prazo;
        this.dataconclusao = dataConclusao;
        this.concluida = concluida;
        this.nota = nota;
        this.notaMax = notaMax;
    }

    public Atividade(String nome, String descricao, Disciplina disciplina, LocalDate prazo, boolean concluida) {
        this.nome = nome;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.prazo = prazo;
        this.concluida = concluida;
    }

    public Atividade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(LocalDate dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getNotaMax() {
        return notaMax;
    }

    public void setNotaMax(double notaMax) {
        this.notaMax = notaMax;
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
    
    public String getNomeDisciplina(){
        return nomeDisciplina;
    }
    
    public void setNomeDisciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
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
