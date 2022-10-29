package br.com.presidentes;

public class OpcaoVoto {

    private String nome;
    private Integer numero;
    private int quantidadeVotos;

    public String getNome() {
        return this.nome;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public int getQuantidadeVotos() {
        return this.quantidadeVotos;
    }

    public static OpcaoVoto criarOpcao(String nome, Integer numero){
        OpcaoVoto opcaoVoto = new OpcaoVoto();
        opcaoVoto.nome = nome;
        opcaoVoto.numero = numero;
        opcaoVoto.quantidadeVotos = 0;
        return opcaoVoto;
    }

    public void contabilizarVoto() {
        this.quantidadeVotos++;
    }


}
