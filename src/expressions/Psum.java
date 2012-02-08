package expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Psum extends ParenExp {

	public Psum(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor total = new RGBColor(0);
		for(RGBColor c:results)
			total = ColorCombinations.add(total, c);
		
		return total;
	}

	public static class Factory extends PExpParamFactories.FactoryInfP {

		protected String commandName() {
			return "sum";
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new Psum(subExpressions);
		}

	}

}
