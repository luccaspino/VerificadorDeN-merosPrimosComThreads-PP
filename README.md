O objetivo desse projeto em java é desenvolver um programa que faça a verificação de números primos e que também demonstre a diferença de desempenh obtida na implementação sequencial quando em relação a programação paralela de 5 até 10 threads. Então, temos como entrada um txt "Entrada01.txt" com 50.000 linhas todas possuindo um número primo, assim, cabendo a aplicação gerar como saída a lista na mesma ordem, porém, com apenas os números primos da lista original.
A partir disso, foram desenvolvidas 3 implementações:
1. Implementação usando o modelo de programação sequencial (uma thread)
2. Implementação de um modelo de programação paralela usando 5 threads
3. Implementação de um modelo de programação paralela usando 10 threads

E, posto isso, realização de um relatório que detalhe a implementação do projeto java e das classses e dos tempos de execução com um gráfico comparativo pela saída de cada implementação.

1 Implementação



1.1 Implementação Sequencial

Para a implementação do modelo de programação sequencial, foi utilizada a classe VerificaPrimos.java. O tempo de execução foi medido com o método System.nanoTime(), que registra o tempo inicial e final, permitindo calcular a duração total. Para leitura e escrita dos arquivos de entrada e saída, foram utilizados BufferedReader e BufferedWriter, respectivamente, garantindo leitura e escrita no manuseio de dados. O método  verificaPrimo(int numero) é responsável por verificar se um número é primo. Ele começa verificando se o número é menor ou igual a 1, retornando false nesses casos, pois números primos são maiores que 1. Em seguida, itera em laço de 2 até a raiz quadrada do número (i * i <= numero), e se o número for divisível por qualquer valor nesse intervalo, retorna false, indicando que não é primo. Caso nenhum divisor seja encontrado, retorna true, confirmando que o número é primo. Esse método é mais eficiente, pois limita o loop até a raiz quadrada do número em vez de iterar até o próprio número.

