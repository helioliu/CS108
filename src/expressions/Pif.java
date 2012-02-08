package expressions;

import java.util.*;

import model.RGBColor;

public class Pif extends ParenExp {

	public Pif(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		boolean condition = getCondition(results.get(0));
		
		if(condition)
			return results.get(1);
		else
			return results.get(2);
	}
	
	private boolean getCondition(RGBColor color){
		double value = (color.getRed() + color.getGreen() + color.getBlue())/3.0;
		return value>0;
	}

	public static class Factory extends PExpParamFactories.Factory3P {

		protected String commandName() {
			return "if";
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new Pif(subExpressions);
		}

	}

}
