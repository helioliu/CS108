package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pmultiply extends ParenExp{
	
	public Pmultiply(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return ColorCombinations.multiply(results.get(0), results.get(1));

	}

	
	public static class Factory extends PExpParamFactories.Factory2P
    {

        protected String commandName() {
            return "mul*";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pmultiply(subExpressions);
        }
        
    }

}
