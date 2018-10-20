package yitian.study.entity;

import org.springframework.boot.SpringBootVersion;

public class SpringVersion implements ISpringVersion {
    @Override
    public String getSpringVersion() {
        return org.springframework.core.SpringVersion.getVersion();
    }

    @Override
    public String getSpringBootVersion() {
        return SpringBootVersion.getVersion();
    }
}
