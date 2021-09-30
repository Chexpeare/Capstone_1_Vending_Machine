package com.techelevator.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.techelevator.Inventory;
import com.techelevator.Purchase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseTest {

    private ByteArrayOutputStream output;

    @Before
    public void setup() {
//        this.calc= new Math();
    }

    @Test
    public void makeChangeTest() throws IOException {
        Menu menu = new Menu(System.in, System.out);
        Inventory inventory = new Inventory();
        Purchase purchase = new Purchase(menu);

//        Object[] options = new Object[] { 2, 1, 100, 2, "C3"};
        getMenuForTestingWithUserInput(2 + System.lineSeparator());
        getMenuForTestingWithUserInput(1 + System.lineSeparator());
        getMenuForTestingWithUserInput(100 + System.lineSeparator());
        getMenuForTestingWithUserInput(2 + System.lineSeparator());
        getMenuForTestingWithUserInput("C3" + System.lineSeparator());

        purchase.feedMoney();
        purchase.finishTransaction();

        Assert.assertEquals(30 , purchase.getQuarters());
        Assert.assertEquals(3 , purchase.getDimes());
        Assert.assertEquals(1 , purchase.getNickels());
    }

    private Menu getMenuForTestingWithUserInput(String userInput) {
        ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
        return new Menu(input, output);
    }

    private Menu getMenuForTesting() {
        return getMenuForTestingWithUserInput("1" + System.lineSeparator());
    }

}
