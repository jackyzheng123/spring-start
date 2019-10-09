package com.zjx.test;

import com.zjx.entity.StudentA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description Spring Bean的循环依赖
 * <p>
 *     Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException
 *
 * spring管理StudentA、StudentB、StudentC，循环依赖：A依赖B，B依赖C，C依赖A
 * @Author Carson Cheng
 * @Date 2019/4/2 9:58
 * @Version V1.0
 **/
public class BeanCircleDependenceTest {

    /*
        1. 构造器参数循环依赖:
           Spring容器先创建单例StudentA，StudentA依赖StudentB，然后将A放在“当前创建Bean池”中，
           此时创建StudentB,StudentB依赖StudentC ,然后将B放在“当前创建Bean池”中,
           此时创建StudentC，StudentC又依赖StudentA，
           但是，此时StudentA,StudentB已经在池中，所以会报错，因为在池中的Bean都是未初始化完的，所以会依赖错误，（初始化完的Bean会从池中移除）

        2. setter方式单例，默认方式:
           实例化过程：
               a.实例化Bean对象
               b.设置对象属性
               c.检查Aware相关接口并设置相关依赖
               e.BeanPostProcessor前置处理器
                   bean初始化（实现initializingBean接口调用afterPropertiesSet方法；自定义init-method;@PostConstruct）
                 BeanPostProcessor后置处理器
               f.注册相关Destruction相关回调接口
               g.使用Bean
               h.销毁（实现DisposableBean接口；自定义destroy-method;@PreDestroy）
           Spring先是用构造实例化Bean对象，此时Spring会将这个实例化结束的对象放到一个Map中（缓存起来），并且Spring提供了获取这个未设置属性的实例化对象引用的方法。
           当Spring实例化了StudentA、StudentB、StudentC后，紧接着会去设置对象的属性，此时StudentA依赖StudentB，就会去Map中取出存在里面的单例StudentB对象，以此类推，不会出来循环的问题喽

        3. setter方式原型，prototype
           scope="prototype" 意思是 每次请求都会创建一个实例对象。
           两者的区别是：有状态的bean都使用Prototype作用域，无状态的一般都使用singleton单例作用域
           对于“prototype”作用域Bean，Spring容器无法完成依赖注入，因为“prototype”作用域的Bean，Spring容器不进行缓存，因此无法提前暴露一个创建中的Bean。
    */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("students.xml");
        StudentA a = (StudentA) context.getBean("a");
        StudentA a1 = (StudentA) context.getBean("a");
        System.out.println(a == a1);
    }
}
