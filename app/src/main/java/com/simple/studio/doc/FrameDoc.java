package com.simple.studio.doc;

/**
 * Created by e2670 on 2017/9/10.
 *
 *===========>gradle特性缺陷测试项目
 * ---gradle
 *      https://github.com/gradle/gradle
 *
 *      @see Math
 *
 * ---issue0
 *  log error:
 *      Could not reserve enough space for 1572864KB object heap
 *  solution:
 *      gradle.properties
 *          org.gradle.jvmargs=-Xmx1024m -XX:MaxPermSize=1024m
 *          org.gradle.jvmargs=-Xmx512m -XX:MaxPermSize=512m
 *      https://stackoverflow.com/questions/4401396/could-not-reserve-enough-space-for-object-heap
 *
 *
 *
 *
 *
 *
 *
 */

public class FrameDoc {
}
