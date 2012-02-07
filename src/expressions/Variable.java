package expressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.RGBColor;

public class Variable extends Expression{
	protected String myVariable;
	
	public Variable(String variable){
		myVariable = variable;
	}
	
	public String getName(){
		return myVariable;
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		for(Vmapping v:vars){
			if(v.getName().equals(myVariable)){
				Vmapping layer = vars.remove(0);
				RGBColor result =  v.getExpression().evaluate(xval, yval, tval, vars);
				vars.add(0, layer);
				return result;
			}
		}
		
		if(myVariable.equals("x"))
			return new RGBColor(xval);
		
		if(myVariable.equals("y"))
			return new RGBColor(yval);
		
		if(myVariable.equals("t"))
			return new RGBColor(tval);

		return null;
	}
	
	public static class Factory extends Expression.Factory
    {
		
		protected static final Pattern VARIABLE_REGEX = Pattern.compile("[A-z]+");
		
		public boolean isKindOfExpression(Parser parser) {
			return regexMatches(VARIABLE_REGEX, parser);
		}

        public Expression parseExpression(Parser parser){
        	
        	String input = parser.stringAtCurrentPosition();
			Matcher variableMatcher = VARIABLE_REGEX.matcher(input);
			variableMatcher.find(0);
			String variableMatch = input.substring(variableMatcher.start(),
					variableMatcher.end());
			parser.advanceCurrentPosition(variableMatch.length());
			
	        return new Variable(variableMatch);
        }
        
    }

}
