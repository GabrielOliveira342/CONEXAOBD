package br.com.aula.conexao;

import java.util.Scanner;

public class InterfaceCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler as entradas do usuario
        int opcao = -1;

        //loop infinito até o usuário decidir sair
        while (true) {//exibe as infroaçoes para o usuario
            System.out.println("Menu:");
            System.out.println("1 - Inserir Aluno");
            System.out.println("2 - Atualizar Aluno");
            System.out.println("3 - Deletar Aluno");
            System.out.println("4 - Ler Registros de Alunos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            String entrada = scanner.nextLine();
            //verifica linha para ler
           
                //usuário pressionar Enter sem digitar nada, evitar erro
                if (entrada.trim().isEmpty()) {
                    System.out.println("Por favor, insira uma opção válida.");
                    continue;
                }

                try {
                    opcao = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    //conversão falhe, mostra mensagem de erro e continua
                    System.out.println("Por favor, insira um número válido.");
                    continue;
                }

                switch (opcao) { //switch para chamar os metodos de cada classe 
                    case 1:
                        InserirDados.main(args);  
                        break;
                    case 2:
                        AtualizarDados.main(args);
                        break;
                    case 3:
                        DeletarDados.main(args);
                        break;
                    case 4:
                        LerDados.main(args);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        scanner.close(); // fecha o scanner quando sair
                        return; // encerra o programa
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
              
            }
        }
    }



