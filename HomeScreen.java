package jaredjl2.illinois.edu.cardgames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button goFishBtn = (Button) findViewById(R.id.goFishBtn);
        goFishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GoFishActivity.class);
                startActivity(startIntent);
            }
        });

        Button oldMaidBtn = (Button) findViewById(R.id.oldMaidBtn);
        oldMaidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), OldMaidActivity.class);
                startActivity(startIntent);
            }
        });

        Button blackjackBtn = (Button) findViewById(R.id.blackjackBtn);
        blackjackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), OldMaidActivity.class);
                startActivity(startIntent);
            }
        });

        Button pokerBtn = (Button) findViewById(R.id.pokerBtn);
        pokerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), OldMaidActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
