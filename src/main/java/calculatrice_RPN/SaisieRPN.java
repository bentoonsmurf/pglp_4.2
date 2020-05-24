package calculatrice_RPN;

import java.util.EmptyStackException;
import java.util.Scanner;

public class SaisieRPN {
    static Scanner scanner;
	public MoteurRPN moteur;
	double a,b;
	
	
	public SaisieRPN(){
		this.scanner = new Scanner(System.in);
		this.moteur= new MoteurRPN();
		this.a=0;
		this.b=0;
	}
	public void recuperer_donnees() throws ExceptionNombreNonValide{
		String str;		
		System.out.println("Veuillez entrer une valeur et  appuyer sur ENTRER pour  valider ");
		System.out.println("(Entrer 'exit' pour arreter le programme):");
		str=scanner.nextLine();
		
		//tant que l'utilisateur entre un élément différent de "exit"
		while(!str.equals("exit")){	
			
			try{
				if(str.length()==0 )
					throw new StringIndexOutOfBoundsException();
				
				// si la valeur entrée est un double
				if(isDouble(str)){ 
					
					ajouter_operande(Double.parseDouble( str ));
					
				}		
				
				//si la valeur entrée est parmis les 4 opérations acceptées
				else if(str.charAt(0)=='+'||str.charAt(0)=='-'||str.charAt(0)=='*'||str.charAt(0)=='/'){ 								
					
					calcul(str.charAt(0));				
				
					moteur.afficher_Operandes();	
					
				}
				
				// si l'utilisateur entre une valeur non autorisée
				else{ 
					System.out.println(str);
					System.out.println("Caractère non supporté! Veuillez svp entrer un nombre ou un caractère autorisé. \n");
				
				}
				
			}
			catch(StringIndexOutOfBoundsException e){
				System.out.println("Aucune valeur n'est entrée \n");
				
			}
			str=scanner.nextLine();
		}
		System.out.println("Fin du programme ! \n");
	}
	
	
	
	
	
		///////////////////////////////////////////////////////ajouter l'opérande à la pile tout en vérifiant s'il appartient à l'intervale imposé
	
		
	 	public void ajouter_operande(double nombre) throws ExceptionNombreNonValide{

			try {  
				if (nombre< moteur.MIN_VALUE || nombre> moteur.MAX_VALUE) 
					throw new ExceptionNombreNonValide(); 
				else	 
		 	moteur.empiler_chiffre(nombre); // l'ajouter à la pile
				} 
			catch (ExceptionNombreNonValide  e) 
			{  
				
			} 
	 		 
			moteur.afficher_Operandes();
	 	}
	 	
	 	
	 	
	 	
	 	
	 	///////////////////////////////////////////////////////Effectue le calcule en s'assurant que la pile n'est pas vide
	 	
	 	
	 	public void calcul(char c) throws EmptyStackException{
	 		
	 		double result;
	 		
	 		try {
	 			
	 			// modifier la valeur du symbole
	 			moteur.symbole=c; 
	 			
	 			// si la pile contient moins de 2 valeurs
	 			if(moteur.pile.size()<2)
	 				throw new EmptyStackException();
	 			
		         a=moteur.pile.pop();
		         b=moteur.pile.pop();
		         result=moteur.eval(b,a);
		         try {
		        	 
		        	 	//Si le résultat donne INfinity (Division par )
		           		 if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY)
		                     throw new ArithmeticException();
		           		
		           		// effectuer l'opération avec les deux premiers éléments de la pile puis mettre le résultat dans la pile
		           		moteur.pile.push(result); 
				        System.out.println("opération effectuée : "+ c);
		             
				        
		         } catch (ArithmeticException e) {
		        	 
		             System.out.println("Erreur! Une division par 0 a été faite!");
		             
		         }
		          
		      } catch (EmptyStackException e) {
		    	  
		         System.out.println("Vous n'avez pas assez d'opérandes pour effectuer l'opération");
		         
		      }
	 	}
	 	
	 	
	 	
	 	
	 	/////////////////////////////////////////////vérifie si un nombre est un double ou pas//////////////////////////
	    public boolean isDouble( String str ){
	    	
	        try{
	        	
	            Double.parseDouble( str );
	            
	            return true;
	            
	        }
	        catch( Exception e ){
	        	
	            return false;
	        }
	    }

}
