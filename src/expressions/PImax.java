package expressions;

import java.util.*;

import model.RGBColor;

/**
 * I used RGBColor.toGreyScale() to determine the values
 * but I don't know if that's correct
 *
 */

public class PImax extends ParenExpInf {

	public PImax(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor max = results.get(0);
		for(RGBColor c:results){
			if(c.getBlue() > max.getBlue())
				max = c;
		}
		
		return max;
	}

	public static class Factory extends ParenExpInf.Factory {

		protected String commandName() {
			return "max";
		}

		protected int numberOfParameters() {
			return -1;
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new PImax(subExpressions);
		}

	}

}
