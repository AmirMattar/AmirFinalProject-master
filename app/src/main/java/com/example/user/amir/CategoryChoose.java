package com.example.user.amir;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryChoose extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvBookList;
    ArrayList<Book> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);

        lvBookList = findViewById(R.id.lvBookList);

        String category = getIntent().getStringExtra("categories");
        Toast.makeText(this, getIntent().getStringExtra("categories"), Toast.LENGTH_LONG).show();
        fillSubCategoriesList(category);

        BookCustomAdapter adapter = new BookCustomAdapter(this, R.layout.book_custom_row, arrayList);
        lvBookList.setAdapter(adapter);
        lvBookList.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(this,DetailedBookActivity.class);
        i.putExtra("book", arrayList.get(position));
        startActivity(i);
    }

    public void fillSubCategoriesList(String category) {

        if (category.equals("Science fiction")) {
            arrayList.add(new Book("LOTR", 9, "twenty rings existed: three for elves, seven for dwarves, nine for men, and one made by the Dark Lord Sauron, in Mordor, which would rule all the others. Sauron poured all his evil and his will to dominate into this ring. An alliance of elves and humans resisted Sauron’s ring and fought against Mordor. They won the battle and the ring fell to Isildur, the son of the king of Gondor, but just as he was about to destroy the ring in Mount Doom, he changed his mind and held on to it for himself. Later he was killed, and the ring fell to the bottom of the sea. The creature Gollum discovered it and brought it to his cave. Then he lost it to the hobbit Bilbo Baggins.", R.drawable.lotr));
            arrayList.add(new Book("The Witcher", 7.8, "The Empire of Nilfgaard attacks the Kingdom of Cintra. Queen Calanthe commits suicide and her granddaughter, Cirilla, called Ciri and nicknamed the \"Lion Cub of Cintra\" manages to flee from the burning capital city. Emhyr var Emreis, Emperor of Nilfgaard, sends his spies to find her. He knows that this young girl has great importance, not only because of her royal blood, but also because of her magical potential and elven blood in her veins.", R.drawable.thewicther));

        } else if (category.equals("Action and Adventure")) {
            arrayList.add(new Book("Harry Potter", 10, "Harry Potter is the most miserable, lonely boy you can imagine. He’s shunned by his relatives, the Dursley’s, that have raised him since he was an infant. He’s forced to live in the cupboard under the stairs, forced to wear his cousin Dudley’s hand-me-down clothes, and forced to go to his neighbour’s house when the rest of the family is doing something fun. Yes, he’s just about as miserable as you can get.\n" +
                    "\n" +
                    "Harry’s world gets turned upside down on his 11th birthday, however. A giant, Hagrid, informs Harry that he’s really a wizard, and will soon be attending Hogwarts School of Witchcraft and Wizardry. Harry also learns that, in the wizarding world, he’s a hero. When he was an infant, the evil Lord Voldemort killed his parents and then tried to kill Harry too. What’s so amazing to everyone is that Harry survived, and allegedly destroyed Voldemort in the process.", R.drawable.hp));
            arrayList.add(new Book("Game Of Thrones", 8.3, "Game of Thrones season 1 introduced fantasy and epic fans to the cutthroat and brutal world of Westeros and the lengths to which people are willing to go to sit on the coveted Iron Throne. The Game of Thrones first season aired on HBO in 2011, and with all the plot twists and new characters GoT throws at viewers, it's always good to refresh your memory with a quick summary, and that's exactly what you'll find in this Game of Thrones season 1 recap.\n" +
                    "\n" +
                    "What the heck happened in Westeros back in Game of Thrones season one? In the first season we first see Daenerys Targareyen's rise from slave to queen, Ned Stark's discovery of a disturbing Lannister secret, the death of a King, the awesomeness of Tyrion, the kickass gal that is Arya Stark, and the first signs of a winter which threatens to destroy everything.", R.drawable.got));

        } else if (category.equals("Histroy")) {
            arrayList.add(new Book("The Art Of War", 6.7, "The Art of War is an ancient Chinese military treatise dating from the Late Spring and Autumn Period (roughly 5th century BC). The work, which is attributed to the ancient Chinese military strategist Sun Tzu (\"Master Sun\", also spelled Sunzi), is composed of 13 chapters. Each one is devoted to an aspect of warfare and how it applies to military strategy and tactics. For almost 1,500 years it was the lead text in an anthology that would be formalised as the Seven Military Classics by Emperor Shenzong of Song in 1080. The Art of War remains the most influential strategy text in East Asian warfare[1] and has influenced both Eastern and Western military thinking, business tactics, legal strategy and beyond.", R.drawable.aof));
            arrayList.add(new Book("The French Revolution", 5.9, "The French Revolution was a watershed event in modern European history that began in 1789 and ended in the late 1790s with the ascent of Napoleon Bonaparte. During this period, French citizens razed and redesigned their country’s political landscape, uprooting centuries-old institutions such as absolute monarchy and the feudal system. The upheaval was caused by widespread discontent with the French monarchy and the poor economic policies of King Louis XVI, who met his death by guillotine, as did his wife Marie Antoinette. Although it failed to achieve all of its goals and at times degenerated into a chaotic bloodbath, the French Revolution played a critical role in shaping modern nations by showing the world the power inherent in the will of the people.", R.drawable.french));

        } else if (category.equals("Comics")) {
            arrayList.add(new Book("Kingdom", 10, "..", R.drawable.kingdom));
            arrayList.add(new Book("Bone", 10, "..", R.drawable.bone));

        } else if (category.equals("Mystery")) {
            arrayList.add(new Book("Sherlock Holmes", 10, "Miss Mary Morstan arrives at 221B, Baker Street to request help with the mystery of her missing father, her anonymous gifts of pearls and a letter requesting her to meet an unknown person that evening. Holmes takes on her case and the adventure begins.\n" +
                    "\n" +
                    "Watson narrates the tale that sees the detective tracking down hidden treasure and murderers. By the end of the story the criminals are either dead or arrested, and Miss Mary Morstan and Watson are engaged to be married.", R.drawable.sherlock));
            arrayList.add(new Book("Percy Jackson", 10, "..", R.drawable.percy));

        }
    }

}


