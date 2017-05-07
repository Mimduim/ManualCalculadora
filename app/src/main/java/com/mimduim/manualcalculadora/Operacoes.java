package com.mimduim.manualcalculadora;

import java.util.List;

public class Operacoes {
    private double resp;


    public Operacoes(){}

    public String adicao(List<Double> list) {
        Double temp = 0.0;
        for (int i=0; i<list.size(); i++){
            temp += list.get(i);
        }
        resp = temp;
        return String.valueOf(resp);
    }

    public String subtracao(List<Double> list) {
        Double temp = list.get(0);
        for (int i=1; i<list.size(); i++){
            temp -= list.get(i);
        }
        resp = temp;
        return String.valueOf(resp);
    }

    public String divisao(List<Double> list) {
        Double temp = list.get(0);
        for (int i=1; i<list.size(); i++){
            temp /= list.get(i);
        }
        resp = temp;
        return String.valueOf(resp);
    }

    public String multiplicacao(List<Double> list) {
        Double temp = list.get(0);
        for (int i=1; i<list.size(); i++){
            temp *= list.get(i);
        }
        resp = temp;
        return String.valueOf(resp);
    }

    public String porcentagem(List<Double> list) {
        resp = (list.get(0) * (list.get(1) / 100));
        if (resp == 0.0)
            return "0";
        else
        return String.valueOf(resp);
    }

    public String sqrt(List<Double> list) {
        resp = Math.sqrt(list.get(0));
        if (resp == 0.0)
            return "0";
        else
        return String.valueOf(resp);
    }
}
