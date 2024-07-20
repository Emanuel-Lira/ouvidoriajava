package br.com.ouvidoriasistema.entidades;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Gerenciamento {

	ArrayList<Manifestacao> manifestacao = new ArrayList<Manifestacao>();

	// 1)ListagemdasManifestações
	public void listarManifestacao() {

		String tempLista = "";
		for (Manifestacao listaManifestacao : manifestacao) {
			tempLista += listaManifestacao;
		}

		if (tempLista.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não ha manifestações para exibir.");
		} else {
			JOptionPane.showMessageDialog(null, "\n" + tempLista);
		}

	}

	// 2)ListagemdeManifestaçõesporTipo
	public void listarManifestacoesPorTipo() {
		String tempManifestacao = "";

		int opcaoUserTipo = Integer.parseInt(JOptionPane
				.showInputDialog("1 - Elogio\n2 - Reclamacao \n3 - Sugestao \nSelecione o tipo da manifestação."));

		if (opcaoUserTipo >= 1 && opcaoUserTipo <= 3) {
			// Armazenando na variável tipo = Elogio entra no 1. Reclamacao entra no 2 e
			// Sugestacao entra no 3, que não precisa se declarado.
			String tipo = (opcaoUserTipo == 1) ? "Elogio" : (opcaoUserTipo == 2) ? "Reclamacao" : "Sugestao";

			for (Manifestacao item : manifestacao) {
				if (item.getTipo().equals(tipo)) { // verificação entre o tipo e o getTipo()
					tempManifestacao += item + "\n";
				}
			}

			if (tempManifestacao.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há manifestações desse tipo para exibir.");
			} else {
				JOptionPane.showMessageDialog(null, tempManifestacao);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
		}
	}

	// 3-Criar um nova manifestação.
	public void criarManifestacao() {

		Random random = new Random();
		int randomCod = random.nextInt(900) + 100;
		int codigoManifestacao = randomCod;

		Manifestacao manisf = null;
	
		int opcaoUsuarioTipo = Integer.parseInt(JOptionPane
				.showInputDialog("1 - Elogio\n2 - Reclamacao \n3 - Sugestao \nSelecione o tipo da manifestação"));

		if (opcaoUsuarioTipo >= 1 && opcaoUsuarioTipo <= 3) {
			String descricaoTemp = "";

			if (opcaoUsuarioTipo == 1) {
				String descricaoManifestacao = JOptionPane.showInputDialog("Descreva sua manifestação");
				manisf = new Elogio(codigoManifestacao, descricaoManifestacao);
				descricaoTemp = descricaoManifestacao;
				manifestacao.add(manisf);

			} else if (opcaoUsuarioTipo == 2) {
				String descricaoManifestacao = JOptionPane.showInputDialog("Descreva sua manifestação");
				manisf = new Reclamacao(codigoManifestacao, descricaoManifestacao);
				descricaoTemp = descricaoManifestacao;
				manifestacao.add(manisf);

			} else if (opcaoUsuarioTipo == 3) {
				String descricaoManifestacao = JOptionPane.showInputDialog("Descreva sua manifestação");
				manisf = new Sugestao(codigoManifestacao, descricaoManifestacao);
				descricaoTemp = descricaoManifestacao;
				manifestacao.add(manisf);
			}
			if (descricaoTemp.equals("")) {
				JOptionPane.showMessageDialog(null, "É necessário informar uma descrição.");
			} else {

				JOptionPane.showMessageDialog(null,
						"Nova manifestação criada com sucesso!\n" + "Seu número de protocolo é: " + codigoManifestacao);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
		}
	}

	// 4)ExibirQuantidadeDeManifestações
	public void exibirQuantidadeDeManifestações() {
		if (manifestacao.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não existe manifestaões.");

		} else {
			int qtManifestacoes = manifestacao.size();
			JOptionPane.showMessageDialog(null, "Total de manifestações: " + qtManifestacoes);
		}

	}

	// 5)PesquisarUmaManifestaçãoPorCódigo
	public void pesquisarManifestacaoPorCodigo() {

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("código da manifestação:"));
			for (Manifestacao m : manifestacao) {
				if (m.getCodigo() == codigo) {
					JOptionPane.showMessageDialog(null, m);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Manifestação não encontrada.");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "É necessário informar o número de protocolo.");
		}

	}

	// 6)Excluir manifestação por código
	public void excluirManifestacaoPorCodigo() {

		try {

			int codigo = Integer.parseInt(JOptionPane.showInputDialog("código da manifestação:"));

			for (Manifestacao m : manifestacao) {
				if (m.getCodigo() == codigo) {
					manifestacao.remove(m);
					JOptionPane.showMessageDialog(null, "Manifestação excluída com sucesso.");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Manifestação não encontrada.");

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "É necessário informar o número de protocolo que deseja excluir.");
		}

	}
}