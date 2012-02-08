package expressions;
import java.util.*;

import model.RGBColor;

public class Prandom extends ParenExp{
	
	public Prandom(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars){
		return new RGBColor(makeValidRand(), makeValidRand(), makeValidRand());
	}
	
	private double makeValidRand(){
		return 2*Math.random()-1;
	}
	
	public static class Factory extends PExpParamFactories.Factory0P
    {

        protected String commandName() {
            return "random";
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Prandom(subExpressions);
        }
        
    }

}
