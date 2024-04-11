package Calculo;

public class CalculoRota {
    char[][] matriz;
    Long somador = 0L;
    int i;
    int j;

    public CalculoRota(char[][] matriz) {
        this.matriz = matriz;
    }

    public int coordenada() {
        int linha = 0;
        for (int i = 0; i < matriz.length - 1; i++) {
            if (matriz[i][0] == '-') {
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

        i = coordenada();
        j = 0;
        boolean x = true;
        boolean[][] processed = new boolean[matriz.length][matriz[0].length];


        while (matriz[i][j] != '#') {

            //Corre para a direita
            while (x == true) {
                // Confirma se nao chegou ao fim
                if (matriz[i][j] == '#') {
                    return somador;
                }

                if (!processed[i][j]) {
                    // Marca o elemento como processado
                    processed[i][j] = true;

                    //Sobe
                    if (matriz[i][j] == '/') {
                        i--;
                        while (matriz[i][j] != '/' && matriz[i][j] != '\\') {
                            if (Character.isDigit(matriz[i][j])) {
                                somaNumeros(i, j, "cima");
                            }
                            if (matriz[i][j] == '#') {
                                return somador;
                            }
                            i--;
                        }
                        //Volta para esquerda depois de subir
                        if (matriz[i][j] == '\\') {
                            x = false;
                            j -= 2;
                        }
                    }

                    //Desce
                    if (matriz[i][j] == '\\') {
                        i++;
                        while (matriz[i][j] != '/' && matriz[i][j] != '\\') {
                            if (Character.isDigit(matriz[i][j])) {
                                somaNumeros(i, j, "baixo");
                            }
                            if (matriz[i][j] == '#') {
                                return somador;
                            }

                            i++;

                        }
                        //volta esquerada depois de descer
                        if (matriz[i][j] == '/') {
                            x = false;
                            j -= 2;
                        }
                    }
                    //Segue pela direita caso nao precise subir ou descer
                    if (Character.isDigit(matriz[i][j])) {
                        somaNumeros(i, j, "direita");
                    }
                    j++;

                }
            }

            //Corre para a esquerda
            while (x == false) {

                if (matriz[i][j] == '#') {
                    return somador;
                }
                if (!processed[i][j]) {
                    // Marca o elemento como processado
                    processed[i][j] = true;

                    //sobe
                    if (matriz[i][j] == '\\') {
                        i--;
                        while (matriz[i][j] != '/' && matriz[i][j] != '\\') {
                            if (Character.isDigit(matriz[i][j])) {
                                somaNumeros(i, j, "cima");
                            }
                            if (matriz[i][j] == '#') {
                                return somador;
                            }
                            i--;
                        }
                        if (matriz[i][j] == '/') {
                            x = true;
                            j += 2;
                        }
                    }
                    //Desce
                    if (matriz[i][j] == '/') {
                        i++;
                        while (matriz[i][j] != '/' && matriz[i][j] != '\\') {
                            if (Character.isDigit(matriz[i][j])) {
                                somaNumeros(i, j, "baixo");

                            }
                            if (matriz[i][j] == '#') {
                                return somador;
                            }
                            i++;
                        }
                        if (matriz[i][j] == '\\') {
                            x = true;
                            j += 2;
                        }
                    }
                    //segue esquerda
                    if (Character.isDigit(matriz[i][j])) {
                        somaNumeros(i, j, "esquerda");
                    }
                    j--;
                }

            }
        }
        return somador;
    }


    public void somaNumeros(int l, int c, String estado) {
        StringBuilder acumula = new StringBuilder();
        try {
            if (estado.equals("cima")) {
                while (l >= 0 && Character.isDigit(matriz[l][c])) {
                    acumula.insert(0, matriz[l][c]);
                    l--;
                }
            } else if (estado.equals("baixo")) {
                while (l < matriz.length && Character.isDigit(matriz[l][c])) {
                    acumula.append(matriz[l][c]);
                    l++;
                }
            } else if (estado.equals("esquerda")) {
                while (c >= 0 && Character.isDigit(matriz[l][c])) {
                    acumula.insert(0, matriz[l][c]);
                    c--;
                }
            } else if (estado.equals("direita")) {
                while (c < matriz[0].length && Character.isDigit(matriz[l][c])) {
                    acumula.append(matriz[l][c]);
                    c++;
                }
            } else {
                System.err.println("Estado inválido.");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro: Índice fora dos limites da matriz.");
            return;
        }

        try {
            if (acumula.length() > 1) {

                somador += Long.parseLong(acumula.toString());
            } else {

                somador += Character.getNumericValue(acumula.charAt(0));
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter String para Long.");
        }
    }

}




