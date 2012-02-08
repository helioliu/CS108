package expressions;
import java.util.*;

import model.RGBColor;

public class Parctan extends ParenExp{
	
	public Parctan(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toArctangent = results.get(0);
		
		return new RGBColor(arctangent(toArctangent.getRed()),
				arctangent(toArctangent.getGreen()),
				arctangent(toArctangent.getBlue()));

	}
	
	private double arctangent(double c){
		c = (c*180)/Math.PI;
		return Math.atan(c);
	}

	
	public static class Factory extends PExpParamFactories.Factory1P
    {

        protected String commandName() {
            return "atan";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Parctan(subExpressions);
        }
        
    }

}
