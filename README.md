O objetivo desse projeto em java é desenvolver um programa que faça a verificação de números primos e que também demonstre a diferença de desempenho obtida na implementação sequencial quando em relação a programação paralela de 5 até 10 threads. 

Feito pelo discente Luccas Pino para a matéria Sistemas Distribuídos e Programação Paralela do professor Edson Mota da Cruz.

1 Implementação

Então, temos como entrada um txt "Entrada01.txt" com 50.000 linhas todas possuindo um número primo, assim, cabendo a aplicação gerar como saída a lista na mesma ordem, porém, com apenas os números primos da lista original.
A partir disso, foram desenvolvidas 3 implementações:
1. Implementação usando o modelo de programação sequencial (uma thread)
2. Implementação de um modelo de programação paralela usando 5 threads
3. Implementação de um modelo de programação paralela usando 10 threads

E, posto isso, realização de um relatório que detalhe a implementação do projeto java e das classses e dos tempos de execução com um gráfico comparativo pela saída de cada implementação.



1.1 Implementação Sequencial

Para a implementação do modelo de programação sequencial, foi utilizada a classe "VerificaPrimos.java". O tempo de execução foi medido com o método System.nanoTime(), que registra o tempo inicial e final, permitindo calcular a duração total. Para leitura e escrita dos arquivos de entrada e saída, foram utilizados BufferedReader e BufferedWriter, respectivamente, garantindo leitura e escrita no manuseio de dados. O método  verificaPrimo(int numero) é responsável por verificar se um número é primo. Ele começa verificando se o número é menor ou igual a 1, retornando false nesses casos, pois números primos são maiores que 1. Em seguida, itera em laço de 2 até a raiz quadrada do número (i * i <= numero), e se o número for divisível por qualquer valor nesse intervalo, retorna false, indicando que não é primo. Caso nenhum divisor seja encontrado, retorna true, confirmando que o número é primo. Esse método é mais eficiente, pois limita o loop até a raiz quadrada do número em vez de iterar até o próprio número.

1.2 Implementação de um modelo de programação paralela usando 5 threads

A classe VerificaPrimosPP é a classe "entidade" dessa implementação e estende a classe Thread e é responsável por processar uma lista de números em paralelo sendo usada tanto no caso de 5 threads quanto no caso de 10 threads, verificando se cada número é primo com o mesmo método verificaPrimo. Ela recebe três parâmetros principais: uma lista de strings (linhas) contendo os números a serem processados, um índice inicial (indice0) para manter a ordem original dos números no arquivo, e um ConcurrentHashMap (saida) para armazenar os resultados de forma segura em um ambiente multithread. No método run(), a thread itera sobre a lista de números, converte cada string para inteiro, verifica se o número é primo usando o método verificaPrimo(int numero) e, caso seja primo, adiciona o resultado ao ConcurrentHashMap com a chave correspondente ao índice original. 

A classe VerificaPrimosPP5 é a classe main que implementa o processamento paralelo de números primos utilizando 5 threads. Ela começa medindo o tempo inicial com System.nanoTime() para calcular a duração total da execução. Em seguida, lê o arquivo de entrada (Entrada01.txt) usando BufferedReader e armazena todas as linhas em uma lista (qtdeLinhas). O trabalho é dividido em 5 partes iguais, e cada parte é processada por uma thread da classe VerificaPrimosPP. As threads são criadas e iniciadas, cada uma recebendo um bloco de linhas para processar e um ConcurrentHashMap para armazenar os resultados de forma segura e ordenada. Após o término de todas as threads, os resultados são escritos no arquivo de saída (Saida03.txt) na ordem original, usando BufferedWriter. Por fim, o tempo final é medido, e a duração total do processamento é calculada e exibida em milissegundos. Essa abordagem permite um processamento eficiente e paralelo com as threads, garantindo que os resultados sejam gerados corretamente e no menor tempo possível.

1.3 Implementação de um modelo de programação paralela usando 10 threads

Também foi-se utilizado a classe VerificaPrimosPP como classe base e também foi criada uma nova classe principal, a VerificaPrimosPP10, que se diferencia com os ajustes de 5 para 10 threads, esses sendo feitos no tamanho da chunk para 10 partes, no próprio array de número de thread e no laço que cria as threads.