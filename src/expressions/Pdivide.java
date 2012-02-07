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

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "div";
        }

        protected int numberOfParameters() {
            return 2;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pdivide(subExpressions);
        }
        
    }
	
	public static class Factory2 extends Pdivide.Factory
    {

        protected String commandName() {
            return "/";
        }
        
    }

}
