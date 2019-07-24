package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DirtySampleTest {
    @Test
    public void  이름이otherItems에속하고_selln이_0_quality0이상일때검증(){
        Item[] items ={new Item("sdf",0,2)};
        DirtySample dirtySample =new DirtySample(items);
        dirtySample.updateQuality();

        assertTrue(items[0].quality==0);
    }

    @Test
    public void  이름이otherItems에속하고_selln이_1_quality0이상일떄검증(){
        Item[] items ={new Item("sdf",1,2)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertTrue(items[0].quality == 1);
    }

    @Test
    public void  이름이otherItems에속하고_selln이_1_quality음수일때검증(){
        Item[] items ={new Item("sdf",1,-1)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertTrue(items[0].quality==-1);
    }


    @Test
    public void  이름이Aged_Brie이고_selln이_0이하_quality48이하일때검증(){
        Item[] items ={new Item("Aged Brie",0,48)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 50);
    }



    @Test
    public void  이름이Aged_Brie이고_selln이_1이상_quality50미만일때검증(){
        Item[] items ={new Item("Aged Brie",1,48)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality==49);
    }

    @Test
    public void  이름이Aged_Brie이고_selln이_1이상_quality50이상일때검증(){
        Item[] items ={new Item("Aged Brie",1,60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality==60);
    }


    @Test
    public void  이름이Backstage_passes_to_a_TAFKAL80ETC_concert이고_selln이_11_quality50미만일때검증(){
        Item[] items ={new Item("Backstage passes to a TAFKAL80ETC concert",11,47)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality==48);
    }


    @Test
    public void  이름Backstage_passes_to_a_TAFKAL80ETC_concertB이고_selln이_11_quality50이상일때검증(){
        Item[] items ={new Item("Backstage passes to a TAFKAL80ETC concert",11,50)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality==50);
    }

    @Test
    public void  이름이Backstage_passes_to_a_TAFKAL80ETC_concert이고_selln이_6_quality50미만일때검증(){
        Item[] items ={new Item("Backstage passes to a TAFKAL80ETC concert",6,47)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality==49);
    }

    @Test
    public void  이름이Backstage_passes_to_a_TAFKAL80ETC_concert이고_selln이_0이하일때맞는지검증(){
        Item[] items ={new Item("Backstage passes to a TAFKAL80ETC concert",0,47)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality==0);
    }

    @Test
    public void 이름이Sulfuras_Hand_of_Ragnaros일때_변화하지않는지검증(){
        Item[] items ={new Item("Sulfuras, Hand of Ragnaros",0,47), new Item("Sulfuras, Hand of Ragnaros",1,2)};
        Item[] temp =items;
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertTrue(items[0].quality == temp[0].quality);
        assertTrue(items[0].sellIn == temp[0].sellIn);

        assertTrue(items[1].quality == temp[1].quality);
        assertTrue(items[1].sellIn == temp[1].sellIn);

    }

}
