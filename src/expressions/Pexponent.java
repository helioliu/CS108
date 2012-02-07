package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pexponent extends ParenExp{
	
	public Pexponent(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return ColorCombinations.exponentiate(results.get(0), results.get(1));

	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "exp";
        }

        protected int numberOfParameters() {
            return 2;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pexponent(subExpressions);
        }
        
    }
	
	public static class Factory2 extends Pexponent.Factory
    {

        protected String commandName() {
            return "^";
        }
        
    }

}
