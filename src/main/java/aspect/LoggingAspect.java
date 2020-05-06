package aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
	
	@Before("execution(* query.IQuery.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint)
	{
		System.out.println("Logging Aspect Before All Methods" + 
				joinPoint.getSignature().getName());
	}
	
	@Before("execution(* query.IQuery.create(..))")
	public void logBeforeCreate(JoinPoint joinPoint)
	{
		System.out.println("Logging Aspect Before Create" +
				joinPoint.getSignature().getName());
	}
	
	@Before("execution(* query.IQuery.deleteAll(..))")
	public void logBeforeDeleteAll(JoinPoint joinPoint)
	{
		System.out.println("Logging Aspect Before Delete All" +
				joinPoint.getSignature().getName());
	}
}
