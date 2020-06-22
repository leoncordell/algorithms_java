package com.algorithm.concurrency.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMerge {

    public static void main(String[] args) {
        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        eBike2.getTags().add("sport");

        Map<String, Product> productsByName = new HashMap<>();
        productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProdcut);
    }

    static public class Product {

        private String name;
        private String description;
        private List<String> tags;

        public Product(String s, String a_bike_with_a_battery) {
        }

        // standard getters/setters/constructors

        public Product addTagsOfOtherProdcut(Product product) {
            this.tags.addAll(product.getTags());
            return this;
        }

        private List<String> getTags() {
            return tags;
        }


    }
}
