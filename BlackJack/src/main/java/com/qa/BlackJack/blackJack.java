package com.qa.BlackJack;

/**
 * Hello world!
 *
 */
public class blackJack 
{    
    public int blackJack(int a, int b) {
    	int c=0;
    	
    	if (a<22 && b<22) {
    		if ( (21-a) < (21-b) ) { 
    		c=a;
    		}
    		else if ( (21-a) > (21-b) ) { 
    		c=b;
    		}
    	}
    	else if (a>21 && b>21) {  
    	c=0;
    	}
    	else if (a>21) {  
    	c=b;
    	}
    	else if (b>21) {  
    	c=a;
    	}
    	return c;
    }
}