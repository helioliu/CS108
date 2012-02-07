package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pnegate extends ParenExp{
	
	public Pnegate(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		return ColorCombinations.negate(results.get(0));

	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "neg";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pnegate(subExpressions);
        }
        
    }
	
	public static class Factory2 extends Pnegate.Factory
    {

        protected String commandName() {
            return "!";
        }

    }

}
