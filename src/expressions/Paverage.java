package expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Paverage extends ParenExp {

	public Paverage(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor total = new RGBColor(0);
		for(RGBColor c:results)
			total = ColorCombinations.add(total, c);
		
		total = ColorCombinations.divide(total, new RGBColor(results.size()));
		
		return total;
	}

	public static class Factory extends PExpParamFactories.FactoryInfP {

		protected String commandName() {
			return "average";
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new Paverage(subExpressions);
		}

	}

}
