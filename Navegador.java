import java.util.Stack;

public class Navegador {
    private Stack<String> pilhaVoltar; //Pilha para as páginas visitadas (voltar)
    private Stack<String> pilhaAvancar; //Pilha para as páginas avançadas
    private String paginaAtual; //Página atual que está sendo visualizada
    
    public Navegador() {
        pilhaVoltar = new Stack<>(); //Cria a pilha do voltar
        pilhaAvancar = new Stack<>(); //Cria a pilha do avançar
        paginaAtual = "google.com"; //Página inicial
    }
    
    public void acessarPagina(String url) {
        //Quando acessa uma nova página:
        pilhaVoltar.push(paginaAtual); //Adiciona a página atual na pilha do voltar
        paginaAtual = url; //Atualiza a página atual
        pilhaAvancar.clear(); //Limpa a pilha do avançar, porque não é possível avançar após uma nova visita
    }
    
    public void voltar() {
        if (!pilhaVoltar.isEmpty()) {
            pilhaAvancar.push(paginaAtual); //Adiciona a página atual na pilha do avançar
            paginaAtual = pilhaVoltar.pop(); //Retira a página do topo da pilha do voltar e vai para ela
        }
    }
    
    public void avancar() {
        if (!pilhaAvancar.isEmpty()) {
            pilhaVoltar.push(paginaAtual); //Adiciona a página atual na pilha do voltar
            paginaAtual = pilhaAvancar.pop(); //Retira a página do topo da pilha do avançar e vai para ela
        }
    }

    public void mostrarEstado() {
        //Exibe a página atual, pilhas de voltar e avançar
        System.out.println("Página atual: " + paginaAtual);
        System.out.println("Pilha Voltar: " + pilhaVoltar);
        System.out.println("Pilha Avançar: " + pilhaAvancar);
        System.out.println("----------------------------");
    }
    
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        
        //Exemplo de navegação
        navegador.mostrarEstado();
        navegador.acessarPagina("mozilla.org");
        navegador.mostrarEstado();
        navegador.acessarPagina("github.com");
        navegador.mostrarEstado();
        
        navegador.voltar();
        navegador.mostrarEstado();
        navegador.voltar();
        navegador.mostrarEstado();
        
        navegador.avancar();
        navegador.mostrarEstado();
    }
}