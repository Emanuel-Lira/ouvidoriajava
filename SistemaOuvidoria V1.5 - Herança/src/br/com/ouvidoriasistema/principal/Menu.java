package br.com.ouvidoriasistema.principal;

import javax.swing.JOptionPane;

import br.com.ouvidoriasistema.entidades.Gerenciamento;

public class Menu {
	
	public static void main(String[] args) {
		

		Gerenciamento gerenciamento = new Gerenciamento();
		int opcao = 0;

		do {

			try {
				

				int opcaoSelect = Integer.parseInt(JOptionPane.showInputDialog(null,
						"SEJA BEM VINDO, ABRA SUA RECLAMAÇÃO, ELOGIO OU SUGESTÃO.\n\n" 
								+ "1-Listar manifestações.\n"
								+ "2-Listar manifestações por tipo(reclamação, elogio ou sugestão).\n"
								+ "3-Criar um nova manifestação.\n" 
								+ "4-Exibir quantidade de manifestações.\n"
								+ "5-Exibir manifestações por código.\n" 
								+ "6-Excluir manifestação por código.\n"
								+ "7-Sair do sistema.", "SISTEMA DE OUVIDORIA", JOptionPane.INFORMATION_MESSAGE));
				opcao = opcaoSelect;

				if (opcao == 1) {

					// ListagemDasManifestações
					gerenciamento.listarManifestacao();

				} else if (opcao == 2) {

					// ListagemDeManifestaçõesPorTipo
					gerenciamento.listarManifestacoesPorTipo();

				} else if (opcao == 3) {

					// CriarUmaNovaManifestação
					gerenciamento.criarManifestacao();

				} else if (opcao == 4) {

					// ExibirQuantidadeDeManifestações
					gerenciamento.exibirQuantidadeDeManifestações();

				} else if (opcao == 5) {

					// PesquisarUmaManifestaçãoPorCódigo
					gerenciamento.pesquisarManifestacaoPorCodigo();

				} else if (opcao == 6) {

					// ExcluirUmaManifestaçãoPeloCódigo
					gerenciamento.excluirManifestacaoPorCodigo();

				} else if (opcao != 7) {

					JOptionPane.showMessageDialog(null, "Opção inválida! tente novamente.", "Mensagem interna",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.", "Mensagem interna",
						JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Mensagem interna",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (opcao != 7);

	}

}
