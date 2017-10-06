package com.jcpallavicino.sample.myalbumgallery;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create album data list
        albumList=new ArrayList<>();
        albumList.add(new Album("Got to be there","Michael Jackson"));
        albumList.add(new Album("Ben","Michael Jackson"));
        albumList.add(new Album("Music and me","Michael Jackson"));
        albumList.add(new Album("Forever Michael","Michael Jackson"));
        albumList.add(new Album("Off the wall","Michael Jackson"));
        albumList.add(new Album("Thriller","Michael Jackson"));
        albumList.add(new Album("Bad", "Michael Jackson"));
        albumList.add(new Album("Dangerous", "Michael Jackson"));
        albumList.add(new Album("HIStory","Michael Jackson"));
        albumList.add(new Album("Invincible","Michael Jackson"));
        albumList.add(new Album("The best of Michael Jackson","Michael Jackson"));
        albumList.add(new Album("One day in your life","Michael Jackson"));
        albumList.add(new Album("Farewell my summer love", "Michael Jackson"));
        albumList.add(new Album("Greatest Hits","Michael Jackson"));
        albumList.add(new Album("Number one", "Michael Jackson"));
        albumList.add(new Album("The ultimate collection","Michael Jackson"));
        albumList.add(new Album("The essential Michael Jackson", "Michael Jackson"));
        albumList.add(new Album("King of pop", "Michael Jackson"));

        //Bind listview
        listView=(ListView)findViewById(R.id.listview);

        //Create adapter and set it to listview.
        adapter=new ListViewAdapter(MainActivity.this,albumList);
        listView.setAdapter(adapter);


        //Set an item click listener to show toast
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Show a toast depends on clicked item of listview
                Toast.makeText(MainActivity.this, getResources().getString(R.string.clicked_item, albumList.get(position).getAlbumName()), Toast.LENGTH_SHORT).show();
            }
        });

        //Set a long click listener to show rename dialog
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showEditDialog(position);
                return true;
            }
        });
    }

    private void showEditDialog(final int position){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.edit_dialog);

        //Bind dialog views
        final EditText renameEdittext=(EditText)dialog.findViewById(R.id.rename_edittext);
        final Button renameButton=(Button)dialog.findViewById(R.id.rename_button);
        Button deleteButton=(Button)dialog.findViewById(R.id.delete_button);

        //Set clicked album name to rename edittext
        renameEdittext.setText(albumList.get(position).getAlbumName());

        //When rename button is clicked, first rename edittext should be checked if it is empty
        //If it is not empty, data and listview item should be changed.
        renameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!renameEdittext.getText().toString().equals("")) {
                    albumList.get(position).setAlbumName(renameEdittext.getText().toString());
                    //Notify adapter about changing of model list
                    adapter.notifyDataSetChanged();
                    //Close dialog
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.cant_be_empty), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //When delete button is clicked, it should be deleted from
        //data list and adapter should be notified that data list change
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                albumList.remove(position);
                //Notify adapter about changing of model list
                adapter.notifyDataSetChanged();
                //Close dialog
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
