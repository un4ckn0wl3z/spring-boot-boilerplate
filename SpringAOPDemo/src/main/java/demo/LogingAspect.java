package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){
        System.out.println(jp.getSignature());
        System.out.println(jp.getArgs()[0].toString());
        System.out.println("Before Logger");
    }

    @After("execution(* *.*.checkout(.. ))")
    public void afterLogger(){
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity())")
    public void afterReturingPointCut(){

    }

    @AfterReturning(pointcut = "afterReturingPointCut()", returning = "retVal")
    public void afterReturning(int retVal) {
        System.out.println("After returning : " + retVal);
    }
}
