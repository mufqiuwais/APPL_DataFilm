package aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
	@Pointcut("execution(** query.IQuery.create(..))")
	public void creation() {}
	
	@Pointcut("execution(** query.IQuery.update(..))")
	public void makeUpdate() {}
	
	@Pointcut("execution(** query.IQuery.delete(..))")
	public void deletion() {}
	
	@Before("execution(* query.IQuery.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint)
	{
		System.out.println("Logging Aspect Before All Methods" + 
				joinPoint.getSignature().getName());
	}
	
	@Before("creation()")
	public void beforeCreate(JoinPoint joinPoint)
	{
		System.out.println("Creating A New Film... ->" +
				joinPoint.getSignature().getName());
	}
	
	@AfterReturning("creation()")
	public void afterCreate(JoinPoint joinPoint)
	{
		System.out.println("New Film Created ->" +
				joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("creation()")
	public void afterCreateButFail(JoinPoint joinPoint)
	{
		System.out.println("Fail to Create A New Film");
	}
	
	@Before("makeUpdate()")
	public void beforeUpdate(JoinPoint joinPoint)
	{
		System.out.println("Updating The Film... ->" +
				joinPoint.getSignature().getName());
	}
	
	@AfterReturning("makeUpdate()")
	public void afterUpdate(JoinPoint joinPoint)
	{
		System.out.println("The Film Updated ->" +
				joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("makeUpdate()")
	public void afterUpdateButFail(JoinPoint joinPoint)
	{
		System.out.println("Fail to Update The Film");
	}
	
	@Before("deletion()")
	public void beforeDelete(JoinPoint joinPoint)
	{
		System.out.println("Deleting The Film... ->" +
				joinPoint.getSignature().getName());
	}
	
	@AfterReturning("deletion()")
	public void afterDelete(JoinPoint joinPoint)
	{
		System.out.println("The Film Deleted ->" +
				joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("deletion()")
	public void afterDeleteButFail(JoinPoint joinPoint)
	{
		System.out.println("Fail to Delete The Film");
	}
	
	@Around("execution(* query.IQuery.deleteAll(..))")
	public void logBeforeDeleteAll(ProceedingJoinPoint jp)
	{
		try {
			System.out.println("Preparing to Delete All Film... -> ");
			System.out.println("You'll be unable to see them again... ");
			System.out.println("Ooowh, I think you've choosen the wrong option... ");
			System.out.println("Come On DUDE... ");
		}
		catch (Throwable e) {
			// TODO: handle exception
			System.out.println("Fail to Delete All Film");
			System.out.println("So the force still be with you huh...");
		}
	}
}
