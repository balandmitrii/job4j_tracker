package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(this::filter)
                .map(this::createLabelString)
                .toList();
    }

    private boolean filter(Product product) {
        return product.getStandard() - product.getActual() <= 3
                && product.getStandard() - product.getActual() >= 0;
    }

    private String createLabelString(Product product) {
        Label label = new Label(
                product.getName(),
                product.getPrice() / 2
        );
        return label.toString();
    }
}
