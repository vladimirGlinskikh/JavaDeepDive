package kz.zhelezyaka.patterns.immutableObject;

import java.util.List;

public class Mutable {
    // можно наследоваться и влиять на поле
    protected List<String> data;

    // можно передать свой List и менять потом его, меняя при этом содержимое
    // объекта
    public Mutable(List<String> data) {
        this.data = data;
    }

    //Копирующий конструктор
    //теперь два объекта будут содержать ссылку на один и тот же список
    public Mutable(Mutable input) {
        this.data = input.data;
    }

    //геттер отдает оригинальный список.
    //Такой список легко изменить за пределами объекта
    //mutable.getData().clear()
    public List<String> getData() {
        return data;
    }

    //сеттер ставит в поле сразу значение и клиент может
    // оставить себе ссылку и менять по тихому
    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mutable{" +
                "data=" + data +
                '}';
    }
}
