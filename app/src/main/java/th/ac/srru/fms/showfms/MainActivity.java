package th.ac.srru.fms.showfms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import th.ac.srru.fms.showfms.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//             Add Fragment
        if(savedInstanceState==null){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenMainFregment, new MainFragment())
                    .commit();
        }



    } // Main Method
}  //Main Class
