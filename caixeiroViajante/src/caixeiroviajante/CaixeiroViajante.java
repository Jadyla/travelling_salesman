package caixeiroviajante;
import java.util.ArrayList;
/**
 *
 * @author jadyl
 */
public class CaixeiroViajante {
    public static void main(String[] args) {
        int qtdeVertices, peso, vertice, qtdeArestas;
        int matrizAdj[][] = null;
        String caminhos;
        
        //*****************LEITURA*********************
        FileManager fileManager = new FileManager();
        ArrayList<String> text = fileManager.stringReader("./Teste.txt");
        //printando texto da entrada
        System.out.println(text);
        
        qtdeVertices = Integer.parseInt(text.get(0));
        //printando quantidade de vertices
        //System.out.println(qtdeVertices);
        matrizAdj = new int[qtdeVertices][qtdeVertices];
        
        ///*****************CRIANDO MATRIZ DE ADJACÊNCIA*********************
        for (int i = 0; i < qtdeVertices; i++) {
            caminhos = text.get(i+1);
            qtdeArestas = (caminhos.split(";")).length;
            String[] semVertice = caminhos.split(" ");
            
            //esse 'for' vai analisar cada aresta a partir no vértice 'i'
            for (int j = 1; j <= qtdeArestas; j++) {
                String[] semHifen = semVertice[j].split("-");
                String[] semPontoEVirgula = semHifen[1].split(";");
                System.out.println(semPontoEVirgula[0]);

                vertice = Integer.parseInt(semHifen[0]);
                peso = Integer.parseInt(semPontoEVirgula[0]);

                matrizAdj[i][vertice] = peso;
            }
            
            matrizAdj[i][i] = -1;
        }
        
        System.out.println("*******");
        for (int i = 0; i < qtdeVertices; i++) {
            for (int j = 0; j < qtdeVertices; j++) {
                System.out.println(matrizAdj[i][j]);
            }
            System.out.println("*******");
        }
        
    }
}