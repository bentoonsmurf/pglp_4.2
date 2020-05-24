package calculatrice_RPN;

import java.util.Stack;

public class MoteurRPN extends Operation{
	
	final double MAX_VALUE=Double.MAX_VALUE;
	final double MIN_VALUE=Double.MIN_VALUE;

	
	public Stack<Double> pile;
	

	
	public MoteurRPN() {
		super(' ');
		this.pile = new Stack<Double>();
		
	}// push(E)  pop()   peek() 
	
	public void empiler_chiffre(double c) {
		 
			this.pile.push(c);
		
	}

	
	public double eval (double a1,double a2) {
		
		if (this.symbole==this.PLUS) return a1 + a2;
		if (this.symbole==this.MOINS) return a1 - a2;
		if (this.symbole==this.MULT) return a1 * a2;
		if (this.symbole==this.DIV) return a1 / a2;
		return 0;
	}

	public void afficher_Operandes(){
		System.out.println("Opérandes Stockées: " + this.pile);
		
	}


	
}
