package expressions;
import java.util.*;

import model.RGBColor;

public class Pcosine extends ParenExp{
	
	public Pcosine(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toCos = results.get(0);
		
		return new RGBColor(cosine(toCos.getRed()),
				cosine(toCos.getGreen()),
				cosine(toCos.getBlue()));

	}
	
	private double cosine(double c){
		c = (c*180)/Math.PI;
		return Math.cos(c);
	}

	
	public static class Factory extends PExpParamFactories.Factory1P
    {

        protected String commandName() {
            return "cos";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pcosine(subExpressions);
        }
        
    }

}
