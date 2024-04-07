package Calculo;

public class CalculoRota {
    char[][] tetris;
    int i = 0;
    int j = 0;
    int soma = 0;

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

    public void calculo() {System.out.println(coordenada()+1); }

    public void LeituraMatriz(){
        i = coordenada();
        j = 0;

        boolean esquerda = false;
        boolean cima = false;
        boolean baixo = false;
        boolean direita = true;

        while(tetris[i][j]=='#'){

               if(baixo && tetris[i][j] != '/' && tetris[i][j] != '\\'){MudaBaixo(i, j);}
               if(cima && tetris[i][j] != '/' && tetris[i][j] != '\\'){MudaCima(i, j);}
               if(esquerda && tetris[i][j] != '/' && tetris[i][j] != '\\'){MudaEsquerda(i, j);}
               if(direita && tetris[i][j] != '/' && tetris[i][j] != '\\'){MudaDireita(i, j);}

               if(direita && tetris[i][j] == '\\'){
                    baixo = true;
                    direita = false;
                    cima = false;
                    esquerda= false;
                    MudaBaixo(i,j);
                }

                if(direita && tetris[i][j] == '/'){
                    baixo = false;
                    direita = false;
                    cima = true;
                    esquerda= false;
                    MudaCima(i,j);
                }

                if(baixo && tetris[i][j] == '\\'){
                    cima = false;
                    direita = true;
                    esquerda = false;
                    baixo = false;
                    MudaDireita(i,j);
                }

                if(baixo && tetris[i][j] == '/'){
                    cima = false;
                    direita = false;
                    esquerda = true;
                    baixo = false;
                    MudaEsquerda(i,j);
                }

                if(esquerda && tetris[i][j] == '/'){
                cima = true;
                direita = false;
                esquerda = false;
                baixo = false;
                MudaCima(i,j);
                }

                if(esquerda && tetris[i][j] == '\\'){
                cima = false;
                direita = false;
                esquerda = false;
                baixo = true;
                MudaBaixo(i,j);
                }

                if(cima && tetris[i][j] == '/'){
                    cima = false;
                    direita = true;
                    esquerda = false;
                    baixo = false;
                    MudaDireita(i,j);
                }

                if(cima && tetris[i][j] == '\\'){
                    cima = false;
                    direita = false;
                    esquerda = true;
                    baixo = false;
                    MudaEsquerda(i, j);
                }
            }
        }

        public void MudaBaixo(int linha, int coluna){
            linha++;
        }
        public void MudaCima(int linha, int coluna){
            linha--;
        }
        public void MudaEsquerda(int linha, int coluna){
            coluna--;
        }
        public void MudaDireita(int linha, int coluna){
            coluna++;
        }
    }
