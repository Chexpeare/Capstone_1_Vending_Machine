package com.techelevator.view;

import com.techelevator.Candy;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest extends TestCase {

    @Test
    void test_CompleteCandyPurchase_ReturnItemsRemaining() {
        Candy candy = new Candy();
        String[] input = {"Moonpie", "Cowtales", "Wonka Bar", "Crunchie", "Carlos", "Lazarus", "dhg345"};

        for ( int i = 4; i >= 0; i--) {
            for (int j = 6; j >= 0; j--) {
                Assert.assertEquals(i, candy.completeCandyPurchase(input[j]));
            }
        }

    }
}