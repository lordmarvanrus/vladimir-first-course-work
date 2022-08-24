package pro.sky.vladimirfirstcoursework;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl {

    private final Basket basket;

    public StoreServiceImpl(Basket basket) {
        this.basket = basket;
    }

    public List<Item> add(List<Integer> ids) {
        return basket.add(
                ids.stream()
                        .map(Item::new)
                        .collect(Collectors.toList())
        );
    }

    public List<Item> get() {
        return basket.get();
    }

}
