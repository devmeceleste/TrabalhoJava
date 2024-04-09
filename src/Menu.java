

import java.util.Scanner;

public class Menu {
    
    private static void printMenu() {
        System.out.println("1 - Cadastrar Cliente Fisico");
        System.out.println("2 - Cadastrar Cliente Juridico");
        System.out.println("3 - Consultar Cliente");
        System.out.println("4 - Remover Cliente");
        System.out.println("5 - Depositar");
        System.out.println("6 - Sacar");
        System.out.println("7 - Transferir");
        System.out.println("8 - Valor total do banco");
        System.out.println("9 - Consultar todos os clientes");
        System.out.println("");
        System.out.println("0 - Sair");
    }
    
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner entrada = new Scanner(System.in);
        printMenu();
        int opcao = entrada.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1 ->                     {
                        Cliente c = banco.createClienteFisico();
                        banco.addCliente(c);
                    }
                case 2 ->                     {
                        Cliente c = banco.createClienteJuridico();
                        banco.addCliente(c);
                    }
                case 3 ->                     {
                        System.out.println("Digite o identificador: ");
                        int identificador = entrada.nextInt();
                        Cliente c = banco.getCliente(identificador);
                        if (c == null) {
                            System.out.println("Cliente nao encontrado!");
                        }else {
                            System.out.println(c);
                        }                          }
                case 4 ->                     {
                        System.out.println("Digite o identificador: ");
                        int identificador = entrada.nextInt();
                        Cliente c = banco.getCliente(identificador);
                        if (c == null) {
                            System.out.println("Cliente nao encontrado!");
                        }else {
                            banco.removeCliente(c);
                            System.out.println("Cliente removido com sucesso!");
                        }                          }
                case 5 ->                     {
                        System.out.println("Digite o identificador: ");
                        int identificador = entrada.nextInt();
                        System.out.println("Digite o valor do deposito: ");
                        double valor = entrada.nextDouble();
                        Cliente c = banco.getCliente(identificador);
                        if (c == null) {
                            System.out.println("Cliente nao encontrado!");
                        }else {
                            boolean resultado = c.depositar(valor);
                            if (resultado == false) {
                                System.out.println("Valor invalido para deposito!");
                            }else {
                                System.out.println("Deposito realizado com sucesso!");
                                System.out.println("Novo Saldo: " + c.getSaldo());
                            }
                        }                          }
                case 6 ->                     {
                        System.out.println("Digite o identificador: ");
                        int identificador = entrada.nextInt();
                        System.out.println("Digite o valor do saque: ");
                        double valor = entrada.nextDouble();
                        Cliente c = banco.getCliente(identificador);
                        if (c == null) {
                            System.out.println("Cliente nao encontrado!");
                        }else {
                            boolean resultado = c.sacar(valor);
                            if (resultado == false) {
                                System.out.println("Saldo insuficiente ou valor invalido!");
                            }else {
                                System.out.println("Saque realizado com sucesso!");
                                System.out.println("Novo Saldo: " + c.getSaldo());
                            }
                        }                          }
                case 7 ->                     {
                        System.out.println("Digite o id da conta origem: ");
                        int idOrigem = entrada.nextInt();
                        System.out.println("Digite o id da conta destino: ");
                        int idDestino = entrada.nextInt();
                        System.out.println("Digite o valor da transferencia: ");
                        double valor = entrada.nextDouble();
                        Cliente origem = banco.getCliente(idOrigem);
                        Cliente destino = banco.getCliente(idDestino);
                        if (origem == null) {
                            System.out.println("Cliente Origem nao encontrado! Id: " + idOrigem);
                        }else if (destino == null) {
                            System.out.println("Cliente Destino nao encontrado! Id: " + idDestino);
                        }else if (origem.getId() == destino.getId()) {
                            System.out.println("Contas iguais! Impossivel fazer operacao!");
                        }else {
                            boolean resultado = origem.transferir(destino, valor);
                            if (resultado == false) {
                                System.out.println("Saldo insuficiente ou valor invalido!");
                            }else {
                                System.out.println("Transferencia realizada com sucesso!");
                                System.out.println("Saldo Origem.: " + origem.getSaldo());
                                System.out.println("Saldo Destino: " + destino.getSaldo());
                            }
                        }                          }
                case 8 ->          {
                    System.out.println("Valor total do banco: " + banco.getSaldoTotal());
                }
                case 9 ->          {
                    banco.imprimirClientes();
                }
                default -> {
                }
            }
            printMenu();
            opcao = entrada.nextInt();
        }
    }
    
}
