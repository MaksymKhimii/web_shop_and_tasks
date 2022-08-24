package com.epam.khimii.task4.strategy.impl;

import com.epam.khimii.task1.entity.Accessory;
import com.epam.khimii.task1.entity.ComputerPart;
import com.epam.khimii.task1.entity.GraphicsCard;
import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.parts.constants.Constants;
import com.epam.khimii.task4.entity.Country;
import com.epam.khimii.task4.strategy.InputProductStrategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Generate product container of different randomize type of products
 */
public class RandomInputProductStrategy implements InputProductStrategy {
    private Random random;
    private final Map<Integer, Product> generate = new HashMap<>();
    public List<Product> products;


    public RandomInputProductStrategy(List<Product> products) {
        this.products = products;
        this.random = new Random();
        this.generate.put(Constants.PRODUCT_CREATOR_NUMBER, createProduct());
        this.generate.put(Constants.ACCESSORIES_CREATOR_NUMBER, createAccessories());
        this.generate.put(Constants.COMPUTER_PART_CREATOR_DATA_NUMBER, createComputerPart());
        this.generate.put(Constants.GRAPHICS_CARD_CREATOR_NUMBER, createGraphicsCard());
    }

    public Product generateProduct(List<Product> products) {
        return this.generate.get(getType());
    }

    @Override
    public int getType() {
        return random.nextInt(4) + 1;
    }

    private Product createProduct() {
        return new Product(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name());
    }

    private Product createComputerPart() {
        return new ComputerPart(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name(),
                Constants.PRODUCT_FIELD_CATEGORY + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_PURPOSE + random.nextInt(Constants.RANDOM_BOUND));
    }

    private Product createAccessories() {
        return new Accessory(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name(),
                Constants.PRODUCT_FIELD_TYPE + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_BRAND + random.nextInt(Constants.RANDOM_BOUND));
    }

    private Product createGraphicsCard() {
        return new GraphicsCard(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name(),
                Constants.PRODUCT_FIELD_CATEGORY + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_PURPOSE + random.nextInt(Constants.RANDOM_BOUND),
                random.nextInt(32),
                Constants.INPUT_MEMORY_TYPE + random.nextInt(Constants.RANDOM_BOUND),
                Constants.INPUT_CONNECTOR + random.nextInt(Constants.RANDOM_BOUND));
    }
}