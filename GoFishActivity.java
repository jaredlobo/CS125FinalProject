package jaredjl2.illinois.edu.cardgames;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GoFishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_fish);

        Button goFishRulesBtn = (Button) findViewById(R.id.goFishRulesBtn);
        goFishRulesBtn.setOnClickListener(new View.OnClickListener() {
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
    }
}
