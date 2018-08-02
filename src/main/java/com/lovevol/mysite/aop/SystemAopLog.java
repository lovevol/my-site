package com.lovevol.mysite.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SystemAopLog {
    private static final Logger logger = LoggerFactory.getLogger(SystemAopLog.class);
    private static int typeBefore = 1;
    private static int typeAfterSuccess = 2;
    private static int typeAfterError = 3;

    @Pointcut("@annotation(AopLog)")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint, null, typeBefore);
    }

    @AfterReturning("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        handleLog(joinPoint, null, typeAfterSuccess);
    }

    @AfterThrowing(value = "controllerAspect()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, typeAfterError);
    }

    private void handleLog(JoinPoint joinPoint, Exception e, int type) {
        try {
            //获取注解
            AopLog aopLog = getAopLog(joinPoint);
            if (aopLog == null) {
                return;
            }
            String signature = joinPoint.getSignature().toString();//获取签名信息
            String methodName = signature.substring(signature.lastIndexOf(".") + 1, signature.indexOf("("));//获取方法名称
            //String classType = joinPoint.getTarget().getClass().getName();//获取类名
            //Class clazz = Class.forName(classType);
            String id = aopLog.id();//id
            String operateTypeDesc = aopLog.operateTypeDesc();//操作描述
            Long operateType = aopLog.operateType();//操作类型
            String moudleCode = aopLog.moudleCode();//模块代码
            String moudleName = aopLog.moudleName();//模块名称
            String bussType = aopLog.bussType();//业务代码
            String bussTypeDesc = aopLog.bussTypeDesc();//业务描述
            StringBuffer buffer = new StringBuffer();
            buffer.append("方法名:").append(signature);
            switch (type) {
                case 1:
                    buffer.append("=====开始执行=====");
                    break;
                case 2:
                    buffer.append("=====执行成功=====");
                    break;
                case 3:
                    buffer.append("=====执行失败=====");
                    break;
                default:
                    buffer.append("未知类型");

            }
            if (!"".equals(id)) {
                buffer.append("id:").append(id);
            }
            if (!"".equals(operateTypeDesc)) {
                buffer.append("操作类型描述:").append(operateTypeDesc).append(";");
            }
            if (-1L != operateType) {
                buffer.append("操作类型:").append(operateType).append(";");
            }
            if (!"".equals(moudleCode)) {
                buffer.append("模块编码:").append(moudleCode).append(";");
            }
            if (!"".equals(moudleName)) {
                buffer.append("模块名称:").append(methodName).append(";");
            }
            if (!"".equals(bussType)) {
                buffer.append("业务类型:").append(bussType).append(";");
            }
            if (!"".equals(bussTypeDesc)) {
                buffer.append("业务类型描述:").append(bussTypeDesc).append(";");
            }
            if (null == e) {
                logger.info(buffer.toString());
            } else {
                logger.error(buffer.toString());
                logger.error(e.getMessage());
            }
        } catch (Exception e1) {
            logger.error(e.getMessage());
        }
    }

    //获取定义的AopLog
    private AopLog getAopLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(AopLog.class);
        }
        return null;
    }
}
