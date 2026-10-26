package br.com.carstore.model;

public class Car {
    private String id;
    private String nome;

    public Car(String nome){
        this.nome = nome;
    }

    public Car(String id, String nome){
        this.id = id;
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
