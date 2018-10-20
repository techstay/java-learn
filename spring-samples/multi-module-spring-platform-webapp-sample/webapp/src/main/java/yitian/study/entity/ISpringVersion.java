package yitian.study.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ISpringVersion {
    @JsonProperty("springVersion")
    String getSpringVersion();

    @JsonProperty("springBootVersion")
    String getSpringBootVersion();
}
