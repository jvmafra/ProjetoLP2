package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Opiniao;
import classes.QuartoExecutivoTriplo;

public class OpiniaoTest {
	private Opiniao op1;
	private Opiniao op2;

	@Before
	public void setUp() throws Exception {
		op1 = new Opiniao("Muito bom e muito confortável. Atendeu às expectativas", 9);
	}
	
	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Muito bom e muito confortável. Atendeu às expectativas", op1.getComentario());
		Assert.assertTrue(op1.getNota() == 9);
	}
	
	@Test
	public void testaExcessoes() {
		try {
			op2 = new Opiniao(null, 10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Comentario nulo");
		}
		try {
			op2 = new Opiniao("Confortavel, atende bem aos clientes, possui otimas instalacoes, mas a alimentacao deixou um pouco a desejar, principalmente duramente o cafe", 8);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Comentario longo demais");
		}
		try {
			op2 = new Opiniao("Comentario", -1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Nota invalida");
		}
		try {
			op2 = new Opiniao("Comentario", 11);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Nota invalida");
		}

	}
	
	@Test
	public void testaToString() {
		Assert.assertEquals("Muito bom e muito confortável. Atendeu às expectativas"
				+ "\n21/1/2015 às 17:39" + "\nNota: 9", op1.toString());
		
		// Deve-se colocar a hora atual dos testes
	}
	
	@Test
	public void testaEquals() throws Exception {
		op2 = new Opiniao("Comentario", 9);
		Assert.assertFalse(op1.equals(op2));
		
		op2 = new Opiniao("Muito bom e muito confortável. Atendeu às expectativas", 9);
		Assert.assertTrue(op1.equals(op2));

		op2 = new Opiniao("Muito bom e muito confortável. Atendeu às expectativas", 8);
		Assert.assertFalse(op1.equals(op2));
	}
	
}
