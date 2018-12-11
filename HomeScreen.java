package jaredjl2.illinois.edu.cardgames;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button rulesButton = (Button) findViewById(R.id.rulesButton);
        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goFishRules = "https://www.bicyclecards.com/how-to-play/go-fish/";
                Uri webAddress = Uri.parse(goFishRules);

                Intent goToRules = new Intent(Intent.ACTION_VIEW, webAddress);

                if (goToRules.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToRules);
                }
            }
        });

        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GameScreen.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
