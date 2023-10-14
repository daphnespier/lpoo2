package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.Autor;
import model.AutorDAO;
import model.Livro;
import model.LivroDAO;
import view.LivroAutorGUI;

public class MainLivroAutor {
    
    private AutorDAO autorDAO;
    private LivroDAO livroDAO;

    public MainLivroAutor() throws Exception{
        autorDAO = new AutorDAO();
        livroDAO = new LivroDAO();
    }

    
    public static void main(String[] args) {
        LivroAutorGUI gui = new LivroAutorGUI();
        gui.show();
    } 
    
    public void incluirAutor() throws Exception{
        System.out.print("Digite o nome do autor:");
        Scanner sc = new Scanner(System.in,"ISO-8859-1");
        String nome = sc.nextLine();
        Autor autor = new Autor(nome);
        autorDAO.inserirAutor(autor);
    }

    public void incluirLivro() {
        System.out.print("Digite o título do livro:");
        Scanner sc = new Scanner(System.in,"ISO-8859-1");
        String titulo = sc.nextLine();
        int numAutores=1;
        List<Autor> listaAutores = new ArrayList();
        int idAutor=0;
        do{
            try{
                Scanner sc2 = new Scanner(System.in,"ISO-8859-1");
                System.out.print("ID Autor "+numAutores+":");
                idAutor = sc2.nextInt();
                if(idAutor==-1)
                    break;
                Autor autor = autorDAO.consultarAutor(idAutor);
                if(autor != null){
                    listaAutores.add(autor);
                    numAutores++;
                }else{
                    System.out.println("Autor não existe!");
                }
            }
            catch(Exception ex){
                System.out.println("ID autor não é inteiro ou inválido!");
            }
        }while(true);


        Livro livro = new Livro(titulo,listaAutores);
        livroDAO.inserirLivro(livro);
    }

    public void listarAutores() throws Exception{
        List<Autor> listaAutores = autorDAO.listarAutores();
        Collections.sort(listaAutores, new Comparator<Autor>() {
           @Override
           public int compare(Autor arg0, Autor arg1) {
               String nomeAutor1 = arg0.getNome();
               String nomeAutor2 = arg1.getNome();
               int retorno = nomeAutor1.compareToIgnoreCase(nomeAutor2);
               return retorno;
               /*int idAutor1 = arg0.getId();
               int idAutor2 = arg1.getId();
               if(idAutor1 > idAutor2)
                   return 1;
               else if(idAutor1 == idAutor2)
                   return 0;
               else
                   return -1;*/
             }
        });
        System.out.println("ID\tNOME");
        for(Autor autor:listaAutores){
            System.out.println(autor.getId()+" \t"+autor.getNome());
        }
    }

    public void listarLivroComAutores() throws Exception{
        List<Livro> listaLivros = livroDAO.listarLivroComAutores();
        Collections.sort(listaLivros, new Comparator<Livro>() {
           public int compare(Livro arg0, Livro arg1) {
               String titulo = arg0.getTitulo();
               int i = titulo.compareToIgnoreCase(arg1.getTitulo());
               return i;
             }
        });
        System.out.println("ID\tTitulo do Livro\tAutores");
        for(Livro livro:listaLivros){
            System.out.print(livro.getId()+"\t"+livro.getTitulo()+"\t");
            for(Autor autor:livro.getAutores()){
                System.out.print(autor.getNome()+";");
            }
            System.out.print("\n");
        }

    }
}
