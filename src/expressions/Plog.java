package expressions;
import java.util.*;

import model.RGBColor;

public class Plog extends ParenExp{
	
	public Plog(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor tolog = results.get(0);
		
		return new RGBColor(log(tolog.getRed()),
				log(tolog.getGreen()),
				log(tolog.getBlue()));

	}
	
	private double log(double c){
		return Math.log(c);
	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "log";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Plog(subExpressions);
        }
        
    }

}
