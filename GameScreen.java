package jaredjl2.illinois.edu.cardgames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        ImageView cardU1 = (ImageView) findViewById(R.id.cardU1);
        ImageView cardU2 = (ImageView) findViewById(R.id.cardU2);
        ImageView cardU3 = (ImageView) findViewById(R.id.cardU3);
        ImageView cardU4 = (ImageView) findViewById(R.id.cardU4);
        ImageView cardU5 = (ImageView) findViewById(R.id.cardU5);
        ImageView cardU6 = (ImageView) findViewById(R.id.cardU6);
        ImageView cardU7 = (ImageView) findViewById(R.id.cardU7);
        ImageView cardD1 = (ImageView) findViewById(R.id.cardD1);
        ImageView cardD2 = (ImageView) findViewById(R.id.cardD2);
        ImageView cardD3 = (ImageView) findViewById(R.id.cardD3);
        ImageView cardD4 = (ImageView) findViewById(R.id.cardD4);
        ImageView cardD5 = (ImageView) findViewById(R.id.cardD5);
        ImageView cardD6 = (ImageView) findViewById(R.id.cardD6);
        ImageView cardD7 = (ImageView) findViewById(R.id.cardD7);

        TextView p0ScoreTextView = (TextView) findViewById(R.id.p0ScoreTextView);
        TextView p1ScoreTextView = (TextView) findViewById(R.id.p1ScoreTextView);

        EditText player0InputEditText = (EditText) findViewById(R.id.player0InputEditText);
        EditText player1InputEditText = (EditText) findViewById(R.id.player1InputEditText);

        ArrayList<Player> roster = new ArrayList<>();
        Deck deck = new Deck();
        deck.createDeck();
        roster.add(new Player("Player1"));
        roster.add(new Player("Player2"));
        roster.get(0).setHand(deck);
        roster.get(1).setHand(deck);
        ArrayList<Card> deckOfCards = deck.getDeck();
        roster.get(0).checkHand();
        roster.get(1).checkHand();
        //int j = 0;
        boolean turn = false;
        boolean player1 = true;

        if (roster.get(0).getHand().size() < roster.get(1).getHand().size()) {
            while (deckOfCards.size() != 0 || roster.get(1).getHand().size() != 0 || roster.get(0).getHand().size() != 0) {
                //turn = true;
                while (player1) {
                    String input = player1InputEditText.getText().toString();
                    if (roster.get(1).addPoints(input)) {
                        player1 = true;
                    } else {
                        roster.get(1).getHand().add(deck.draw());
                        roster.get(1).checkHand();
                        player1 = false;
                    }
                }

                while(!player1) {
                    String inputs = player0InputEditText.getText().toString();
                    if (roster.get(0).addPoints(inputs)) {
                        player1 = false;
                    } else {
                        roster.get(0).getHand().add(deck.draw());
                        roster.get(0).checkHand();
                        player1 = true;
                    }
                }
            }
        }




        Button p1CardsBtn = (Button) findViewById(R.id.p1CardsBtn);
        p1CardsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Player1Cards.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        /*Button p2CardsBtn = (Button) findViewById(R.id.p2CardsBtn);
        p2CardsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Player2Cards.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });*/

        final EditText player2InputEditText = (EditText) findViewById(R.id.player2InputEditText);
        //final String strValue = player2InputEditText.getText().toString();

        //final ImageView cardU3 = (ImageView) findViewById(R.id.cardU3);

        //final ImageView cardU3 = (ImageView) findViewById(R.id.cardU3);


        Button p2CardsBtn = (Button) findViewById(R.id.p2CardsBtn);
        p2CardsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView p2ScoreTextView = (TextView) findViewById(R.id.p2ScoreTextView);

                //p2ScoreTextView.setText(player2InputEditText.getText().toString() + "");

                if ((player2InputEditText.getText().toString() + "").equals("jack")) {
                    String urlJS = "https://deckofcardsapi.com/static/img/JS.png";

                    //Picasso.get().load(urlJS).into(cardU3);
                }
            }
        });

        //Button testButton = (Button) findViewById(R.id.testButton);
        //final LinearLayout layoutL = (LinearLayout) findViewById(R.id.layoutL);
        //final ImageView newView = (ImageView) findViewById(R.id.cardU1);

        /*testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = new ImageView(GameScreen.this);
                imgView.setLayoutParams(new LinearLayout.LayoutParams(140, 100));
                imgView.setX(20F);
                imgView.setImageResource(R.drawable.rotated_blue_card);
                layoutL.addView(imgView);

            }
        });*/

        /*ImageView cardImgView = findViewById(R.id.cardImageView);
        String urlJS = "https://deckofcardsapi.com/static/img/JS.png";

        Picasso.with(this).load(urlJS).into(cardImgView);

        YoYo.with(Techniques.FadeOut)
                .duration(4000)
                .playOn(cardImgView);

        ImageView cardImgView1 = findViewById(R.id.cardImageView1);
        String urlBack = "https://upload.wikimedia.org/wikipedia/commons/e/e0/Russian_style_card_back.jpg";
        Picasso.with(this).load(urlBack).into(cardImgView1);

        YoYo.with(Techniques.FadeIn)
                .duration(3000)
                .playOn(cardImgView1);*/
    }
}
