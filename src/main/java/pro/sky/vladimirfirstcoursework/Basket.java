package pro.sky.vladimirfirstcoursework;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.List;

@Component
@SessionScope
public class Basket {
    private final List<Item> items;

    public Basket(List<Item> items) {
        this.items = items;
    }

    public List<Item> add(List<Item> items) {
        this.items.addAll(items);
        return this.items;
    }

    public List<Item> add(Item item) {
        items.add(item);
        return items;
    }

    public List<Item> get() {
        return Collections.unmodifiableList(items);
    }
}
