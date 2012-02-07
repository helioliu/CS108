package expressions;
import java.util.*;

import model.RGBColor;

public class Pceiling extends ParenExp{
	
	public Pceiling(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toCeil = results.get(0);
		
		return new RGBColor(ceil(toCeil.getRed()),
				ceil(toCeil.getGreen()),
				ceil(toCeil.getBlue()));

	}
	
	private double ceil(double c){
		return Math.ceil(c);
	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "ceil";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pceiling(subExpressions);
        }
        
    }

}
