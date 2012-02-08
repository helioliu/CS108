package expressions;

import java.util.*;
import java.util.regex.*;

import model.*;
import expressions.Expression;

public abstract class ParenExp extends Expression{
	protected List<Expression> mySubexpressions;
	
	public ParenExp(List<Expression> subexpressions){
		mySubexpressions = subexpressions;
	}
	
	protected List<RGBColor> evaluateSubs(double xval, double yval, double tval, List<Vmapping> vars){
		List<RGBColor> result = new ArrayList<RGBColor>(mySubexpressions.size());
        for(Expression e : mySubexpressions) {
            result.add(e.evaluate(xval, yval, tval, vars));
        }
        return result;
	}
	
	
	
	public abstract static class Factory extends Expression.Factory
    {
        private static final Pattern EXPRESSION_BEGIN_REGEX =
            Pattern.compile("\\(([!-%|*-z]+)");

        protected String getCommand(Parser parser) {
            Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(parser.stringAtCurrentPosition());
            expMatcher.find(0);
            return expMatcher.group(1);
        }
        
        public boolean isKindOfExpression(Parser parser) {
            if(!regexMatches(EXPRESSION_BEGIN_REGEX, parser))
                return false;
            
            return commandName().contains(getCommand(parser));
            //return getCommand(parser).equals(commandName());
        }

        public Expression parseExpression(Parser parser) {
            if(!isKindOfExpression(parser))
                throw new ParserException("Attempt to parse invalid string as " + commandName() + " paren expression");
            
            int toAdv = getCommand(parser).length();
            parser.advanceCurrentPosition(toAdv+1);
            //parser.advanceCurrentPosition(commandName().length() + 1);

            List<Expression> subexpressions = new ArrayList<Expression>();
            int exprCount = 0;
            while(parser.currentCharacter() != ')' && exprCount < numberOfParameters()){
                subexpressions.add(parser.parseExpression());
                exprCount++;
            }
            
            parser.skipWhiteSpace();
            if (parser.currentCharacter() == ')')
            {
                parser.advanceCurrentPosition(1);
                return constructParenExpression(subexpressions);
            }
            else
            {
                throw new ParserException("Expected close paren, instead found " +
                                          parser.stringAtCurrentPosition());
            }
        }
        
        protected abstract String commandName();
        protected abstract int numberOfParameters();
        protected abstract ParenExp constructParenExpression(List<Expression> subexpressions);
    }

}
