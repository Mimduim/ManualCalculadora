package com.mimduim.manualcalculadora;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mimduim on 06/05/2017.
 */

public class Interacoes {

    public Operacoes ope;
    public String string, temporario, resposta = "";
    public List<Double> adicaolist, subtracaolist,
            divisaolist, multiplicacaolist,
            porcentagemlist, sqrtlist;

    public Interacoes() {
        ope = new Operacoes();
        adicaolist = new ArrayList<>();
        subtracaolist = new ArrayList<>();
        divisaolist = new ArrayList<>();
        multiplicacaolist = new ArrayList<>();
        porcentagemlist = new ArrayList<>();
        sqrtlist = new ArrayList<>();
    }

    public String setValores(String stringnum1, String stringnum2, String aux) {

        string = stringnum2;
        switch (stringnum2) {
            case "C": {
                aux = "0";
                string = "";
                return aux;
            }
            case "=": {
                return "0";
            }
            case "◄": {
                aux = stringnum1;
                if (!aux.isEmpty()) aux = aux.substring(0, aux.length() - 1);
                return aux;
            }
            case "+": {
                adicaolist.add(Double.parseDouble(stringnum1));
                temporario = String.valueOf(adicaolist.get(0));
                aux = "0";
                return aux;
            }
            case "-": {
                subtracaolist.add(Double.parseDouble(stringnum1));
                temporario = String.valueOf(subtracaolist.get(0));
                aux = "0";
                return aux;
            }
            case "÷": {
                divisaolist.add(Double.parseDouble(stringnum1));
                temporario = String.valueOf(divisaolist.get(0));
                aux = "0";
                return aux;
            }
            case "×": {
                multiplicacaolist.add(Double.parseDouble(stringnum1));
                temporario = String.valueOf(multiplicacaolist.get(0));
                aux = "0";
                return aux;
            }
            case "√": {
                sqrtlist.add(Double.parseDouble(stringnum1));
                return resposta = ope.sqrt(sqrtlist);
            }
            case "٪": {
                porcentagemlist.add(Double.parseDouble(temporario));
                porcentagemlist.add(Double.parseDouble(stringnum1));
                string = ope.porcentagem(porcentagemlist);
                return ope.porcentagem(porcentagemlist);
            }
            default: {
                aux = stringnum1 + stringnum2;
                return aux;
            }
        }
    }

    public String getResposta() {
        resposta = "0";
        if (divisaolist.isEmpty() == false && multiplicacaolist.isEmpty() == false &&
                adicaolist.isEmpty() == false && subtracaolist.isEmpty() == false) {
            divisaolist.add(Double.parseDouble(string));
            resposta = ope.divisao(divisaolist);
            multiplicacaolist.add(Double.parseDouble(resposta));
            resposta = ope.multiplicacao(multiplicacaolist);
            adicaolist.add(Double.parseDouble(resposta));
            resposta = ope.adicao(adicaolist);
            subtracaolist.add(Double.parseDouble(resposta));
            resposta = ope.subtracao(subtracaolist);
        } else if (divisaolist.isEmpty() == false && multiplicacaolist.isEmpty() == false &&
                adicaolist.isEmpty() == false) {
            divisaolist.add(Double.parseDouble(string));
            resposta = ope.divisao(divisaolist);
            multiplicacaolist.add(Double.parseDouble(resposta));
            resposta = ope.multiplicacao(multiplicacaolist);
            adicaolist.add(Double.parseDouble(resposta));
            resposta = ope.adicao(adicaolist);
        } else if (divisaolist.isEmpty() == false && multiplicacaolist.isEmpty() == false) {
            divisaolist.add(Double.parseDouble(string));
            resposta = ope.divisao(divisaolist);
            multiplicacaolist.add(Double.parseDouble(resposta));
            resposta = ope.multiplicacao(multiplicacaolist);
        } else if (divisaolist.isEmpty() == false && adicaolist.isEmpty() == false) {
            divisaolist.add(Double.parseDouble(string));
            resposta = ope.divisao(divisaolist);
            adicaolist.add(Double.parseDouble(resposta));
            resposta = ope.adicao(adicaolist);
        } else if (divisaolist.isEmpty() == false && subtracaolist.isEmpty() == false) {
            divisaolist.add(Double.parseDouble(string));
            resposta = ope.divisao(divisaolist);
            subtracaolist.add(Double.parseDouble(resposta));
            resposta = ope.subtracao(subtracaolist);
        } else if (multiplicacaolist.isEmpty() == false && adicaolist.isEmpty() == false) {
            multiplicacaolist.add(Double.parseDouble(string));
            resposta = ope.multiplicacao(multiplicacaolist);
            adicaolist.add(Double.parseDouble(resposta));
            resposta = ope.adicao(adicaolist);
        } else if (multiplicacaolist.isEmpty() == false && subtracaolist.isEmpty() == false) {
            multiplicacaolist.add(Double.parseDouble(string));
            resposta = ope.multiplicacao(multiplicacaolist);
            subtracaolist.add(Double.parseDouble(resposta));
            resposta = ope.subtracao(subtracaolist);
        } else if (adicaolist.isEmpty() == false && subtracaolist.isEmpty() == false) {
            adicaolist.add(Double.parseDouble(string));
            resposta = ope.adicao(adicaolist);
            subtracaolist.add(Double.parseDouble(resposta));
            resposta = ope.subtracao(subtracaolist);
        } else if (divisaolist.isEmpty() == false) {
            divisaolist.add(Double.parseDouble(string));
            resposta = ope.divisao(divisaolist);
        } else if (multiplicacaolist.isEmpty() == false) {
            multiplicacaolist.add(Double.parseDouble(string));
            resposta = ope.multiplicacao(multiplicacaolist);

        } else if (adicaolist.isEmpty() == false) {
            adicaolist.add(Double.parseDouble(string));
            resposta = ope.adicao(adicaolist);

        } else if (subtracaolist.isEmpty() == false) {
            subtracaolist.add(Double.parseDouble(string));
            resposta = ope.subtracao(subtracaolist);
        }else if (porcentagemlist.isEmpty() == false) {
            porcentagemlist.add(Double.parseDouble(string));
            resposta = ope.subtracao(subtracaolist);
        }
        string = "";
        divisaolist.clear();
        multiplicacaolist.clear();
        adicaolist.clear();
        subtracaolist.clear();
        return resposta;
    }
}