package models;

public class Conteudo {
    private int id;
    private String nome;
    private int aprendizado;
    private String anotacao;
    private Disciplina disciplina;
    private int meta;
    //private String nomeDisciplina;

    public Conteudo(int id, String nome, int aprendizado, String anotacao, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.aprendizado = aprendizado;
        this.anotacao = anotacao;
        this.disciplina = disciplina;
        meta = calcularMetas(aprendizado);
    }
    
    private int calcularMetas(int aprendizado){
        int revisoes = 0;
        if(aprendizado == 0){
            revisoes = 5;
        }else if(aprendizado > 0 && aprendizado <= 3){
            revisoes = 4;
        }else if(aprendizado >= 4 && aprendizado <= 6){
            revisoes = 3;
        }else if(aprendizado >= 7 && aprendizado <= 9){
            revisoes = 2;
        }else if(aprendizado == 10){
            revisoes = 1;
        }
        return revisoes;
    }

    public int getId(){
        return id;
    }
    
    public void setId(){
        this.id = id;
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
    
    public int getMeta(){
        return meta;
    } 
    
    public void setMeta(int meta){
        this.meta = meta;
    }
}
