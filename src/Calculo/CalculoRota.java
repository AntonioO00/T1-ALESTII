package Calculo;

import java.util.Arrays;

public class CalculoRota {
    char[][] tetris;
    int i, j = 0;

    public CalculoRota(char[][] matriz) {
        tetris = matriz;
    }

    public int coordenada() {
        int linha = 0;
        for (int i = 0; i < tetris.length - 1; i++) {
            if (tetris[i][0] == '-') {
                linha = i;
            }
        }
        return linha;
    }

    public void calculo() {
        System.out.println(coordenada() + 1);
    }


    public long LeituraMatriz() {

        int i = coordenada();
        int j = 0;
        boolean x = true;
        long somador = 0;
        char[] partes = new char[90];
        int c = 0;

        String valor = "";

        while (tetris[i][j] == '#') {

            //corre pra direita
            while (x == true) {
               //arrumar awui pasghvoisdhjgovigajdspgvgjdspgkzposkgpokd´psagkpodskgopsdkgpoksdpzfkl´pds
                if ((tetris[i][j + 1] != '/' || tetris[i][j + 1] != '\\')) {
                    while ((tetris[i][j] != '/' || tetris[i][j] != '\\'))
                        if (Character.isDigit(tetris[i][j])) {
                            partes[c] = tetris[i][j];
                            c++;
                        }
                }

                //sobe
                if (tetris[i][j] == '/') {
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            partes[c] = tetris[i][j];
                            c++;
                        }
                        i--;
                    }
                    if (tetris[i][j + 1] == '\\') {
                        x = false;
                        j--;
                    }
                }
                //desce
                if (tetris[i][j] == '\\') {
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            partes[c] = tetris[i][j];
                            c++;
                        }
                        i++;
                    }
                    if (tetris[i][j + 1] == '/') {
                        x = false;
                        j--;
                    }
                }
                if (tetris[i][j + 1] == '/' || tetris[i][j + 1] == '\\') {
                    Arrays.fill(partes, '\0');
                    c = 0;
                }
                j++;
            }
            if (x == true) {
                for (c = 0; c <= partes.length; c++) {
                    somador += partes[c];
                }
                c = 0;
            }


            //corre pra esquerda
            while (x == false) {
// arrumar aqui tbm foasjfcoisafkjvpodsjgpokdspvbósfkagpbofjsgopbkjaf´sogbkpofdakbjófkladb´pfkdapobkfd´pabk
                if ((tetris[i][j + 1] != '/' || tetris[i][j + 1] != '\\')) {
                    if (Character.isDigit(tetris[i][j])) {
                        partes[c] = tetris[i][j];
                        c++;
                    }
                }

                //sobe
                if (tetris[i][j] == '\\') {
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            partes[c] = tetris[i][j];
                            c++;
                        }
                        i--;
                    }
                    if (tetris[i][j + 1] == '/') {
                        x = true;
                        j++;
                    }
                }
                //desce
                if (tetris[i][j] == '/') {
                    while (tetris[i][j + 1] != '/' || tetris[i][j + 1] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            partes[c] = tetris[i][j];
                            c++;
                        }
                        i++;
                    }
                    if (tetris[i][j + 1] == '\\') {
                        x = false;
                        j++;
                    }
                }

                /*if (tetris[i][j + 1] == '/' || tetris[i][j + 1] == '\\') {
                    Arrays.fill(partes, '\0');
                    c = 0;
                }*/
                j--;
            }
            if (x == false) {
                inverterArray(partes);
                for (int k = 0; k <= partes.length; k++)
                    somador += partes[k];
                c = 0;
            }

        }
        return somador;

    }

    public static char[] inverterArray(char[] array) {
        int tamanho = array.length;
        char[] arrayInvertido = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arrayInvertido[i] = array[tamanho - 1 - i];
        }
        return arrayInvertido;
    }

    //matar o victor por usar char 

}
