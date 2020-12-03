import java.util.*;

import factory.ClienteFactory;
import iterator.*;
import modelo.*;

public class Principal {
    public static void main(String[] args) {
        LinkedList<Cliente> listaUsuarios = new LinkedList<>();
        AcervoCollection conteudoAcervo = new AcervoCollectionImpl();
        AcervoTipoEnum acervoTipo = AcervoTipoEnum.TODOS;
        Scanner lendo = new Scanner(System.in);
        int escolhaMenu = 0;

        System.out.println("Bem-vindo!");

        try {
            do {
                System.out.print("\nO que deseja fazer?\nDigite 1 - Adicionar usuários.			Digite 2 - Adicionar filmes/séries.\nDigite 3 - Exibir lista de usuários/catálogo.	Digite 4 - Editar ou Remover usuário ou filme/série.\nDigite 5 - SAIR\n> ");
                escolhaMenu = lendo.nextInt();

                switch (escolhaMenu) {
                    case 1:
                        System.out.print("\nQuantos usuarios? > ");
                        int quantidadeUser = lendo.nextInt();
                        //Adicionar USUÁRIO
                        for (int i = 0; i < quantidadeUser; i++) {
                            System.out.print("Digite o CPF (APENAS OS NÚMEROS): ");
                            int userCPF = lendo.nextInt();

                            System.out.print("Digite o Nome: ");
                            String userNome = lendo.next();

                            System.out.print("Digite o E-mail: ");
                            String userEmail = lendo.next();

                            listaUsuarios.push(ClienteFactory.getCliente(userCPF, userNome, userEmail));
                        }
                        break;
                    case 2:
                        System.out.print("\nQuantos filmes ou séries? > ");
                        int quantidadeAcervo = lendo.nextInt();
                        //Adicionar SÉRIE ou FILME
                        for (int i = 0; i < quantidadeAcervo; i++) {
                            System.out.print("Filme ou série? > ");
                            String qualTipo = lendo.next();

                            System.out.print("Digite o titulo: ");
                            String acervoTitulo = lendo.next();

                            System.out.print("Digite o ano: ");
                            int acervoAno = lendo.nextInt();

                            System.out.print("Digite o gênero: ");
                            String acervoGenero = lendo.next();

                            System.out.print("Digite a nota: ");
                            double acervoNota = lendo.nextDouble();

                            if (qualTipo.equalsIgnoreCase("Filme")) {
                                acervoTipo = AcervoTipoEnum.FILME;
                            } else if (qualTipo.equalsIgnoreCase("Serie") || qualTipo.equalsIgnoreCase("Série")) {
                                acervoTipo = AcervoTipoEnum.SERIE;
                            }
                            conteudoAcervo.adicionarAcervo(new Acervo(acervoTipo, acervoTitulo, acervoAno, acervoGenero, acervoNota));
                        }
                        break;
                    case 3:
                        System.out.print("Digite 1 - Exibir usuários.	Digite 2 - Exibir catálogo. > ");
                        int opcaoExibir = lendo.nextInt();

                        if (opcaoExibir == 1) {
                            //Exibir USUÁRIO
                            System.out.println("-----LISTA DE USUARIO(S)-----");
                            for (Cliente user : listaUsuarios) {
                                System.out.println(user);
                             }           
                        }
                        if (opcaoExibir == 2) {
                            System.out.print("Digite 1 - Exibir todo o catálogo.	Digite 2 - Exibir filmes.\nDigite 3 - Exibir séries. > ");
                            int subOpcao = lendo.nextInt();

                            if (subOpcao == 1) {
                                //Exibir todo o conteúdo.
                                System.out.println("-----LISTA DE FILME(S) E SÉRIE(S)-----");
                                AcervoIterator todoConteudoIterator = conteudoAcervo.iterator(AcervoTipoEnum.TODOS);
                                while (todoConteudoIterator.hasNext()) {
                                    Acervo ac = todoConteudoIterator.next();
                                    System.out.println(ac.toString());
                                }
                            }
                            if (subOpcao == 2) {
                                //Exibir FILME.
                                System.out.println("-----LISTA DE FILME(S)-----");
                                AcervoIterator filmesIterator = conteudoAcervo.iterator(AcervoTipoEnum.FILME);
                                while (filmesIterator.hasNext()) {
                                    Acervo ac = filmesIterator.next();
                                    System.out.println(ac.toString());
                                }
                            }
                            if (subOpcao == 3) {
                                //Exibir SÉRIE.
                                System.out.println("-----LISTA DE SÉRIE(S)-----");
                                AcervoIterator seriesIterator = conteudoAcervo.iterator(AcervoTipoEnum.SERIE);
                                while (seriesIterator.hasNext()) {
                                    Acervo ac = seriesIterator.next();
                                    System.out.println(ac.toString());
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Digite 1 - Remover usuário.	Digite 2 - Remover item do catálogo.\n Digite 3 - Editar usuário.	Digite 4 - Editar item do catálogo.\n> ");
                        int opcaoEditRemove = lendo.nextInt();

                        if (opcaoEditRemove == 1) {
                            //USUARIO
                            System.out.print("Digite a posição do usuário na lista. (De 1 até a posição limite) > ");
                            int posicaoRemover = lendo.nextInt() -1;

                            if (posicaoRemover > listaUsuarios.size() || posicaoRemover < 0) {
                                throw new NoSuchElementException();
                            } else {
                                listaUsuarios.remove(posicaoRemover);
                                System.out.print("Removido com sucesso.");
                            }
                        }
                        if (opcaoEditRemove == 2) {
                            //CATALOGO
                            System.out.print("Digite a posição do item no catálogo. (De 1 até a posição limite) > ");
                            int posicaoRemover = lendo.nextInt() -1;

                            if (posicaoRemover > conteudoAcervo.tamanhoAcervo() || posicaoRemover < 0) {
                                throw new NoSuchElementException();
                            } else {
                                conteudoAcervo.removerAcervo(posicaoRemover);
                                System.out.print("Removido com sucesso.");
                            }           
                        }

                        if (opcaoEditRemove == 3) {
                            //USUARIO
                            System.out.print("Digite a posição do usuário na lista. (De 1 até a posição limite) > ");
                            int posicaoEditar = lendo.nextInt() -1;

                            if (posicaoEditar > listaUsuarios.size() || posicaoEditar < 0) {
                                throw new InputMismatchException();
                            } else {
                                System.out.print("\nDigite o novo CPF: ");
                                int editUserCPF = lendo.nextInt();

                                System.out.print("Digite o novo Nome: ");
                                String editUserNome = lendo.next();

                                System.out.print("Digite o novo E-mail: ");
                                String editUserEmail = lendo.next();
                                System.out.println(" ");

                                listaUsuarios.set(posicaoEditar, ClienteFactory.getCliente(editUserCPF, editUserNome, editUserEmail));
                                System.out.print("Editado com sucesso.");
                            }

                        }

                        if (opcaoEditRemove == 4) {
                            //CATALOGO
                            System.out.print("Digite a posição do item no catálogo. (De 1 até a posição limite) > ");
                            int posicaoEditar = lendo.nextInt() -1;

                            if (posicaoEditar > conteudoAcervo.tamanhoAcervo() || posicaoEditar < 0) {
                                throw new NoSuchElementException();
                            } else {
                                System.out.print("Filme ou série? > ");
                                String qualTipo = lendo.next();

                                System.out.print("Digite o titulo: ");
                                String acervoTitulo = lendo.next();

                                System.out.print("Digite o ano: ");
                                int acervoAno = lendo.nextInt();

                                System.out.print("Digite o gênero: ");
                                String acervoGenero = lendo.next();

                                System.out.print("Digite a nota: ");
                                double acervoNota = lendo.nextDouble();

                                if (qualTipo.equalsIgnoreCase("Filme")) {
                                    acervoTipo = AcervoTipoEnum.FILME;
                                } else if (qualTipo.equalsIgnoreCase("Serie") || qualTipo.equalsIgnoreCase("Série")) {
                                    acervoTipo = AcervoTipoEnum.SERIE;
                                }

                                conteudoAcervo.editarAcervo(posicaoEditar, new Acervo(acervoTipo, acervoTitulo, acervoAno, acervoGenero, acervoNota));;
                                System.out.print("Editado com sucesso.");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("\nFinalizando...");
                        lendo.close();
                        System.exit(0);
                        break;    
                    default:
                        throw new InputMismatchException();
                }
            } while (escolhaMenu >= 0 && escolhaMenu < 5);

        } catch (InputMismatchException e1) {
            System.err.println("\nERRO = Você digitou um valor inválido!");
        } catch (NoSuchElementException e2) {
            System.err.println("\nERRO = Elemento inexistente!");
        } catch (Exception e3) {
            System.err.println("\nOps, ocorreu um erro!");
        } finally {
            lendo.close();
        }
    }
}