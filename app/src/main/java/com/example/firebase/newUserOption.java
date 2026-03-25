package com.example.firebase;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class newUserOption extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.useroptionsmenu,menu);
        return true;

    }
    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.add_item) {

            Toast.makeText(this, "Add item clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id==R.id.view_items) {

            Toast.makeText(this, "View item clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id==R.id.logout) {

            Toast.makeText(this, "logout clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
