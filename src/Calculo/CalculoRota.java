package Calculo;

public class CalculoRota {
    char[][] tetris;
    int i, j = 0;

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

    public void LeituraMatriz(){

        boolean esquerda = false;
        boolean cima = false;
        boolean baixo = false;
        boolean direita = true;

        for(i = coordenada(); tetris[i][j]=='#'; i++){
            for(j = 0; tetris[i][j]=='#'; j++){

               if(baixo){MudaBaixo(i, j);}
               if(cima){MudaCima(i, j);}
               if(esquerda){MudaEsquerda(i, j);}
               if(direita){MudaDireita(i, j);}

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

                    MudaBaixo(i,j);}
                if(direita && tetris[i][j] == '/'){
                    cima = true;
                    direita=esquerda=baixo = false;
                }
            }
        }
    }

    public void MudaBaixo(int linha, int coluna){
        linha++;
    }
    public void MudaCima(int linha, int coluna){
        linha--;
    }public void MudaEsquerda(int linha, int coluna){
        coluna--;
    }public void MudaDireita(int linha, int coluna){
        coluna++;
    }
}
