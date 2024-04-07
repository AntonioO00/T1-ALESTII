import Calculo.CalculoRota;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        char[][] matriz;
        String teste = "casosdeteste/casoC50.txt";

        try {
            // Leitura da primeira linha
            BufferedReader pr = new BufferedReader(new FileReader(teste));
            String primeiraLinha = pr.readLine();
            System.out.println(primeiraLinha);
            pr.close();

            //Definindo o tamanho da matriz de acordo com o valor passado na primeira linha
            String[] tamanhoMatriz = primeiraLinha.split(" ");
            int linhasMatriz = Integer.parseInt(tamanhoMatriz[0]);
            int colunasMatriz = Integer.parseInt(tamanhoMatriz[1]);
            matriz = new char[linhasMatriz][colunasMatriz];

            //Leitura de todo o arquivo
            BufferedReader br = new BufferedReader(new FileReader(teste));
            String leitura;
            int linha = 0;
            while ((leitura = br.readLine()) != null && linha < linhasMatriz) {
                for (int coluna = 0; coluna < leitura.length() && coluna < colunasMatriz; coluna++) {
                    matriz[linha][coluna] = leitura.charAt(coluna);
                }
                linha++;
            }

            // exibindo toda matriz
            for (int i = 0; i < linhasMatriz; i++) {
                for (int j = 0; j < colunasMatriz; j++) {
                    System.out.print(matriz[i][j]);
                }
                System.out.println();
            }
            CalculoRota calculoRota = new CalculoRota(matriz);
            calculoRota.calculo();
            System.out.println(calculoRota.LeituraMatriz());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}