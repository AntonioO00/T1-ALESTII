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
        int nojo= 0;
        int somador = 10;
        String valores = "";


        while (tetris[i][j] != '#') {
            //corre pra direita
            while (x == true) {
                System.out.println(true);

                //subindo
                if (tetris[i][j] == '/') {
                    i--;
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                      if (Character.isDigit(tetris[i][j])){
                          valores+= tetris[i][j];
                          somador+= Long.parseLong(valores);

                          System.out.println("Subiu");
                      }
                        i--;
                    }
                    //volta esquerda subindo
                    if (tetris[i][j] == '\\') {
                        x = false;
                        j-=2;
                    }
                }

                //desce
                if (tetris[i][j] == '\\') {
                    i++;
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])){
                            valores+= tetris[i][j];
                            somador+= Long.parseLong(valores);
                            System.out.println("Desceu");
                        }
                        i++;
                    }
                    //volta esquerada descendo
                    if (tetris[i][j] == '/') {
                        x = false;
                        j-=2;
                    }
                }

                //continua direita se nao tiver subindo ou descendo
                if (Character.isDigit(tetris[i][j])){
                    valores+= tetris[i][j];
                    somador+= Long.parseLong(valores);
                    System.out.println("seguiu direta");
                }
                j++;

            }


            //corre pra esquerda
            while (x == false) {

                //sobe
                if (tetris[i][j] != '\\') {
                    i--;
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])){
                            valores+= tetris[i][j];
                            somador+= Long.parseLong(valores);
                        }
                        i--;
                    }
                    if (tetris[i][j] == '/') {
                        x = true;
                        j+=2;
                    }
                }
                //desce
                if (tetris[i][j] == '/') {
                    i++;
                    while (tetris[i][j] != '/' || tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])){
                            valores+= tetris[i][j];
                            somador+= Long.parseLong(valores);
                        }
                        i++;
                    }
                    if (tetris[i][j] == '\\') {
                        x = true;
                        j+=2;
                    }
                }
                //segue esquerda
                if (Character.isDigit(tetris[i][j])){
                    valores+= tetris[i][j];
                    somador+= Long.parseLong(valores);
                }
                j--;
            }

        }

        return somador;
    }








}

