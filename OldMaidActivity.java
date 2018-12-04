package jaredjl2.illinois.edu.cardgames;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OldMaidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_maid);

        Button oldMaidRulesBtn = (Button) findViewById(R.id.oldMaidRulesBtn);
        oldMaidRulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldMaidRules = "https://www.bicyclecards.com/how-to-play/old-maid/";
                Uri webAddress = Uri.parse(oldMaidRules);

                Intent goToRules = new Intent(Intent.ACTION_VIEW, webAddress);

                if (goToRules.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToRules);
                }
            }
        });
    }
}
