package expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class PIsum extends ParenExpInf {

	public PIsum(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor total = new RGBColor(0);
		for(RGBColor c:results)
			total = ColorCombinations.add(total, c);
		
		return total;
	}

	public static class Factory extends ParenExpInf.Factory {

		protected String commandName() {
			return "sum";
		}

		protected int numberOfParameters() {
			return -1;
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new PIsum(subExpressions);
		}

	}

}
