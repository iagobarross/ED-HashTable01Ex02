package view;
import controller.predioCont;
import model.Morador;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {
	public static void main(String [] args) {
		predioCont pCont = new predioCont();
		int opc = 0;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu Prédio\n1- Adicionar Morador\n2- Buscar Morador\n3- Deletar Morador\n4- Listar Morador(es) do Andar\n9- Finalizar"));
			switch(opc) {
			case 1:
				Morador morador = new Morador();
				String nome = JOptionPane.showInputDialog("Digite o nome do morador:");
				morador.setNome(nome);
				
				int numeroAp = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do apartamento: "));
				morador.setNumAp(numeroAp);
				
				String modelo = JOptionPane.showInputDialog("Digite o modelo do carro:");
				morador.setModeloCarro(modelo);
				
				String cor = JOptionPane.showInputDialog("Digite a cor do carro:");
				morador.setCorCarro(cor);
				
				String placa = JOptionPane.showInputDialog("Digite a placa do carro:");
				morador.setPlacaCarro(placa);
				
				pCont.addMorador(morador);
				break;
				
			case 2:
				Morador moradorBusca = new Morador();
				moradorBusca.setNumAp(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do apartamento para busca:")));
				
				try {
					moradorBusca = pCont.findMorador(moradorBusca);
					System.out.println(moradorBusca.toString());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 3:
				Morador moradorDeleta = new Morador();
				moradorDeleta.setNumAp(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do apartamento para remoção:")));
				
				try {
					pCont.removeMorador(moradorDeleta);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 4:
				int andar = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar para listagem de 1 a 10:"));
				try {
					pCont.listAndar(andar - 1);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 9:
				System.out.println("Finalizando...");
				System.exit(0);
				
				default:
					System.out.println("Opcão Invalida");
			}
		}
		
		
	}
}
