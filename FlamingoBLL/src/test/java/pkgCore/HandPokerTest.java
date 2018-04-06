package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {
	@Test
	public void RoyalFlushTest1() {
		System.out.println("Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(true,hp.isRoyalFlush());
		assertEquals(eHandStrength.RoyalFlush, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
	}
	
	@Test
	public void StraightFlushTest1() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.NINE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.SPADES, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(true,hp.isStraightFlush());
		HandScorePoker HSP = hp.getHSP();
		assertEquals(eHandStrength.StraightFlush, HSP.geteHandStrength());
		assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
	}
	
	@Test
	public void StraightFlushTest2() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(true,hp.isStraightFlush());
		HandScorePoker HSP = hp.getHSP();
		assertEquals(eHandStrength.StraightFlush, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
	}
	
	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isFourOfAKind());
		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.THREE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(true,hp.isFourOfAKind());
		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.TWO, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
	}
	
	@Test
	public void FourOfAKindTest3() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(true,hp.isFourOfAKind());
		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.THREE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.HEARTS, HSP.getKickers().get(0).geteSuit());
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(true,hp.isFullHouse());
		HandScorePoker HSP = hp.getHSP();
		assertEquals(eHandStrength.FullHouse, HSP.geteHandStrength());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(0,HSP.getKickers().size());
	}
	
	@Test
	public void FlushTest1() {
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.SPADES, eRank.NINE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(true,hp.isFlush());
		assertEquals(eHandStrength.Flush, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
	}
	
	@Test
	public void StraightTest1() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isStraight());
		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.SEVEN, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());

	}
	
	@Test
	public void StraightTest2() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isStraight());
		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());

	}
	
	@Test
	public void StraightTest3() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isStraight());
		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());

	}
	
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three Of A Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isThreeOfAKind());
		assertEquals(eHandStrength.ThreeOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(2,HSP.getKickers().size());
		assertEquals(eRank.ACE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		assertEquals(eRank.KING, HSP.getKickers().get(1).geteRank());
		assertEquals(eSuit.SPADES, HSP.getKickers().get(1).geteSuit());
	}
	
	@Test
	public void ThreeOfAKindTest2() {
		System.out.println("Three Of A Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isThreeOfAKind());
		assertEquals(eHandStrength.ThreeOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(2,HSP.getKickers().size());
		assertEquals(eRank.ACE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		assertEquals(eRank.KING, HSP.getKickers().get(1).geteRank());
		assertEquals(eSuit.HEARTS, HSP.getKickers().get(1).geteSuit());
	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isTwoPair());
		assertEquals(eHandStrength.TwoPair, HSP.geteHandStrength());
		assertEquals(eRank.KING, HSP.getHiCard().geteRank());
		assertEquals(1,HSP.getKickers().size());
		assertEquals(eRank.ACE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
	}
	
	@Test
	public void TwoPairTest2() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isTwoPair());
		assertEquals(eHandStrength.TwoPair, HSP.geteHandStrength());
		assertEquals(eRank.KING, HSP.getHiCard().geteRank());
		assertEquals(1,HSP.getKickers().size());
		assertEquals(eRank.ACE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
	}
	
	@Test
	public void PairTest1() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isPair());
		assertEquals(eHandStrength.Pair, HSP.geteHandStrength());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(3,HSP.getKickers().size());
		assertEquals(eRank.ACE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());
		assertEquals(eRank.TEN, HSP.getKickers().get(1).geteRank());
		assertEquals(eSuit.DIAMONDS, HSP.getKickers().get(1).geteSuit());
		assertEquals(eRank.FOUR, HSP.getKickers().get(2).geteRank());
		assertEquals(eSuit.HEARTS, HSP.getKickers().get(2).geteSuit());
	}
	@Test
	public void HighCardTest1() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(true,hp.isHighCard());
		assertEquals(eHandStrength.HighCard, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		

	}
}
