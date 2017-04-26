import java.util.*;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;  

public class Mudar {
    
    public Path path;
    
    public Mudar() {
        path = Paths.get("").toAbsolutePath();
    }
    
    public void setPath(Path p) {
        this.path = p;
    }
    
    public Path getPath() {
        return path;
    }
    
    
    public void mudar(String ...strings) {   
        List<Path> p = null;
        if (strings[1].equalsIgnoreCase("..")) {
               setPath(getPath().getParent());
               System.out.println(getPath());           
        } else {
            
            if (Files.isDirectory(getPath().resolve(strings[1]))) {
                setPath(getPath().resolve(strings[1]));
                System.out.println(getPath());  
            } else {
                System.out.println(strings[1] + " Não foi encontrado ou não é um diretorio.");
            }
        }
    }
    
}
