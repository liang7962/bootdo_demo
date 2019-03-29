package com.bootdo.common.config;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * thymeleaf自定义工具对象
 * Created by hello on 2018/12/6.
 */
public class UserDialect extends AbstractDialect  implements IExpressionObjectDialect  {

    private final IExpressionObjectFactory EXPRESSION_OBJECTS_FACTORY = new UserProcessor();

    public UserDialect() {
        super("user");
    }



    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return this.EXPRESSION_OBJECTS_FACTORY;
    }
}
