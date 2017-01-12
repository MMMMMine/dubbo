package com.aust.tlh.study.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/12.
 * Version 1.0
 */
@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value = "com.aust.tlh.study.aspectJ.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
