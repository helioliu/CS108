package expressions;
import java.util.*;

import model.RGBColor;

public class Psine extends ParenExp{
	
	public Psine(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toSin = results.get(0);
		
		return new RGBColor(sine(toSin.getRed()),
				sine(toSin.getGreen()),
				sine(toSin.getBlue()));

	}
	
	private double sine(double c){
		c = (c*180)/Math.PI;
		return Math.sin(c);
	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "sin";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Psine(subExpressions);
        }
        
    }

}
