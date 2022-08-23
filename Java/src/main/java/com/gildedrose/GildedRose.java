package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        int degradeValue = item.name.equals(CONJURED) ? -2 : -1;
        boolean doesDegrade = !item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE) && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS);

        if (doesDegrade) {
            setQuality(item, degradeValue);
        } else {
            setQuality(item, 1);
            if (item.name.equals(BACKSTAGE)) {
                if (item.sellIn < 11) {
                    setQuality(item, 1);
                }
                if (item.sellIn < 6) {
                    setQuality(item, 1);
                }
            }
        }

        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (doesDegrade) {
                setQuality(item, degradeValue);
            }
            if (item.name.equals(AGED_BRIE)) {
                setQuality(item, 1);
            } else if (item.name.equals(BACKSTAGE)) {
                item.quality = item.quality - item.quality;
            }
        }
    }

    private static void setQuality(Item item, int qualityChange) {
        int newQuality = item.quality + qualityChange;
        if (newQuality <= 50 && newQuality >= 0) {
            item.quality = newQuality;
        }
    }
}

