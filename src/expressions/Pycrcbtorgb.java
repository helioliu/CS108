package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorModel;

public class Pycrcbtorgb extends ParenExp{
	
	public Pycrcbtorgb(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		return ColorModel.ycrcb2rgb(results.get(0));

	}
	
	public static class Factory extends ParenExp.Factory
    {

        protected String commandName() {
            return "yCrCbToRGB";
        }

        protected int numberOfParameters() {
            return 1;
        }

        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Pycrcbtorgb(subExpressions);
        }
        
    }

}
