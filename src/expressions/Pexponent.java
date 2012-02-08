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

	
	public static class Factory extends PExpParamFactories.Factory2P
    {

        protected String commandName() {
            return "exp^";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pexponent(subExpressions);
        }
        
    }

}
