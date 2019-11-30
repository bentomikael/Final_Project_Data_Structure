package br.ufsc.ine5609.controle;

public class ControleEntradaSaida {
    private static final ControleEntradaSaida INSTANCE = new ControleEntradaSaida();

    private ControleEntradaSaida() {
    }

    public static ControleEntradaSaida getInstance() {
        return INSTANCE;
    }


}
