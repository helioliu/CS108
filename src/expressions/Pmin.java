package expressions;

import java.util.*;

import model.RGBColor;

/**
 * I used RGBColor.toGreyScale() to determine the values
 * but I don't know if that's correct
 *
 */

public class Pmin extends ParenExp {

	public Pmin(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor min = results.get(0);
		for(RGBColor c:results){
			if(c.getBlue() < min.getBlue())
				min = c;
		}
		
		return min;
	}

	public static class Factory extends PExpParamFactories.FactoryInfP {

		protected String commandName() {
			return "min";
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new Pmin(subExpressions);
		}

	}

}
