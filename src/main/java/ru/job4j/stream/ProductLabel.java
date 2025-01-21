package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter((Product product) ->
                        product.getStandard() - product.getActual() <= 3
                )
                .map((Product product) -> {
                    Label label = new Label(
                            product.getName(),
                            product.getPrice() / 2
                    );
                    return label.toString();
                })
                .toList();
    }
}
