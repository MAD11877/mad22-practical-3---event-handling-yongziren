package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Btn = findViewById(R.id.FOLLOW);
        User user = new User("Tom", "description", 1, false);

        Intent fromList = getIntent();
        int ran = fromList.getIntExtra("RandomNum",0);
        TextView textView = findViewById(R.id.HelloWorld);
        textView.setText("MAD "+ran);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!user.Followed) {
                    Btn.setText("UNFOLLOW");
                    user.Followed = true;
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT ).show();
                }
                else{
                    Btn.setText("FOLLOW");
                    user.Followed = false;
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT ).show();
                }
            }
        });

        Button msg = findViewById(R.id.MESSAGE);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_to_messagegroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(main_to_messagegroup);
            }
        });
    }
}