package de.hska.iwii.i2.gol;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeLogicTest {
    
	private GameOfLifeLogic generationTest = new GameOfLifeLogic();
	
	@Test
	public void testSetStartGeneration() {
		
		
		
		
		
	}

	@Test
	public void testNextGeneration() {
		generationTest.setStartGeneration(Games.BLOCK);
	    generationTest.nextGeneration();
	    
	    
	    
	}

	@Test
	public void testIsCellAlive() {
		 
	    generationTest.setStartGeneration(Games.BLINKER2);  
	    assertTrue(generationTest.isCellAlive(4, 4));
	    assertTrue(generationTest.isCellAlive(4, 3));
	   
	}

	@Test
	public void testCountNeighbours() {
		 generationTest.setStartGeneration(Games.BLINKER2);  
		 assertEquals(2, generationTest.countNeighbours(4, 4));
		
		 
	}

}
