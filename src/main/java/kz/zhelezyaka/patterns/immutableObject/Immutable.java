package kz.zhelezyaka.patterns.immutableObject;

import java.util.ArrayList;
import java.util.List;

public final class Immutable {
    private final List<String> data;

    public Immutable(List<String> data) {
        this.data = new ArrayList<>(data);
    }

    public Immutable(Immutable input) {
        this.data = new ArrayList<>(input.data);
    }

    public List<String> getData() {
        return new ArrayList<>(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
