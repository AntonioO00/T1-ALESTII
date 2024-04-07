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

        System.out.println("tetris[i][j] gamde");
        int i = coordenada();
        int j = 0;
        boolean x = true;
        String valores = "";


        while (tetris[i][j] != '#') {

            //corre pra direita
            while (x == true) {

                if (tetris[i][j] == '#') {
                    System.out.println("Final");
                }
                //subindo
                if (tetris[i][j] == '/') {
                    i--;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            valores += String.valueOf(tetris[i][j]);
                            //aqui
                        }
                        System.out.println("Subiu");
                        if (tetris[i][j] == '#') {
                            System.out.println("Final");
                        }
                        i--;
                    }
                    //volta esquerda subindo
                    if (tetris[i][j] == '\\') {
                        x = false;
                        j -= 2;
                        System.out.println("foi pra esquerda subindo");
                    }
                }

                //desce
                if (tetris[i][j] == '\\') {
                    i++;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            valores = String.valueOf(tetris[i][j]);
                        }
                        System.out.println("Desceu");
                        i++;
                        if (tetris[i][j] == '#') {
                            System.out.println("Final");
                        }
                    }
                    //volta esquerada descendo
                    if (tetris[i][j] == '/') {
                        System.out.println("chueguei");
                        x = false;
                        j -= 2;
                        System.out.println("foi pra esquerda descendo");
                    }
                }
                //continua direita se nao tiver subindo ou descendo
                if (Character.isDigit(tetris[i][j])) {
                    valores = String.valueOf(tetris[i][j]);
                }
                System.out.println("seguiu direita");
                j++;

            }


            //corre pra esquerda
            while (x == false) {
                System.out.println("false");
                if (tetris[i][j] == '#') {
                    System.out.println("Final");
                }
                //sobe
                if (tetris[i][j] == '\\') {
                    i--;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            valores = String.valueOf(tetris[i][j]);
                        }
                        if (tetris[i][j] == '#') {
                            System.out.println("Final");
                        }
                        System.out.println("subiu");
                        i--;
                    }
                    if (tetris[i][j] == '/') {
                        x = true;
                        j += 2;
                        System.out.println("foi pra direita subindo");
                    }
                }
                //desce
                if (tetris[i][j] == '/') {
                    i++;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            valores = String.valueOf(tetris[i][j]);
                        }
                        System.out.println("desceu");
                        if (tetris[i][j] == '#') {
                            System.out.println("Final");
                        }
                        i++;
                    }
                    if (tetris[i][j] == '\\') {
                        x = true;
                        j += 2;
                        System.out.println("foi pra direita descendo");
                    }
                }
                //segue esquerda
                if (Character.isDigit(tetris[i][j])) {
                    valores = String.valueOf(tetris[i][j]);
                }
                System.out.println("seguiu esquerda");
                j--;

            }
        }
        System.out.println("final");
        return somador;
    }

    public void somaTudo(boolean)


}

