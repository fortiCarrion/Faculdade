import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.nio.channels.FileChannel;

/**
 * 
 * Autor: Jair Carrion
 */
public class Terminal{
    
    public static void main(String args[]) {
        System.out.println("========================================");
        System.out.println("=========  TERMINAL VERSÃO 0.1 =========");
        System.out.println("========================================");
        Scanner scanner = new Scanner(System.in);
        
        Mudar mudar = new Mudar();
        
        System.out.print("user"+"@"+"computador:"+" $ ");
        String cmd = scanner.nextLine();
        while(!cmd.equals("sair")){
            String aux[] = cmd.split(" ");
            if(aux.length > 1){
               
               switch(aux[0]) {
                   case "listar":                                       
                        if(aux[1].equals("info")){
                            //System.out.format("Listar arquivos e diretórios com as seguintes informações: %n ");   
                            listarTudo(mudar.getPath());
                            
                        }else{                        
                            System.out.println("Comando não encontrado.");
                        }                                      
                        break;                    
                    
                    case "criar":
                        if(aux[1].equals("d")){
                            //System.out.format("Criar arquivos ou diretórios, depende do argumento passado. %n ");   
                            criarDiretorio(aux[2]);
                            System.out.println("Diretório ( "+ aux[2] + " ) criado!");
                        }else if(aux[1].equals("a")) {                        
                            criarArquivo(aux[2],mudar.getPath());
                            System.out.println("Arquivo ( "+ aux[2] + " ) criado!");
                        }
                        break;
                        
                    case "copiar":
                        try {
                            String out = aux[2];
                            int in = out.length();
                            if(out.charAt(in-1) == '/'){
                                copiar(aux[1],aux[2]+aux[1]);
                                System.out.println("Arquivo copiado com sucesso!");
                            }else if(out.charAt(in-1) != '/'){
                                copiar(aux[1],aux[2]+'/'+aux[1]);
                                System.out.println("Arquivo copiado com sucesso!");
                            }else{
                                copiar(aux[1],aux[2]);
                                System.out.println("Arquivo copiado com sucesso!");
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                        break;
                        
                    case "mover":
                         try {
                            String out = aux[2];
                            int in = out.length();
                            if(out.charAt(in-1) == '/'){
                                mover(aux[1],aux[2]+aux[1]);
                                System.out.println("Arquivo movido com sucesso");
                            }else if(out.charAt(in-1) != '/'){
                                mover(aux[1],aux[2]+'/'+aux[1]);
                                System.out.println("Arquivo movido com sucesso");
                            }else{ 
                                mover(aux[1],aux[2]);
                                System.out.println("Arquivo movido com sucesso");
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    
                    case "mudar":
                            mudar.mudar(aux);
                        break;
                        
                    case "remover":
                        remover(aux[1]);
                        break;
                        
                    default:
                        System.out.println("Comando não encontrado...");
                        break;
                    
                }
            
            }else{
               
               switch(cmd) {
                    case "listar": listar(mudar.getPath()); break;
                    case "ls": listar(mudar.getPath()); break;
                    
                    case "onde": onde(mudar.getPath()); break;
                    case "pwd": onde(mudar.getPath()); break;
                    
                    
                    case "ajuda":
                        ajuda();
                        break;
                
                    default:
                        System.out.println("Comando não encontrado...");
                        break;
               }
            }
            
            System.out.print("\n" + "user"+"@"+"computador:"+" $ ");
            cmd = scanner.nextLine();
        }
    }
    
    private static void ajuda(){
        System.out.format("%30s %n %n", "Manual de Ajuda do Terminal");
        System.out.format("COMANDOS %n %n");
        System.out.println("listar: lista todos os arquivos que se encontram no diretório atual.");
        System.out.format("listar info: lista todos os arquivos e diretórios que se encontram no %n"
                        +"              diretório atual bem como algumas informações dos metadados.");
        System.out.format("criar: cria um diretório ou arquivo, depende do argumento passado. %n"
                        + "       criar d nome_diretorio - cria um diretório %n" 
                        + "       criar a nome_arquivo - cria um arquivo %n");
        System.out.format("copiar: comando para copiar um arquivo de um diretório para outro. %n" 
                        + "       Para utilizar, o usuário deve passar como primeiro argumento o %n"
                        + "       arquivo, e como segundo argumento o local que deseja mover.%n");
        System.out.format("mover: comando para mover um arquivo de um diretório para outro. %n" 
                        + "       Para utilizar, o usuário deve passar como primeiro argumento o %n"
                        + "       arquivo, e como segundo argumento o local que deseja mover. %n");
        System.out.format("mudar: comando para mudar de um diretório para outro. %n" 
                        + "       Para utilizar, o usuário deve passar como argumento o %n"
                        + "       o local que deseja se mover. %n");                
        System.out.println("onde: mostra o diretório atual.");
        System.out.println("sair: finaliza o programa.");
    }

    
    private static void onde(Path a){
        System.out.println(a.toString());
        //System.out.println(Paths.get("").toAbsolutePath().toString());
    }
    
    //PARTE DE LISTAGEM DOS ARQUIVOS
    private static void listar(Path a){
        File dir = new File(a.toString());
        if(dir.isDirectory()){
            String[] dirContents = dir.list();
            for(int i =0; i < dirContents.length; i++){
                System.out.println(dirContents[i]);
            }
        }
    }
    private static void listarTudo(Path p){
        String diretorio = p.toString(); //SEMPRE SERA O DIRETORIO ATUAL
        File file = new File(diretorio);
        File afile[] = file.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String user = "(" + "user" + ")";
        char mais_readable,mais_Writable,mais_Executable;
    
        for(int i=0; i < afile.length; i++){
            File arquivos = afile[i];
            Path path = FileSystems.getDefault().getPath(arquivos.toString());
            File dir = new File(arquivos.toString());
        
            boolean is_readable = Files.isReadable(path);
            if(is_readable == true){
                mais_readable = '+';
            }else mais_readable = '-'; 
            boolean is_Writable = Files.isWritable(path);       
            if(is_Writable == true){
                mais_Writable = '+';
            }else mais_Writable = '-';
            boolean is_Executable = Files.isExecutable(path);
            if(is_Executable == true){
                mais_Executable = '+';
            }else mais_Executable = '-';
          
            System.out.printf("%-20s",arquivos.getName().toString());
            System.out.printf("%s",user);
            System.out.printf("%8d%s",dir.length()," Bytes");
            System.out.printf("%9s%s%s","L(",mais_readable,")");
            System.out.printf("%9s%s%s","E(",mais_Writable,")");
            System.out.printf("%9s%s%s","X(",mais_Executable,")");
            System.out.printf("%15S%n",sdf.format(dir.lastModified()));  
        }
    }
    
    // PARTE DE RETORNAR DIRETORIOS
    private static String returnDiretorioPai(Path a){
        return a.getParent().toString();
    }
    private static String returnDiretorio(Path a){
        //return Paths.get("").toAbsolutePath().toString();
        return a.toString();
    }
    
    //CRIAR UM ARQUIVO
    private static void criarArquivo(String nome, Path p){
        boolean bool = false;
        File f = null;
        try {
            f = new File(p + "/" + nome);
            bool = f.createNewFile();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //CRIAR DIRETORIO
    private static void criarDiretorio(String nome){
        File dir = new File(nome);
        dir.mkdir();
    }
    
    //EXCLUIR ARQUIVO OU DIRETORIO
    private static void remover(String st){
        File f = new File(st);
        boolean isDeleted = f.delete();
        if(isDeleted == true) System.out.println(st + "(removido com sucesso)");
    }
    private static void remover2(String st){
        File f = new File(st);
        boolean isDeleted = f.delete();
    }
    
    //COPIAR UM ARQUIVO
     private static void copiar(String in, String out) throws IOException {
         File source = new File(in);
         File destination = new File(out);
         
        if (destination.exists())
            destination.delete();
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
       }
    }
   
    //MOVER
    private static void mover(String in,String out) throws IOException{
       copiar(in,out);
       remover2(in);
    }
}
