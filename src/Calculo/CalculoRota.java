package Calculo;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class CalculoRota {
    char[][] tetris;
    int i, j = 0;
    Long somador = 0L;
    String valores = "";

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

    public Long getSomador() {
        return somador;
    }

    public Long LeituraMatriz() {

        int i = coordenada();
        int j = 0;
        boolean x = true;

        while (tetris[i][j] != '#') {

            //corre pra direita
            while (x == true) {

                if (tetris[i][j] == '#') {
                    return somador;
                }
                //subindo
                if (tetris[i][j] == '/') {
                    i--;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            sequencia(i, j, "cima");
                        }
                        if (tetris[i][j] == '#') {
                            return somador;
                        }
                        i--;
                    }
                    //volta esquerda subindo
                    if (tetris[i][j] == '\\') {
                        x = false;
                        j -= 2;
                    }
                }

                //desce
                if (tetris[i][j] == '\\') {
                    i++;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            sequencia(i, j, "baixo");
                        }
                        if (tetris[i][j] == '#') {
                            return somador;
                        }

                        i++;

                    }
                    //volta esquerada descendo
                    if (tetris[i][j] == '/') {
                        x = false;
                        j -= 2;
                    }
                }
                //continua direita se nao tiver subindo ou descendo
                if (Character.isDigit(tetris[i][j])) {
                    sequencia(i, j, "direita");
                }
                j++;

            }


            //corre pra esquerda
            while (x == false) {

                if (tetris[i][j] == '#') {
                    return somador;
                }
                //sobe
                if (tetris[i][j] == '\\') {
                    i--;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            sequencia(i, j, "cima");

                        }
                        if (tetris[i][j] == '#') {
                            return somador;
                        }
                        i--;
                    }
                    if (tetris[i][j] == '/') {
                        x = true;
                        j += 2;
                    }
                }
                //desce
                if (tetris[i][j] == '/') {
                    i++;
                    while (tetris[i][j] != '/' && tetris[i][j] != '\\') {
                        if (Character.isDigit(tetris[i][j])) {
                            sequencia(i, j, "baixo");

                        }
                        if (tetris[i][j] == '#') {
                            return somador;
                        }
                        i++;
                    }
                    if (tetris[i][j] == '\\') {
                        x = true;
                        j += 2;
                    }
                }
                //segue esquerda
                if (Character.isDigit(tetris[i][j])) {
                    sequencia(i, j, "esquerda");

                }
                j--;

            }
        }
        return somador;
    }


    public void sequencia(int i, int j, String estado) {
        String acumula = "";

        if (estado.equals("cima")) {
            while (Character.isDigit(tetris[i][j])) {
                acumula += String.valueOf(tetris[i][j]);
                i--;
            }
        }
        if (estado.equals("baixo")) {
            while (Character.isDigit(tetris[i][j])) {
                acumula += String.valueOf(tetris[i][j]);
                i++;
            }
        }
        if (estado.equals("esquerda")) {
            while (Character.isDigit(tetris[i][j])) {
                acumula += String.valueOf(tetris[i][j]);
                j--;
            }
            reverseString(acumula);
        }
        if (estado.equals("direita")) {
            while (Character.isDigit(tetris[i][j])) {
                acumula += String.valueOf(tetris[i][j]);
                j++;
            }
        }
        System.out.println(acumula);

        somador+= Long.parseLong(acumula);

    }

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}




