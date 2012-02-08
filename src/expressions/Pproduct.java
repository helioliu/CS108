package expressions;

import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pproduct extends ParenExp{

	public Pproduct(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor product = new RGBColor(0);
		for(RGBColor c:results)
			product = ColorCombinations.multiply(product, c);
		
		return product;
	}

	public static class Factory extends PExpParamFactories.FactoryInfP {

		protected String commandName() {
			return "product";
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new Pproduct(subExpressions);
		}

	}

}
