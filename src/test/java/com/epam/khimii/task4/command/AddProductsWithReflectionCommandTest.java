package com.epam.khimii.task4.command;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.reflection.InputWithReflection;
import com.epam.khimii.task4.service.IProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class AddProductsWithReflectionCommandTest {
    private Product product;
    private AddProductsWithReflectionCommand addProductsWithReflectionCommand;
    private IProductService productService;
    private InputWithReflection inputWithReflection;

    @Before
    public void beforeTest() {
        inputWithReflection = Mockito.mock(InputWithReflection.class);
        productService = Mockito.mock(IProductService.class);
        addProductsWithReflectionCommand = new AddProductsWithReflectionCommand(inputWithReflection, productService);
        product = new Product("test", new BigDecimal("10"), "uk");
    }

    @Test
    public void shouldAddProduct() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Mockito.when(inputWithReflection.addProduct()).thenReturn(product);
        Mockito.when(productService.isExists(product)).thenReturn(true);
        addProductsWithReflectionCommand.execute();
        Mockito.verify(inputWithReflection).addProduct();
        Mockito.verify(productService).addProdToList(product);
        Mockito.verify(productService).isExists(product);
    }
}