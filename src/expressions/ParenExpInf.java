package expressions;

import java.util.*;

import model.Parser;
import model.ParserException;

public abstract class ParenExpInf extends ParenExp {

	public ParenExpInf(List<Expression> subexpressions) {
		super(subexpressions);
	}


	public static abstract class Factory extends ParenExp.Factory {

		public Expression parseExpression(Parser parser) {
            if(!isKindOfExpression(parser))
                throw new ParserException("Attempt to parse invalid string as " + commandName() + " paren expression");
            
            parser.advanceCurrentPosition(commandName().length() + 1);

            List<Expression> subexpressions = new ArrayList<Expression>();
            while(parser.currentCharacter() != ')') {
                subexpressions.add(parser.parseExpression());
            }
            
            parser.advanceCurrentPosition(1);
            return constructParenExpression(subexpressions);

        }

	}

}
