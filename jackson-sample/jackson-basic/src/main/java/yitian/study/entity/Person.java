package yitian.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Person")
public class Person {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("NickName")
    //@JacksonXmlText
    private String nickname;
    @JsonProperty("Age")
    private int age;
    @JsonProperty("IdentityCode")
    @JacksonXmlCData
    private String identityCode;
    @JsonProperty("Birthday")
    //@JacksonXmlProperty(isAttribute = true)
    @JsonFormat(pattern = "yyyy/MM/DD")
    private LocalDate birthday;

}
