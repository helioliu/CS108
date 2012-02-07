package expressions;
import java.util.*;

import model.RGBColor;

public class Ptangent extends ParenExp{
	
	public Ptangent(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toTan = results.get(0);
		
		return new RGBColor(tangent(toTan.getRed()),
				tangent(toTan.getGreen()),
				tangent(toTan.getBlue()));

	}
	
	private double tangent(double c){
		c = (c*180)/Math.PI;
		return Math.tan(c);
	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "tan";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Ptangent(subExpressions);
        }
        
    }

}
