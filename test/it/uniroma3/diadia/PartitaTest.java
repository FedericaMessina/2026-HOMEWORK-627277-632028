package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	private Partita partitaSenzaCfu;
	private Partita partitaNonVincente;
	private Partita partitaVincente;

	@BeforeEach
	public void setUp() {
		this.partitaSenzaCfu = new Partita();
		this.partitaSenzaCfu.getGiocatore().setCfu(0);
		this.partitaVincente = new Partita();
		this.partitaVincente.setStanzaCorrente(this.partitaVincente.getStanzaCorrente().getStanzaAdiacente("nord"));
		this.partitaNonVincente = new Partita();
		this.partitaNonVincente.setStanzaCorrente(this.partitaNonVincente.getStanzaCorrente().getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testIsFinitaSenzaCfu(){
		assertTrue(partitaSenzaCfu.isFinita());
	}
	@Test
	public void testIsFinitaVincente(){
		assertTrue(partitaVincente.isFinita());
	}
	@Test
	public void testIsFinitaNonVincente() {
		assertFalse(partitaNonVincente.isFinita());
	}
	
	

}
