package yitian.study.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("FriendDetail")
@JsonIgnoreProperties({"uselessProp1", "uselessProp3"})
public class FriendDetail {
    @JsonProperty("NickName")
    private String name;
    @JsonProperty("Age")
    private int age;
    private String uselessProp1;
    @JsonIgnore
    private int uselessProp2;
    private String uselessProp3;
}
