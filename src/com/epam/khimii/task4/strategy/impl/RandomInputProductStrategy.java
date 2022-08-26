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
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Generate product container of different randomize type of products
 */
public class RandomInputProductStrategy implements InputProductStrategy {
    private Random random = new Random();
    ;
    private final Map<Integer, Supplier<Product>> generate = new HashMap<>() {{
        put(Constants.PRODUCT_CREATOR_NUMBER, () -> createProduct());
        put(Constants.ACCESSORIES_CREATOR_NUMBER, () -> createAccessories());
        put(Constants.COMPUTER_PART_CREATOR_DATA_NUMBER, () -> createComputerPart());
        put(Constants.GRAPHICS_CARD_CREATOR_NUMBER, () -> createGraphicsCard());
    }};


    public RandomInputProductStrategy() {
    }

    public Product generateProduct() {
        int type = random.nextInt(4) + 1;
        return this.generate.get(type).get();
    }

    private Product createProduct() {
        return new Product(generateName(), generatePrice(), generateCountry());
    }

    private Product createComputerPart() {
        return new ComputerPart(generateName(), generatePrice(), generateCountry(),
                generateCategory(), generatePurpose());
    }

    private Product createAccessories() {
        return new Accessory(generateName(), generatePrice(), generateCountry(),
                Constants.PRODUCT_FIELD_TYPE + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_BRAND + random.nextInt(Constants.RANDOM_BOUND));
    }

    private Product createGraphicsCard() {
        return new GraphicsCard(generateName(), generatePrice(), generateCountry(),
                generateCategory(), generatePurpose(), random.nextInt(32),
                Constants.INPUT_MEMORY_TYPE + random.nextInt(Constants.RANDOM_BOUND),
                Constants.INPUT_CONNECTOR + random.nextInt(Constants.RANDOM_BOUND));
    }

    private String generateName() {
        return Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND);
    }

    private BigDecimal generatePrice() {
        return new BigDecimal(random.nextInt(Constants.RANDOM_BOUND));
    }

    private String generateCountry() {
        return Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name();
    }

    private String generateCategory() {
        return Constants.PRODUCT_FIELD_CATEGORY + random.nextInt(Constants.RANDOM_BOUND);
    }

    private String generatePurpose() {
        return Constants.PRODUCT_FIELD_PURPOSE + random.nextInt(Constants.RANDOM_BOUND);
    }
}