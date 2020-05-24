package calculatrice_RPN_TEST;

import static org.junit.Assert.*;


import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculatrice_RPN.ExceptionNombreNonValide;
import calculatrice_RPN.SaisieRPN;

public class saisie_TEST {







	SaisieRPN test;
	String a;
	String B;
	@Before
	public void setUp() throws Exception {
		test= new SaisieRPN();
		 
		
	}

	@After
	public void tearDown() throws Exception {
	}

	//////////////////////////////////////////Test check si un nombre est un double
	@Test
	public void testRun() {
		a="1";
		B="test";
		System.out.println(test.isDouble(a));
		System.out.println(test.isDouble(B));
	}
	
	/////////////////////////////////////////////Test Exception sur une pile de moins de deux éléments, avant et après traitement dans le code
	/*@Test (expected=EmptyStackException.class)
	public void pile_vide_ex() {
		test.moteur.pile.push((double) 5);
		test.calcul('+'); 
	}*/
	
	@Test 
	public void pile_vide() throws EmptyStackException {
		 
		test.moteur.pile.push((double) 5);
		test.calcul('+'); 
			    
			 
	}
	
/////////////////////////////////////////Test Exception Nombre non compris dans l'intervalle précisé, avant et après traitement dans le code
	
	/*@Test (expected = ExceptionNombreNonValide.class) //classe à créer
	public void testEmpiler_chiffre_Nombre_MINMAX_ex() throws ExceptionNombreNonValide{
		test.ajouter_operande((double)0);
	}*/
	
	
	@Test  //classe à créer
	public void testEmpiler_chiffre_Nombre_MINMAX() throws ExceptionNombreNonValide {
		test.ajouter_operande((double)0);
	}
	
////////////////////////////////////////////////// Test Exception Division par 0, avant et après traitement dans le code
	
	/*@Test (expected = ArithmeticException.class)
	public void testEvalDivise_0_ex()  {
		
		test.moteur.empiler_chiffre(5);
		test.moteur.empiler_chiffre(0);	
		test.moteur.symbole='/';
		test.calcul('/');
		
	}*/
	
	@Test 
	public void testEvalDivise_0() throws ArithmeticException {
		test.moteur.empiler_chiffre(5);
		test.moteur.empiler_chiffre(0);	
		test.moteur.symbole='/';
		test.calcul('/');
		
	}
	

}
