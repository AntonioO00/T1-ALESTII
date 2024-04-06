package Calculo;

import java.util.*;

public class CalculoRota {
    char[][] tetris;

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



    int i = coordenada();
    int j ;
    public void leMatriz() {

        for ( i = coordenada(); tetris[i][j] =='#' ; i++) {
            for (j = 0 ; tetris[i][j] =='#'; j++) {//muda para cima e segue pra cima
                if(tetris[i][j] == '-'){

                }

                if (tetris[i][j] == '-'){

            }

            }
        }
    }


    public void calculo() {
        System.out.println(coordenada() + 1);
    }
}
