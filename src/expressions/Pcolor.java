package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorCombinations;

public class Pcolor extends ParenExp{
	
	public Pcolor(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return ColorCombinations.colorize(results.get(0), results.get(1), results.get(2));

	}

	
	public static class Factory extends PExpParamFactories.Factory3P
    {

        protected String commandName() {
            return "color";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pcolor(subExpressions);
        }
        
    }

}
