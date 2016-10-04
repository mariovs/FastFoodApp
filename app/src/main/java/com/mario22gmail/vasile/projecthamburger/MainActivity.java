package com.mario22gmail.vasile.projecthamburger;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private boolean addState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SwitchCompat hamburgerPageSwitch = (SwitchCompat) findViewById(R.id.hamburgerSwitch);
        hamburgerPageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SwitchHamburgerPage();
                if(isChecked)
                    buttonView.setText("Stergere");
                else
                    buttonView.setText("Adaugare");
            }
        });
        ReadDataFromDb();
    }

    private void SwitchHamburgerPage()
    {
        addState = !addState;
        if(addState)
        {
            ImageButton hamburgerSpecialActionButton  = (ImageButton) findViewById(R.id.buttonActionHamburgerSpecial);
            hamburgerSpecialActionButton.setImageResource(R.drawable.add_img);

            ImageButton hamburgerDubluActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerDublu);
            hamburgerDubluActionButton.setImageResource(R.drawable.add_img);

            ImageButton hamburgerSuncaActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerSunca);
            hamburgerSuncaActionButton.setImageResource(R.drawable.add_img);

            ImageButton hamburgerMediuActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerMediu);
            hamburgerMediuActionButton.setImageResource(R.drawable.add_img);

            ImageButton hamburgerCheeseActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerCheese);
            hamburgerCheeseActionButton.setImageResource(R.drawable.add_img);

            ImageButton hamburgerCartofi = (ImageButton)findViewById(R.id.buttonActionHamburgerCartofi);
            hamburgerCartofi.setImageResource(R.drawable.add_img);

            ImageButton hamburgerSimplu = (ImageButton)findViewById(R.id.buttonActionHamburgerSimplu);
            hamburgerSimplu.setImageResource(R.drawable.add_img);

            ImageButton hamburgerVegetarian = (ImageButton)findViewById(R.id.buttonActionHamburgerVegetarian);
            hamburgerVegetarian.setImageResource(R.drawable.add_img);

            ImageButton sandwitch = (ImageButton)findViewById(R.id.buttonActionSandwitch);
            sandwitch.setImageResource(R.drawable.add_img);
        }
        else
        {
            ImageButton hamburgerSpecialActionButton  = (ImageButton) findViewById(R.id.buttonActionHamburgerSpecial);
            hamburgerSpecialActionButton.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerDubluActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerDublu);
            hamburgerDubluActionButton.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerSuncaActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerSunca);
            hamburgerSuncaActionButton.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerMediuActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerMediu);
            hamburgerMediuActionButton.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerCheeseActionButton = (ImageButton) findViewById(R.id.buttonActionHamburgerCheese);
            hamburgerCheeseActionButton.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerCartofi = (ImageButton)findViewById(R.id.buttonActionHamburgerCartofi);
            hamburgerCartofi.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerSimplu = (ImageButton)findViewById(R.id.buttonActionHamburgerSimplu);
            hamburgerSimplu.setImageResource(R.drawable.remove_img);

            ImageButton hamburgerVegetarian = (ImageButton)findViewById(R.id.buttonActionHamburgerVegetarian);
            hamburgerVegetarian.setImageResource(R.drawable.remove_img);

            ImageButton sandwitch = (ImageButton)findViewById(R.id.buttonActionSandwitch);
            sandwitch.setImageResource(R.drawable.remove_img);
        }
    }


    //fab action click
    public void FabStatisticsNavigationClick(View view)
    {
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_anim_disapear);
        view.startAnimation(myAnimation);
        Intent statisticIntent = new Intent(this, Statistics_Activity.class);
        startActivity(statisticIntent);

    }


    //action hamburger click
    public void ButtonActionHamburgerSpecialClick(View view) {

        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerSpecial) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerSpecialTable, 1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerSpecialTable);
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
        }
        ReadDataFromDb();

    }

    public void ButtonActionHamburgerDubluClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerDublu) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerDubluTable, 1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerDubluTable);
        }
        ReadDataFromDb();

    }

    public void ButtonActionHamburgerSuncaClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerSunca) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerSuncaTable, 1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerSuncaTable);
        }
        ReadDataFromDb();

    }

    public void ButtonActionHamburgerMediuClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerMediu) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerMediuTable ,1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerMediuTable);
        }
        ReadDataFromDb();

    }

    public void ButtonActionHamburgerCheeseClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerCheese) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerCheeseTable ,1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerCheeseTable);
        }
        ReadDataFromDb();

    }

    public void ButtonActionHamburgerCartofiClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerCartofi) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerCartofiTable ,1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerCartofiTable);
        }
        ReadDataFromDb();

    }

    public void ButtonActionHamburgerSimpluClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerSimplu) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerSimpluTable ,1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerSimpluTable);
        }
        ReadDataFromDb();

    }


    public void ButtonActionHamburgerVegetarianClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionHamburgerVegetarian) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.HamburgerVegetarianTable ,1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.HamburgerVegetarianTable);
        }
        ReadDataFromDb();

    }


    public void ButtonActionSandwichClick(View view) {
        Animation shake = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.shake);
        ImageButton button = (ImageButton)findViewById(R.id.buttonActionSandwitch) ;
        button.startAnimation(shake);

        if(addState) {
            SqlConstants.AddHamburger(this.getApplicationContext(),SqlConstants.SandwichTable,1);
            Toast.makeText(this.getApplicationContext(), "Adaugat cu success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this.getApplicationContext(), "Sters cu success", Toast.LENGTH_SHORT).show();
            SqlConstants.DeleteLastHamburger(this.getApplicationContext(), SqlConstants.SandwichTable);
        }
        ReadDataFromDb();

    }



    public void ReadDataFromDb() {
        try {
            TextView textViewSpecial = (TextView) findViewById(R.id.resultHamburgerSpecialTextView);
            String valuesFromSpecialTable = "Hamburger Special \n" + SqlConstants.ReadHamburgerSpecial(this.getApplicationContext());

            TextView textViewDublu = (TextView) findViewById(R.id.resultHamburgerDubluTextView);
            String valuesFromDubluTable = "Hamburger Dublu \n" + SqlConstants.ReadHamburgerDublu(this.getApplicationContext());

            TextView textViewSunca = (TextView) findViewById(R.id.resultHamburgerSuncaTextView);
            String valuesFromSuncaTable = "Hamburger Sunca \n" + SqlConstants.ReadHamburgerSunca(this.getApplicationContext());

            TextView textViewMediu = (TextView) findViewById(R.id.resultHamburgerMediuTextView);
            String valuesFromMediuTable = "Hamburger Mediu \n" + SqlConstants.ReadHamburgerMediu(this.getApplicationContext());

            TextView textViewCheese = (TextView) findViewById(R.id.resultHamburgerCheeseTextView);
            String valuesFromCheeseTable = "Cheeseburger \n" + SqlConstants.ReadHamburgerCheese(this.getApplicationContext());

            TextView textViewCartofi = (TextView) findViewById(R.id.resultHamburgerCartofiTextView);
            String valuesFromCartofiTable = "Cartofi \n" + SqlConstants.ReadHamburgerCartofi(this.getApplicationContext());

            TextView textViewSimplu = (TextView) findViewById(R.id.resultHamburgerSimpluTextView);
            String valuesFromSimpluTable = "Simplu \n" + SqlConstants.ReadHamburgerSimplu(this.getApplicationContext());

            TextView textViewVegetarian = (TextView) findViewById(R.id.resultHamburgerVegetarianTextView);
            String valuesFromVegetarianTable = "Vegetarian \n" + SqlConstants.ReadHamburgerVegetarian(this.getApplicationContext());

            TextView textViewSandwitch = (TextView) findViewById(R.id.resultSandwitchTextView);
            String valuesFromSandwitchTable = "Sandwitch \n" + SqlConstants.ReadSandwitch(this.getApplicationContext());



            TextView hamburgerSpecialDailyCountTextView = (TextView) findViewById(R.id.hamburgerSpecialDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerSpecialDailyCountTextView, SqlConstants.HamburgerSpecialTable);

            TextView hamburgerDublyDailyCountTextView = (TextView) findViewById(R.id.hamburgerDubluDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerDublyDailyCountTextView, SqlConstants.HamburgerDubluTable);

            TextView hamburgerSuncaDailyCountTextView = (TextView) findViewById(R.id.hamburgerSuncaDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerSuncaDailyCountTextView, SqlConstants.HamburgerSuncaTable);

            TextView hamburgerMediuDailyCountTextView = (TextView) findViewById(R.id.hamburgerMediuDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerMediuDailyCountTextView, SqlConstants.HamburgerMediuTable);

            TextView hamburgerCheeseDailyCountTextView = (TextView) findViewById(R.id.hamburgerCheeseDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerCheeseDailyCountTextView, SqlConstants.HamburgerCheeseTable);

            TextView hamburgerCartofiDailyCountTextView = (TextView) findViewById(R.id.hamburgerCartofiDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerCartofiDailyCountTextView, SqlConstants.HamburgerCartofiTable);

            TextView hamburgerSimpluDailyCountTextView = (TextView) findViewById(R.id.hamburgerSimpluDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerSimpluDailyCountTextView, SqlConstants.HamburgerSimpluTable);

            TextView hamburgerVegetarianDailyCountTextView = (TextView) findViewById(R.id.hamburgerVegetarianDailyCountTextView);
            UpdateSoldDayHamburger(hamburgerVegetarianDailyCountTextView, SqlConstants.HamburgerVegetarianTable);

            TextView sandwitchDailyCountTextView = (TextView) findViewById(R.id.sandwitchDailyCountTextView);
            UpdateSoldDayHamburger(sandwitchDailyCountTextView, SqlConstants.SandwichTable);


            textViewDublu.setText(valuesFromDubluTable);
            textViewSpecial.setText(valuesFromSpecialTable);
            textViewSunca.setText(valuesFromSuncaTable);
            textViewCheese.setText(valuesFromCheeseTable);
            textViewCartofi.setText(valuesFromCartofiTable);
            textViewMediu.setText(valuesFromMediuTable);
            textViewSimplu.setText(valuesFromSimpluTable);
            textViewVegetarian.setText(valuesFromVegetarianTable);
            textViewSandwitch.setText(valuesFromSandwitchTable);


            Log.i("MARIO DB ", valuesFromSpecialTable);
            Log.i("MARIO DB ", valuesFromDubluTable);
            Log.i("MARIO DB ", valuesFromSuncaTable);
            Log.i("MARIO DB ", valuesFromMediuTable);
            Log.i("MARIO DB ", valuesFromCheeseTable);
            Log.i("MARIO DB ", valuesFromCartofiTable);
            Log.i("MARIO DB ", valuesFromSimpluTable);
            Log.i("MARIO DB ", valuesFromVegetarianTable);
            Log.i("MARIO DB ", valuesFromSandwitchTable);
        }
        catch (Exception ex)
        {
            Toast.makeText(this.getApplicationContext(), "Eroare la citire", Toast.LENGTH_SHORT).show();
            Log.i("MARIO Error", ex.getMessage());
        }
    }


    public void UpdateSoldDayHamburger(TextView hamburgerTextView, String hamburgerTable) {
        try {
            int hamburgerCount = SqlConstants.GetNumberOfHamburgerSoldToday(this.getApplicationContext(), hamburgerTable);
            hamburgerTextView.setText(hamburgerCount + "");

        } catch (Exception e) {
            Log.i("Hamburger Error", e.getMessage());
            Toast.makeText(this.getApplicationContext(), "Eroare la citire", Toast.LENGTH_SHORT).show();

        }

    }
}
