package models;

public class Conteudo {
    private String nome;
    private int aprendizado;
    private String anotacao;
    private Disciplina disciplina;

    public Conteudo(String nome, int aprendizado, String anotacao, Disciplina disciplina) {
        this.nome = nome;
        this.aprendizado = aprendizado;
        this.anotacao = anotacao;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAprendizado() {
        return aprendizado;
    }

    public void setAprendizado(int aprendizado) {
        this.aprendizado = aprendizado;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
    
    
}
