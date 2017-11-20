package com.exa.pesa.core.security;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

/**
 * Created by Andres on 24/9/2017.
 */
public class MappingSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        MappingSecurityExpressionOperation expressionOperation = new MappingSecurityExpressionOperation(authentication);
        expressionOperation.setThis(invocation.getThis());
        expressionOperation.setPermissionEvaluator(getPermissionEvaluator());
        return expressionOperation;
    }

}
