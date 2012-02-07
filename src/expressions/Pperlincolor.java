package expressions;
import java.util.*;

import model.RGBColor;
import model.util.PerlinNoise;

public class Pperlincolor extends ParenExp{
	
	public Pperlincolor(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		
		return PerlinNoise.colorNoise(results.get(0), results.get(1));

	}

	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "perlinColor";
        }

        protected int numberOfParameters() {
            return 2;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pperlincolor(subExpressions);
        }
        
    }

}
