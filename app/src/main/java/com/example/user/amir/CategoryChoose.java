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

//puts the info gotten from the adapter Book and places them in a list
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//if clicked on one of the books it sends the user to the information page about th book.
        Intent i=new Intent(this,DetailedBookActivity.class);
        i.putExtra("book", arrayList.get(position));
        startActivity(i);
    }

    public void fillSubCategoriesList(String category) {//fills the books page with information

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
            arrayList.add(new Book("Kingdom", 9.9, "Born in the Warring States period of ancient China, Xin and Piao are war-orphans in the kingdom of Qin who dream of becoming \"Great Generals of the Heavens\" to rise from their lowly stations in life. One day, however, Piao is taken to the palace by a minister to be used for an unknown purpose, leaving Xin alone as a household slave in a peasant village. A few months later, Piao returns to the village on the verge of death, urging Xin to travel to another village. There he meets a boy who looks nearly identical to Piao, Ying Zheng, the current King of Qin. Xin learns that Piao served as a body double for Ying Zheng, and was mortally wounded in a power struggle for the throne. Though initially furious at Ying Zheng for causing Piao's death, Xin decides to seize the opportunity and aid Ying Zheng in defeating his brother and reclaiming the Qin throne. Successful in this endeavor, Xin officially starts his life as a Qin commander on the battlefields of Warring States China with the goal of becoming the \"Greatest General in the World\", and to help King Zheng of Qin achieve his dream of total unification, ending the incessant warfare once and for all.", R.drawable.kingdom));
            arrayList.add(new Book("Bone", 10, "The series centers on the Bone cousins, bald cartoon characters. In the opening pages of “Out from Boneville” the three Bone cousins, an avaricious and greedy Phoncible P. \"Phoney\" Bone, a goofy cigar-smoking Smiley Bone, and an everyman character Fone Bone, have been run out of their hometown of Boneville after Phoney's campaign for mayor went awry. After crossing a desert, the cousins are separated by a sea of locusts and individually ending up in the mysterious Valley and must make their way across the fantasy landscape pursued by rat creatures (Fone Bone uses a mysterious hand-drawn map that Smiley had found). They joyously reunite at a local tavern called Barrelhaven, where they are taken in by a mysterious girl named Thorn and her even more enigmatic grandmother. Fone Bone instantly develops a crush on Thorn when he meets her, and repeatedly attempts to express his love through poetry. As they stay longer in the Valley, they encounter humans and other creatures who are threatened by a dark entity, the Lord of the Locusts. The Bones, trying to escape to Boneville, are quickly drawn into the events around them, compelling them on a hero's journey to help free the Valley.\n" +
                    "\n" +
                    "Although Boneville is never actually shown in the story, it is implied as technologically contemporary: Fone refers to its extensive downtown and has comics for Smiley and a copy of Moby Dick in his pack, Phoney carries dollar bills, and Smiley refers to a PizzaInACup™ and a CornDogHut™. In contrast, the Valley is depicted as somewhat medieval, in as much as its citizens employ a barter system, weapons, and modes of transportation similar to those of the Middle Ages, and Phoney persistently refers to the valley people as \"yokels\".", R.drawable.bone));

        } else if (category.equals("Mystery")) {
            arrayList.add(new Book("Sherlock Holmes", 5.9, "Holmes worked as a detective for twenty-three years, with physician John Watson assisting him for seventeen.[21] They were roommates before Watson's 1888 marriage and again after his wife's death. Their residence is maintained by their landlady, Mrs. Hudson. Most of the stories are frame narratives, written from Watson's point of view as summaries of the detective's most interesting cases. Holmes frequently calls Watson's writing sensational and populist, suggesting that it fails to accurately and objectively report the \"science\" of his craft:", R.drawable.sherlock));
            arrayList.add(new Book("Percy Jackson", 6.4, "Meet Percy Jackson. He is twelve years old, and he decides to tell us the story of his past year. On the first day of summer, just after his sixth-grade year, Percy discovers that something is wrong with him. Or rather, something is right with him. He learns that he is a half-blood: half-human, half-god. He is taken to Camp Half-Blood in New York, a camp for kids just like him that is safe from monsters that like to attack half-bloods. \n" +
                    "\n" +
                    "At camp, Percy learns more information about himself: his father is Poseidon, god of the Sea and brother to Zeus and Hades. When Zeus's master bolt (the thing that allows him to create lightning whenever he wants) is stolen, Poseidon is blamed for the theft. Zeus tells Poseidon that the master bolt must be returned to Mount Olympus by the summer solstice, or else he will declare war on Poseidon. Poseidon is miffed that his brother Zeus would even accuse him of such a thing.", R.drawable.percy));

        }
    }

}


