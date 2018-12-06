package com.simple.studio.gradle.shrink;

/**
 * AppShrink
 * APK分析
 * ---s1.Android Studio自带Analyze APK；
 * ---s2.解压APK包分析APK资源结构；
 * APP瘦身
 * #1.图片的优化 ☆☆☆☆☆
 * ---s1.png图片压缩裁剪，打包APP后资源文件分50k+大小图片重点优化，10k+图片选择优化；
 * ---s2.图片资源格式处理(大小)：.png > .jpg > .webp，条件合适选择应选择.webp；
 * ---s3.使用矢量图；
 * ------png图片优化
 * ------https://blog.csdn.net/u010052279/article/details/81224265
 * ------https://tinypng.com/
 * ------http://nullice.com/limitPNG/
 * ------关于webp
 * ------https://www.zhihu.com/question/27201061
 * #2.开启混淆与压缩 ☆☆☆☆☆
 * ---s1.gradle shrinkResources设置为true，minifyEnabled设置为true；
 * ---s2.gradle minifyEnabled可单独开启，shrinkResources必须与minifyEnabled一起开启；
 * ---s3.屏蔽代码混淆-keep class com.** { *; }；
 * #3.APP架构上的优化
 * ---s1.只用一套图片资源，如xhdpi或xxhdpi；
 * ---s2.只用一套功能类似的框架，如图片处理只用ImageLoader或glide；
 * ---s3.框架上的优化，如定制项目使用的框架或自研框架仅定制开发项目相关功能模块，或简化框架架构；
 * ---s4.so库仅使用仅加入APP支持的平台部分；
 * #5.其他优化
 * ---s1.指定打包时编译的语言包类型：resConfigs("zh")，默认包含英文；
 * Ref:
 * ---https://blog.csdn.net/luckyleaf666/article/details/60572736
 * ---https://www.jianshu.com/p/99f3c09982d4
 */
public class AppShrink {
}
