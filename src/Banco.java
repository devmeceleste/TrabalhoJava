
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Cliente> clientes;
    
    public Banco() {
        this.clientes = new ArrayList<>();
    }
    
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public void removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }
    
    public Cliente getCliente(int identificador) {
        for (Cliente c : this.clientes) {
            if (c.getId() == identificador) {
                return c;
            }
        }
        return null;
    }
    
    
    public Cliente createClienteFisico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Id: ");
        int id = entrada.nextInt();
        System.out.println("Digite o Nome: ");
        String nome = entrada.next();
        System.out.println("Digite o CPF: ");
        String documento = entrada.next();
        Cliente cliente = new Cliente(id, "Fisico", nome, documento);
        return cliente;
    }
    
    public Cliente createClienteJuridico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Id: ");
        int id = entrada.nextInt();
        System.out.println("Digite o Nome: ");
        String nome = entrada.next();
        System.out.println("Digite o CNPJ: ");
        String documento = entrada.next();
        Cliente cliente = new Cliente(id, "Juridico", nome, documento);
        return cliente;
    }
    
    // saldo total do banco
    public float getSaldoTotal() {
        float saldoTotal = 0;
        for (Cliente c : clientes) {
            saldoTotal += c.getSaldo();
        }
        return saldoTotal;
        
    }
    
    public void imprimirClientes() {
        System.out.println("Clientes:\n");
        for (Cliente c : clientes) { 
            System.out.println("Id cliente: " + c.getId());
            System.out.println("Tipo: " + c.getTipo());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Documento: " + c.getDocumento());
            System.out.println("Saldo: " + c.getSaldo());
            System.out.println();
        }
    
}
}
