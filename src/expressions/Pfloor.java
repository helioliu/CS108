package expressions;
import java.util.*;

import model.RGBColor;

public class Pfloor extends ParenExp{
	
	public Pfloor(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toFloor = results.get(0);
		
		return new RGBColor(floor(toFloor.getRed()),
				floor(toFloor.getGreen()),
				floor(toFloor.getBlue()));

	}
	
	private double floor(double c){
		return Math.floor(c);
	}

	
	public static class Factory extends PExpParamFactories.Factory1P
    {

        protected String commandName() {
            return "floor";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pfloor(subExpressions);
        }
        
    }

}
