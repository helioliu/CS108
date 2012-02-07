package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pplus extends ParenExp{
	
	public Pplus(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return ColorCombinations.add(results.get(0), results.get(1));

	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "plus";
        }

        protected int numberOfParameters() {
            return 2;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pplus(subExpressions);
        }
        
    }
	
	public static class Factory2 extends Pplus.Factory
    {

        protected String commandName() {
            return "+";
        }
        
    }

}
