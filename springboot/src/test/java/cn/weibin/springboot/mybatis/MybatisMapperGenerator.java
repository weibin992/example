package cn.weibin.springboot.mybatis;

import java.net.URL;

import org.mybatis.generator.api.ShellRunner;

/**
 * Mybatis Generator
 * @author weibin
 * @date 2019-11-14
 */
public class MybatisMapperGenerator {

    public static void main(String[] args){
        URL url = MybatisMapperGenerator.class.getResource("/");
        args = new String[] {"-configfile", url.getPath() + "/mybatis-generator-config.xml", "-overwrite"};
        ShellRunner.main(args);
    }
}
