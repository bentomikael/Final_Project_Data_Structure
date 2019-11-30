package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.estruturas.Diretorio;

public interface IControle {

    Diretorio defineDiretorioCentro(String centro, Diretorio[] diretorios);
    Diretorio defineDiretorioCurso(String curso, Diretorio[] diretorios);
    Diretorio defineDiretorioCotas(String cotas, Diretorio[] diretorios);

}
