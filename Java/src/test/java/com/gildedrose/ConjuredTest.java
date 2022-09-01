package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class ConjuredTest {

    @Test
    public void conjured_QualityDecreases_doubleSpeed() {
        GildedRose app = new GildedRose(new Item[]{new Item("Conjured Mana Cake", 3, 6)});

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", 2, 4));
    }

    @Test
    public void conjured_QualityDecreases_doubleSpeed_2timesWhenSellInOff() {
        GildedRose app = new GildedRose(new Item[]{new Item("Conjured Mana Cake", 0, 6)});

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", -1, 2));
    }
}
