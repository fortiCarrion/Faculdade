package comp2028;

import java.util.Scanner;

import br.unifil.comp2028.dao.TesteDAO;
import br.unifil.comp2028.model.Teste;

public class Nova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertValue();
	}
	
	public static void insertValue(){
		System.out.println("id, name");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		String name = sc.next();
		
		Teste teste = new Teste();
		
		teste.setId(id);
		teste.setName(name);
		
		TesteDAO dao = new TesteDAO();
		
		dao.inserir(teste);
		
	}

	public static void selectAll(){
		for(Teste t : new TesteDAO().testes()){
			System.out.println(t.getName());
		}
	}
	
}
