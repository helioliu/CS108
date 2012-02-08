package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pdivide extends ParenExp{
	
	public Pdivide(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return ColorCombinations.divide(results.get(0), results.get(1));

	}

	
	public static class Factory extends PExpParamFactories.Factory2P
    {

        protected String commandName() {
            return "div/";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pdivide(subExpressions);
        }
        
    }

}
