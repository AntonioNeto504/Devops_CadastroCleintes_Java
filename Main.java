import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        exibirTelaBoasVindas();
        exibirMenu();
    }

    private static void exibirTelaBoasVindas() {
        System.out.println("Bem-vindo à Sala de DevOps!");
    }

    private static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n---------------- Menu ----------------");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Visualizar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarCliente(scanner);
                    break;
                case 2:
                    visualizarClientes();
                    break;
                case 3:
                    atualizarCliente(scanner);
                    break;
                case 4:
                    excluirCliente(scanner);
                    break;
                case 5:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.println("\n--- Adicionar Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void visualizarClientes() {
        System.out.println("\n--- Clientes ---");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void atualizarCliente(Scanner scanner) {
        System.out.println("\n--- Atualizar Cliente ---");
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes para atualizar.");
            return;
        }

        System.out.println("Selecione o cliente a ser atualizado:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (indice < 1 || indice > clientes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Cliente cliente = clientes.get(indice - 1);
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo email: ");
        String novoEmail = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String novoTelefone = scanner.nextLine();

        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);
        cliente.setTelefone(novoTelefone);
        System.out.println("Cliente atualizado com sucesso!");
    }

    private static void excluirCliente(Scanner scanner) {
        System.out.println("\n--- Excluir Cliente ---");
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes para excluir.");
            return;
        }

        System.out.println("Selecione o cliente a ser excluído:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (indice < 1 || indice > clientes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        clientes.remove(indice - 1);
        System.out.println("Cliente removido com sucesso!");
    }

    private static void sair() {
        System.out.println("Saindo...");
    }
}


