package expressions;
import java.util.*;

import model.RGBColor;

public class Pabsolutev extends ParenExp{
	
	public Pabsolutev(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toAbs = results.get(0);
		
		return new RGBColor(getAbs(toAbs.getRed()),
				getAbs(toAbs.getGreen()),
				getAbs(toAbs.getBlue()));

	}
	
	private double getAbs(double c){
		return Math.abs(c);
	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "abs";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pabsolutev(subExpressions);
        }
        
    }

}
