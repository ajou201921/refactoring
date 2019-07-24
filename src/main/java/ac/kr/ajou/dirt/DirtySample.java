package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isNameSulfuras(items[i])) {
                continue;
            }
            if (isNameAgedBrie(items[i])) {
                updateAgedBrie(items[i]);
            } else if (isNamebackstage(items[i])) {
                updateBackStage(items[i]);
            } else {
                updateOtherItems(items[i]);
            }
        }
    }

    private void updateOtherItems(Item item) {
        positiveQualityDecrease_1(item);
        item.decrease_1_SellIn();
        if (isSellInLessThanNumber(item, 0)) {
            positiveQualityDecrease_1(item);
        }
    }

    private void updateBackStage(Item item) {
        add_1_Quality_LessThan_50(item);
        if (isSellInLessThanNumber(item, 11)) {
            add_1_Quality_LessThan_50(item);
        }
        if (isSellInLessThanNumber(item, 6)) {
            add_1_Quality_LessThan_50(item);
        }
        item.decrease_1_SellIn();
        if (isSellInLessThanNumber(item, 0)) {
            initializeQualityTo0(item);
        }
    }

    private void updateAgedBrie(Item item) {
        add_1_Quality_LessThan_50(item);
        item.decrease_1_SellIn();
        if (isSellInLessThanNumber(item, 0)) {
            add_1_Quality_LessThan_50(item);
        }
    }

    private boolean isSellInLessThanNumber(Item item, int number) {
        return item.sellIn < number;
    }

    private void add_1_Quality_LessThan_50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

    }

    private void initializeQualityTo0(Item item) {
        item.quality = 0;
    }


    private boolean isNameSulfuras(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) return true;
        return false;
    }

    private boolean isNameAgedBrie(Item item) {
        if (item.name.equals("Aged Brie")) return true;
        return false;
    }

    private boolean isNamebackstage(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) return true;
        return false;
    }

    private void positiveQualityDecrease_1(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;

        }
    }
}