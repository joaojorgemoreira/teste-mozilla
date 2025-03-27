import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Navegador");
            System.out.println("2. Sistema de Senhas");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                Navegador navegador = new Navegador();
                navegador.mostrarEstado();
                
            } else if (opcao == 2) {
                SistemaSenhas sistema = new SistemaSenhas();
                sistema.gerarSenha();
                
            } else {
                System.out.println("Opção inválida.");
            }
        } finally {
            scanner.close(); 
        }
    }
}
