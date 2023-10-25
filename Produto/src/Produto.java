import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco;
    }

    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Deletar Produto");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Limpa o buffer
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    Produto novoProduto = new Produto(id, nome, preco);
                    listaProdutos.add(novoProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("\nLista de Produtos:");
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto);
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do produto que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();

                    for (Produto produto : listaProdutos) {
                        if (produto.getId() == idAtualizar) {
                            System.out.print("Novo Nome: ");
                            scanner.nextLine();  // Limpa o buffer
                            String novoNome = scanner.nextLine();
                            System.out.print("Novo Preço: ");
                            double novoPreco = scanner.nextDouble();

                            produto.nome = novoNome;
                            produto.preco = novoPreco;
                            System.out.println("Produto atualizado com sucesso!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do produto que deseja deletar: ");
                    int idDeletar = scanner.nextInt();

                    for (Produto produto : listaProdutos) {
                        if (produto.getId() == idDeletar) {
                            listaProdutos.remove(produto);
                            System.out.println("Produto deletado com sucesso!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
