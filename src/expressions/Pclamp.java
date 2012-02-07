package expressions;
import java.util.*;

import model.RGBColor;

public class Pclamp extends ParenExp{
	
	public Pclamp(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		RGBColor toClamp = results.get(0);
		
		toClamp.clamp();
		
		return toClamp;
	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "clamp";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pclamp(subExpressions);
        }
        
    }

}
