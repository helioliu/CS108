package expressions;

public class PExpParamFactories {
	
	public abstract static class Factory0P extends ParenExp.Factory
    {
        protected int numberOfParameters() {
            return 0;
        }

    }
	
	public abstract static class Factory1P extends ParenExp.Factory
    {
        protected int numberOfParameters() {
            return 1;
        }

    }
	
	public abstract static class Factory2P extends ParenExp.Factory
    {
        protected int numberOfParameters() {
            return 2;
        }

    }
	
	public abstract static class Factory3P extends ParenExp.Factory
    {
        protected int numberOfParameters() {
            return 3;
        }

    }
	
	public abstract static class FactoryInfP extends ParenExp.Factory
    {
        protected int numberOfParameters() {
            return Integer.MAX_VALUE;
        }

    }

}
