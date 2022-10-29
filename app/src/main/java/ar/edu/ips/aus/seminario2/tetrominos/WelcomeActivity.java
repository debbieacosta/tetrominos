package ar.edu.ips.aus.seminario2.tetrominos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class WelcomeActivity extends AppCompatActivity {
    LinearLayout l1, l2;
    Button btn_easy, btn_normal, btn_hard;
    Animation uptodown, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Encontrar el boton por id
        btn_easy = (Button) findViewById(R.id.bEasy);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l2.setAnimation(downtoup);
        AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent easyLevel = new Intent(WelcomeActivity.this, GameMainActivity.class);
                easyLevel.putExtra("level", 1);
                startActivity(easyLevel);
                btn_easy.startAnimation(buttonClick);
            }
        });
        btn_normal = (Button)findViewById(R.id.bNormal);
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent normalLevel = new Intent(WelcomeActivity.this, GameMainActivity.class);
                normalLevel.putExtra("level", 4);
                startActivity(normalLevel);
                btn_normal.startAnimation(buttonClick);
            }
        });

        btn_hard = (Button) findViewById(R.id.bHard);
        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hardLevel = new Intent(WelcomeActivity.this, GameMainActivity.class);
                hardLevel.putExtra("level", 7);
                startActivity(hardLevel);
                btn_hard.startAnimation(buttonClick);
            }
        });



    }
}