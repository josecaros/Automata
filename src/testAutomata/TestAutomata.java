package testAutomata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import automata.*;

class TestAutomata {
	private static TestAutomata test;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Antes de todas");
		test = new TestAutomata();
	}

	@Before
	public static void before() {
		System.out.println("Antes de cada una");

	}
	
	@Test
	public void regularString() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		assertTrue(automata1.evaluarEntrada("aaab"));
		assertTrue(automata1.evaluarEntrada("ab"));
	}
	
	@Test
	public void failString() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		assertFalse(automata1.evaluarEntrada("aaaab"));
	}
	
	@Test
	public void invalidString() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		try {
			automata1.evaluarEntrada("a1adbc");
			fail("Se esperaba una exepcion");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void voidString() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		assertFalse(automata1.evaluarEntrada(""));
	}
	
	@Test
	public void noAlfabetString() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		try {
			automata1.evaluarEntrada("ccgnj");
			fail("Se esperaba una exepcion");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void noString() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		try {
			automata1.evaluarEntrada("134");
			fail("Se esperaba una exepcion");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void onlyCharacterA() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		assertFalse(automata1.evaluarEntrada("aaaaaaaaa"));
	}
	
	@Test
	public void onlyCharacterB() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		assertFalse(automata1.evaluarEntrada("bbbbbb"));
	}
	
	@Test
	public void onlyCharacter() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		assertFalse(automata1.evaluarEntrada("a"));
		assertFalse(automata1.evaluarEntrada("b"));
	}
	
	@Test
	public void invalidChar() {
		Automata automata1 = new Deterministico();
		char[] alfabeto = { 'a', 'b' };
		Nodo a = new Nodo("q1");
		Nodo b = new Nodo("q2");
		Nodo c = new Nodo("q3");automata1.agregarAlfabeto(alfabeto);
		automata1.agregarEstado(a, false);
		automata1.agregarEstado(b, false);
		automata1.agregarEstado(c, true);

		automata1.agregarTransicion(a, 'a', b);
		automata1.agregarTransicion(b, 'a', a);
		automata1.agregarTransicion(b, 'b', c);
		try {
			automata1.evaluarEntrada("	");
			fail("Se esperaba una exepcion");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
