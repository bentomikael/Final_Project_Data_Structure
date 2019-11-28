package br.ufsc.ine5609;

// classe para ser invocada sempre que precisar dessas strings fixas
public class Constantes{
    private static final Constantes INSTANCE = new Constantes();


    //Centros
    public static final String CTC = "CTC";
    public static final String CCS = "CCS";
    public static final String CFH = "CFH";
    public static final String CCE = "CCE";

    //Cursos
    public static final String ADMINISTRACAO = "Administracao";
    public static final String SISTEMAS = "Sistemas";
    public static final String COMPUTACAO = "Computacao";
    public static final String ENGENHARIA = "Engenharia";

    //cotas?
    public static final String SIM = "Sim";
    public static final String NAO = "Não";

    public static final String[] TODOS_CURSOS = new String[]{
            ADMINISTRACAO,
            SISTEMAS,
            COMPUTACAO,
            ENGENHARIA
    };
    public static final String[] TODOS_CENTROS = new String[]{
            CTC,
            CCS,
            CFH,
            CCE
    };
}
