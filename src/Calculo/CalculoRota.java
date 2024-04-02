package Calculo;

public class CalculoRota {
    char[][] tetris;

    public CalculoRota(char[][] matriz) {
        tetris = matriz;
    }

    public int coordenada() {
    int linha= 0;
     for(int i=0; i <tetris.length-1; i++){
        if (tetris[i][0] == '-') {
            linha = i;
        }
     }
     return linha ;
    }

    public void calculo() {
        System.out.println(coordenada()+1);
    }
}
