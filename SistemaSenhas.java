import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class SistemaSenhas {
    private Queue<Integer> filaPacientes; // Fila de pacientes
    private List<Integer> historicoChamadas; // Histórico de chamadas
    private int contadorSenha; // Contador de senhas
    
    public SistemaSenhas() {
        filaPacientes = new LinkedList<>(); 
        historicoChamadas = new ArrayList<>(); 
        contadorSenha = 1; // A primeira senha começa em 1
    }

    
    public void gerarSenha() {
        filaPacientes.add(contadorSenha); // Adiciona a nova senha na fila
        System.out.println("Senha gerada: " + contadorSenha);
        contadorSenha++; // Incrementa o contador da senha
    }

    // Chama o próximo paciente da fila
    public void chamarProximo() {
        if (!filaPacientes.isEmpty()) {
            int senhaChamado = filaPacientes.poll(); 
            historicoChamadas.add(senhaChamado); 
            System.out.println("Paciente chamado: " + senhaChamado);
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }

    
    public void exibirHistorico() {
        System.out.println("Histórico de chamadas:");
        for (int senha : historicoChamadas) {
            System.out.println("Senha: " + senha);
        }
    }

    
    public void exibirFila() {
        System.out.println("Fila de pacientes:");
        if (filaPacientes.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            for (int senha : filaPacientes) {
                System.out.println("Senha: " + senha);
            }
        }
    }

    public static void main(String[] args) {
        SistemaSenhas sistema = new SistemaSenhas();

        
        sistema.gerarSenha();
        sistema.gerarSenha();
        sistema.gerarSenha();
        
        
        sistema.exibirFila();
        sistema.exibirHistorico();
        
        
        sistema.chamarProximo();
        sistema.chamarProximo();
        
        
        sistema.exibirFila();
        sistema.exibirHistorico();
        
        
        sistema.chamarProximo();
        
        
        sistema.exibirFila();
        sistema.exibirHistorico();
    }
}
