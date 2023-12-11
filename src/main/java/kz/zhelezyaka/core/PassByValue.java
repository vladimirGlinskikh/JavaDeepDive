package kz.zhelezyaka.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PassByValue {
    public void modifyObject(ClassByValue value) {
        value.setValue(value.getValue() * value.getValue());
    }
}

@AllArgsConstructor
@Getter
@Setter
class ClassByValue {
    private Integer value;
}
