package expressions;
import java.util.*;

import model.RGBColor;
import model.util.PerlinNoise;

public class Pperlinbw extends ParenExp{
	
	public Pperlinbw(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return PerlinNoise.greyNoise(results.get(0), results.get(1));

	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "perlinBW";
        }

        protected int numberOfParameters() {
            return 2;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pperlinbw(subExpressions);
        }
        
    }

}
