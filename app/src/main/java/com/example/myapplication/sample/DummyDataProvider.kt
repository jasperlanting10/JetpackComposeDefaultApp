package com.example.myapplication.sample

import com.example.myapplication.control.Category
import com.example.myapplication.control.Product
import com.example.myapplication.control.User


object DummyDataProvider {
    //user dummy data
    val user = User("Jasper Lanting")


    //Product dummy data
    val beerProducts = generateBeerProducts()

    //Category dummy data
    val categories = generateCategories()



    fun generateCategories() : ArrayList<Category>{
        return arrayListOf(
            Category("Acties", 1),
            Category("Bier", 1, beerProducts),
            Category("Snacks", 1),
            Category("Speciaalbier", 1),
            Category("Wijnen en Bubbels", 1),
            Category("Packs", 1),
            Category("Frisdrank", 1),
            Category("Cider", 1),
            Category("ijs & accessoires", 1)
        )
    }
    fun generateBeerProducts() : ArrayList<Product>{
        return arrayListOf(
            Product(
                "Heineken krat 24x30cl incl. statiegeld",
                "Heineken Pilsener (5%) krat ijskoud geleverd.",
                1,
                20.89,
                arrayListOf("IJskoud geleverd", "De totaal prijs is incl. statiegeld t.w.v. 3,90")
            ),
            Product(
                "Heineken Blik 6x33 cl",
                "Heineken Pilsner (5%) is een verfrissend volmout kwaliteitspils met een licht fruitige smaak die perfect in balans is met de frisse bitterheid van de hop",
                1,
                5.79,
                arrayListOf(
                    "Geleverd op een temperatuur van 2 a 5 graden is Heineken bier het lekkerst, Proost!",
                    "Incl 1/4 Heineken Biertegoed"
                )
            ),
            Product(
                "Heineken Twist-off Fles 12x25 cl",
                "Heineken Pilsner (5%) is een verfrissend volmout kwaliteitspils met een licht fruitige smaak die perfect in balans is met de frisse bitterheid van de hop",
                1,
                20.89,
                arrayListOf(
                    "Geleverd op een temperatuur van 2 a 5 graden is Heineken bier het lekkerst, Proost!",
                    "Incl 1/4 Heineken Biertegoed"
                )
            ),
            Product(
                "Heineken Clubbottle 6x33cl",
                "Heineken Pilsener (5%) in een aluminium bottle. De unieke festival bottle nu tijdelijk verkrijgbaar",
                1,
                7.99
            ),
            Product(
                "Heineken Torps 2L - THE SUB",
                "Heineken TORP's bevat 2 liter premium tapbier, goed voor circa 8 glazen Heineken. TORP's is alleen te gebruiken in THE SUB",
                1,
                6.49,
                arrayListOf(
                    "Na openenen koel bewaren in THE SUB. Gegarandeerd 15 dagen vers na opening.",
                    "Makkelijk te verwisselen en goed te recyclen.",
                    "Alcoholpercentage: 5,0%"
                )
            ),
            Product(
                "Heineken 0.0 Blik 6x33cl",
                "Heineken 0.0: een alcoholvrij bier met een verfrissend en fruitige smaak dankzij Heinken's unieke A-gist, gecombineerd met een zacht moutige body",
                1,
                20.89,
                arrayListOf("Geleverd op een temperatuur van 2 a 5 graden is Heineken bier het lekkerst, Proost!")
            )
        )
    }
}