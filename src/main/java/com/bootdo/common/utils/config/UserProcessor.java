package com.bootdo.common.utils.config;


import com.bootdo.common.utils.DictUtils;
import com.bootdo.common.utils.UserUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * thymeleaf自定义工具对象
 * Created by hello on 2018/12/6.
 */
public class UserProcessor implements IExpressionObjectFactory {

    public static final String DICTIONARY_UTILS_EXPRESSION_NAME_USER = "userUtils";
    public static final String DICTIONARY_UTILS_EXPRESSION_NAME_DICT = "dict";
    public static final Set<String> ALL_EXPRESSION_OBJECT_NAMES;
    private static final UserUtils userUtils = new UserUtils();
    private static final DictUtils dictUtils = new DictUtils();

    static {

        final Set<String> allExpressionObjectNames = new LinkedHashSet<String>();
        allExpressionObjectNames.add(DICTIONARY_UTILS_EXPRESSION_NAME_USER);
        allExpressionObjectNames.add(DICTIONARY_UTILS_EXPRESSION_NAME_DICT);
        ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(allExpressionObjectNames);

    }
    public UserProcessor(){
        super();
    }

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return ALL_EXPRESSION_OBJECT_NAMES;
    }

    @Override
    public Object buildObject(IExpressionContext context, String expressionObjectName) {
        if(DICTIONARY_UTILS_EXPRESSION_NAME_USER.equals(expressionObjectName)){
            return  userUtils;
        }
        if(DICTIONARY_UTILS_EXPRESSION_NAME_DICT.equals(expressionObjectName)){
            return  dictUtils;
        }
        return null;

    }

    public boolean isCacheable(String expressionObjectName) {
        return false;
    }
}
