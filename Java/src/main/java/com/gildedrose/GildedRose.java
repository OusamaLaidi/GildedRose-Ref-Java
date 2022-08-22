package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
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
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE)) {
            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                setQuality(item, -1);
            }
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
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE)) {
                    if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        setQuality(item, -1);
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                setQuality(item, 1);
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

