package expressions;
import java.util.*;

import model.RGBColor;

public class Pwrap extends ParenExp{
	
	public Pwrap(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toWrap = results.get(0);
		
		toWrap.wrap();
		
		return toWrap;
	}
	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "wrap";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pwrap(subExpressions);
        }
        
    }

}
