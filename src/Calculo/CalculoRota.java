package Calculo;

public class CalculoRota {
    char[][] tetris;

    public CalculoRota(char[][] matriz) {
        tetris = matriz;
    }

    public int coordenada() {
        for (int i = 0; i<tetris[i][0]; i++)
        for (int j = 0; j < tetris[j].length; j++) {
                if(tetris[j][i] == '-'){
                    return tetris[j][i];
            }
        }
        return 0;
    }

    public void calculo() {
        System.out.println(coordenada());
    }
}
