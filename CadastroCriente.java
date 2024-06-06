package br.unip.cadastrocriente;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CadastroCriente {

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        
         while (true) {
            String menu = "Menu:\n"
                        + "1. Excluir Cadastro\n"
                        + "2. Alterar Cadastro\n"
                        + "3. Localizar Cadastro\n"
                        + "4. Sair\n"
                        + "Escolha uma opção:";
            
            String opcaoStr = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE);
            if (opcaoStr == null) {
                break;  // Se o usuário cancelar, sair do loop
            }

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                continue;
            }

            if (opcao == 4) {
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;
            }

            String codigoStr = JOptionPane.showInputDialog(null, "Informe o código do cliente:",
                    "Código do Cliente", JOptionPane.QUESTION_MESSAGE);
            
            if (codigoStr == null) {
                continue;  // Se o usuário cancelar, voltar ao menu
            }

            int codigo;
            try {
                codigo = Integer.parseInt(codigoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código inválido. Tente novamente.");
                continue;
            }

            Cliente cliente = localizarClientePorCodigo(codigo);

            switch (opcao) {
                case 1:
                    excluirCadastro(cliente);
                    break;
                case 2:
                    alterarCadastro(cliente);
                    break;
                case 3:
                    localizarCadastro(cliente);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private static void excluirCadastro(Cliente cliente) {
        if (cliente != null) {
            clientes.remove(cliente);
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso.\nDados do cliente excluído: " + cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Não há cliente cadastrado com o código informado.");
        }
    }

    private static void alterarCadastro(Cliente cliente) {
        if (cliente != null) {
            cliente.nome = JOptionPane.showInputDialog(null, "Digite o novo nome:",
             "Alterar Nome", JOptionPane.QUESTION_MESSAGE);
            
            cliente.dataNascimento = JOptionPane.showInputDialog(null, "Digite a nova data de nascimento:",
             "Alterar Data de Nascimento", JOptionPane.QUESTION_MESSAGE);
            
            cliente.telefone = JOptionPane.showInputDialog(null, "Digite o novo telefone:",
             "Alterar Telefone", JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Não há cliente cadastrado com o código informado.");
        }
    }

    private static void localizarCadastro(Cliente cliente) {
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Dados do cliente localizado: " + cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Não há cliente cadastrado com o código informado.");
        }
    }

    private static Cliente localizarClientePorCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.codigo == codigo) {
                return cliente;
            }
        }
        return null;
    }
}
        

    


