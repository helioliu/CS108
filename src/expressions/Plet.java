package expressions;

import java.util.*;

import model.RGBColor;

public class Plet extends ParenExp {

	public Plet(List<Expression> subexpressions) {
		super(subexpressions);
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		Vmapping newVar = new Vmapping(( (Variable)mySubexpressions.get(0)).getName(), mySubexpressions.get(1));
		vars.add(0, newVar);
		RGBColor result = mySubexpressions.get(2).evaluate(xval, yval, tval, vars);
		vars.remove(0);
		return result;
	}

	public static class Factory extends ParenExp.Factory {

		protected String commandName() {
			return "let";
		}

		protected int numberOfParameters() {
			return 3;
		}

		protected ParenExp constructParenExpression(List<Expression> subExpressions) {
			return new Plet(subExpressions);
		}

	}

}
