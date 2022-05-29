package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "singleton")
public class Doctor implements Staff, BeanNameAware {
    public void assist(){
        System.out.println("Doctor is assist");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName method is called");
    }

    @PostConstruct
    public void postCon() {
        System.out.println("postCon method is called");
    }


}
