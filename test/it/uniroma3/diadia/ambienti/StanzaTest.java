package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	@Test
	void testImpostaStanzaAdiacenteStanzaNull() {
		Stanza A = new Stanza("A");
		A.impostaStanzaAdiacente("nord", null);
		assertNull(A.getStanzaAdiacente("nord"), "La stanza NULL non funziona");
	}

	@Test
	void testImpostaStanzaAdiacenteDirezioneSbagliata() {
		Stanza A = new Stanza("A");
		A.impostaStanzaAdiacente("nord", null);
		assertNull(A.getStanzaAdiacente("sud"), "Usare la direzione sbagliata non funziona");
	}
	
	@Test 
	void testImpostaStanzaAdiacenteTroppeDirezioni() {
		Stanza A = new Stanza("A");
		A.impostaStanzaAdiacente("nord",null);
		A.impostaStanzaAdiacente("est", null);
		A.impostaStanzaAdiacente("sud", null);
		A.impostaStanzaAdiacente("ovest",null);
		A.impostaStanzaAdiacente("sinistra", null);
		assertNull(A.getStanzaAdiacente("sinistra"),"Si possono impostare più di 4 stanze adiacenti");
	}

	@Test
	void testAddAttrezzoNull() {
		Stanza A = new Stanza("A");
		assertTrue(A.addAttrezzo(null), "Aggiungere un attrezzo null non funziona");
	}

	@Test
	void testAddAttrezzoPieno() {
		Stanza A = new Stanza("A");
		Attrezzo atr = new Attrezzo("Federica", 10);
		for (int i = 0; i < 10; i++) {
			A.addAttrezzo(atr);
		}
		Attrezzo Federica = new Attrezzo("Federica", 2);
		assertFalse(A.addAttrezzo(Federica), "Aggiungere un attrezzo sopra il limite lo aggiunge per davvero");

	}

	@Test
	void testAddAttrezzoTrovato() {
		Stanza A = new Stanza("A");
		Attrezzo atr = new Attrezzo("Atr", 2);
		assertTrue(A.addAttrezzo(atr));
	}

	@Test
	void testHasAttrezzoTrovato() {
		Stanza A = new Stanza("A");
		Attrezzo atr = new Attrezzo("Federica", 10);
		A.addAttrezzo(atr);
		assertTrue(A.hasAttrezzo("Federica"));
	}
}