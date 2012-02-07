package model;

import java.util.ArrayList;
import java.util.List;

import expressions.*;

public class ExpressionFactory {

	private List<Expression.Factory> eTypes;

	public ExpressionFactory(){
		eTypes = new ArrayList<Expression.Factory>();
		//constants
		eTypes.add(new Constant.Factory());
		//variables
		eTypes.add(new Variable.Factory());
		//paren expressions
		//0 op
		eTypes.add(new Prandom.Factory());
		//1 op
		eTypes.add(new Pabsolutev.Factory());
		eTypes.add(new Parctan.Factory());
		eTypes.add(new Pceiling.Factory());
		eTypes.add(new Pclamp.Factory());
		eTypes.add(new Pcosine.Factory());
		eTypes.add(new Pfloor.Factory());
		eTypes.add(new Plog.Factory());
		eTypes.add(new Pnegate.Factory());
		eTypes.add(new Pnegate.Factory2());
		eTypes.add(new Prgbtoycrcb.Factory());
		eTypes.add(new Psine.Factory());
		eTypes.add(new Ptangent.Factory());
		eTypes.add(new Pwrap.Factory());
		eTypes.add(new Pycrcbtorgb.Factory());
		//2 op
		eTypes.add(new Pdivide.Factory());
		eTypes.add(new Pdivide.Factory2());
		eTypes.add(new Pexponent.Factory());
		eTypes.add(new Pexponent.Factory2());
		eTypes.add(new Pminus.Factory());
		eTypes.add(new Pminus.Factory2());
		eTypes.add(new Pmodulus.Factory());
		eTypes.add(new Pmodulus.Factory2());
		eTypes.add(new Pmultiply.Factory());
		eTypes.add(new Pmultiply.Factory2());
		eTypes.add(new Pperlinbw.Factory());
		eTypes.add(new Pperlincolor.Factory());
		eTypes.add(new Pplus.Factory());
		eTypes.add(new Pplus.Factory2());
		//3 op
		eTypes.add(new Pcolor.Factory());
		eTypes.add(new Plet.Factory());
		eTypes.add(new Pif.Factory());
		//inf op
		eTypes.add(new PIsum.Factory());
		eTypes.add(new PIproduct.Factory());
		eTypes.add(new PIaverage.Factory());
		eTypes.add(new PImin.Factory());
		eTypes.add(new PImax.Factory());
	}
	
	public Expression getExpression(Parser parser){
		for(Expression.Factory type : eTypes) {
            if(type.isKindOfExpression(parser)) {
                return type.parseExpression(parser);
            }
        }
        throw new ParserException("Unparsable expression: " + parser.stringAtCurrentPosition());
	}

}
