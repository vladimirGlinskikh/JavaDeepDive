package kz.zhelezyaka.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PassByReference {
    void modifyObject(ClassByReference reference) {
        reference.setValue(reference.getValue() * reference.getValue());
    }
}


@AllArgsConstructor
@Getter
@Setter
class ClassByReference {
    private Integer value;
}

@AllArgsConstructor
@Getter
final class ImmutableObject {
    private Integer i;

    public ImmutableObject withValue(Integer newInteger) {
        return new ImmutableObject(newInteger);
    }
}
