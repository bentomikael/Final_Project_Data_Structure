Caros,

Como falei na aula, como trabalho final da disciplina, propus a implementação de um esquema de indexação complementar Multilista ou Lista Invertida (vocês escolhem).

A ideia é que vocês identifiquem um problema e implementem a solução usando multilista ou lista invertida, com no mínimo 3 diretórios.

A solução vai ter que oferecer:

- uma estrutura (de livre escolha) que mantenha os dados e que permita a busca por identificador único. Os elementos devem ter diversos campos, inclusive 3 que permitam busca por critérios (como visto em aula, p.ex, matrícula+nome+curso+cidade de origem+time que torce - esses 3 últimos podem ser usados para consultas por critérios).

- para fazer a consulta por critérios sobre essa estrutura implementada, também será necessário implementar 3 diretórios em 3 campos diferentes, para permitir consultas por critério (todos os que atendem determinado critério). Desses 3 diretórios, ao menos 1 deve ser de dados contínuos e os demais, de dados discretos.

- com esses 3 diretórios, oferecer não só a busca simples, mas também opções para buscas combinadas (A e B), (A e C) e (B e C). Ou seja, o programa deverá indexar, no mínimo 3 colunas de dados do conjunto, oferecendo busca simples a partir das 3 colunas bem como busca composta por 2 das colunas. Exemplos de busca simples: torcedores do Figueirense, estudantes oriundos de Criciúma, etc. Exemplo de busca composta: torcedores do Figueirense que tem salário entre x e y (dados contínuos).


A solução do problema deverá ter uma opção de "carga de dados", em que um conjunto prévio de dados será introduzido na estrutura de dados escolhida, bem como uma opção para inclusão de novos dados pelo usuário (ou seja, eu).

O usuário deve poder executar as seguintes operações:
- carga de dados (pode ser uma série de comandos de inclusão, pré-definidos no próprio código ou ler alguma coisa do disco)
- busca simples -> escolha de uma coluna de dados e especificação de um valor para busca -> com exibição do resultado da busca (exemplo: escolha da coluna Times, seguido da especificação do time "Figueirense")
- busca composta -> especificação de dois valores para a busca -> com exibição do resultado da busca
- inclusão de novo elemento
- remoção de elemento existente
- exibir todos os dados

Essas operações serão feitas a partir de uma interface com menus - gráfica ou não, não importa

O trabalho final da disciplina deve obedecer a seguinte orientação:
- deve ser implementado por uma equipe de até 2 integrantes (sem choro)
- deve ser implementado em uma linguagem de programação de alto nível, obedecendo preceitos de boa programação e de orientação a objetos
- deve ser entregue funcionando e com todos os arquivos necessários para a avaliação do professor quanto ao funcionamento, permitindo que seja compilado em ambiente padrão
- deve ser acompanhado por documentação que apresente, no mínimo: o projeto de solução do problema e as decisões de projeto ("escolhemos usar multilista porque blablabla", "dividimos em 3 classes x, y e z porque assim blebleblé"...), a modularização adotada. As decisões devem ser não somente descritas, mas justificadas/defendidas.

Para entregar, coloquem tudo em um único arquivo .ZIP ou equivalente e submetam aqui pelo moodle.
