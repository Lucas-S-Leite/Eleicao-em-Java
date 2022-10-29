package br.com.presidentes;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<OpcaoVoto> opcaoVotos = criarOpcoesVoto();

        Scanner scan = new Scanner(System.in);

        int cont = 0;
        while (cont < 10) {
            votar(scan.nextInt(), opcaoVotos);
            cont++;
        }

        imprimirResultado(opcaoVotos);
    }

    public static ArrayList<OpcaoVoto> criarOpcoesVoto() {
        OpcaoVoto candidato1 = OpcaoVoto.criarOpcao("Candidato 1", 1);
        OpcaoVoto candidato2 = OpcaoVoto.criarOpcao("Candidato 2", 2);
        OpcaoVoto candidato3 = OpcaoVoto.criarOpcao("Candidato 3", 3);
        OpcaoVoto candidato4 = OpcaoVoto.criarOpcao("Candidato 4", 4);
        OpcaoVoto candidato5 = OpcaoVoto.criarOpcao("Candidato 5", 5);
        OpcaoVoto nulo = OpcaoVoto.criarOpcao("Nulo", 0);

        ArrayList<OpcaoVoto> opcoes = new ArrayList<>();
        opcoes.add(candidato1);
        opcoes.add(candidato2);
        opcoes.add(candidato3);
        opcoes.add(candidato4);
        opcoes.add(candidato5);
        opcoes.add(nulo);
        return opcoes;
    }

    public static void votar(Integer voto, ArrayList<OpcaoVoto> opcaoVotos) {
        boolean votado = false;
        for(int i = 0; i < opcaoVotos.size(); i++) {
            if(opcaoVotos.get(i).getNumero() == voto) {
                opcaoVotos.get(i).contabilizarVoto();
                votado = true;
                System.out.println("Voto no " + opcaoVotos.get(i).getNome() + " computado");
            }
        }
        if(!votado) {
            opcaoVotos.get(opcaoVotos.size() - 1).contabilizarVoto();
            System.out.println("Voto nulo computado");
        }
    }

    public static void imprimirResultado(ArrayList<OpcaoVoto> opcaoVotos) {
        for(int primeiroContador = 0; primeiroContador < opcaoVotos.size(); primeiroContador++) {
            for(int segundoContador = primeiroContador + 1; segundoContador < opcaoVotos.size(); segundoContador++) {
                OpcaoVoto temporario;
                if(opcaoVotos.get(primeiroContador).getQuantidadeVotos() < opcaoVotos.get(segundoContador).getQuantidadeVotos()) {
                    temporario = opcaoVotos.get(primeiroContador);
                    opcaoVotos.set(primeiroContador, opcaoVotos.get(segundoContador));
                    opcaoVotos.set(segundoContador, temporario);
                }
            }
        }

        opcaoVotos.forEach(opcaoVoto -> {
            System.out.println(opcaoVoto.getNome() + " teve " + opcaoVoto.getQuantidadeVotos() + " votos válidos");
        });
    }
}
