
import java.io.*;
import java.lang.*;
import java.lang.Exception;


public class Exemplo{

    public static void main(String[] args) {
        char[][] matriz = new char[50][50];

        String arquivo = "casosdeteste/casoC50.txt" ;

        // Ler o arquivo e preencher a matriz
        try  {

            BufferedReader br = new BufferedReader(new FileReader(arquivo));
             String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                for (int col = 0; col < 50 && col < line.length(); col++) {
                    matriz[row][col] = line.charAt(col);
                }
                row++;
            }
        } catch (Exception e) {
            ;
            return;
        }

        // Aplicar as mudanças conforme especificado
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (matriz[i][j] == '\\') {
                    // Mudar para baixo
                    if (i + 1 < 50) {
                        matriz[i][j] = ' ';
                        matriz[i + 1][j] = '\\';
                    }
                } else if (matriz[i][j] == '/') {
                    // Mudar para a esquerda
                    if (j - 1 >= 0) {
                        matriz[i][j] = ' ';
                        matriz[i][j - 1] = '/';
                    }
                } else if (matriz[i][j] == '/') {
                    // Mudar para cima
                    if (i - 1 >= 0) {
                        matriz[i][j] = ' ';
                        matriz[i - 1][j] = '/';
                    }
                } else if (matriz[i][j] == '\\') {
                    // Mudar para a direita
                    if (j + 1 < 50) {
                        matriz[i][j] = ' ';
                        matriz[i][j + 1] = '\\';
                    }
                }
            }
        }

        // Imprimir a matriz após as mudanças
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
