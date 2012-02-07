package model;

import expressions.*;

public class Parser {
	private int myCurrentPosition;
    private String myInput;
    
    public Expression makeExpression (String input)
    {
        myInput = input;
        myCurrentPosition = 0;
        Expression result = parseExpression();
        skipWhiteSpace();
        if (notAtEndOfString())
        {
        	System.out.print("make expression");
            throw new ParserException("Unexpected characters at end of the string: " +
                                      stringAtCurrentPosition(),
                                      ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }
    
    public Expression parseExpression ()
    {
        skipWhiteSpace();
        ExpressionFactory ef = new ExpressionFactory();
        Expression result =  ef.getExpression(this);
        skipWhiteSpace();
        return result;
        
        
    }
    
    public String stringAtCurrentPosition() {
        return myInput.substring(myCurrentPosition);
    }


    public void skipWhiteSpace (){
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter())){
            myCurrentPosition++;
        }
    }

    public char currentCharacter (){
        return myInput.charAt(myCurrentPosition);
    }

    public void advanceCurrentPosition(int chars){
        myCurrentPosition += chars;
    }
    
    private boolean notAtEndOfString (){
        return myCurrentPosition < myInput.length();
    }

}
