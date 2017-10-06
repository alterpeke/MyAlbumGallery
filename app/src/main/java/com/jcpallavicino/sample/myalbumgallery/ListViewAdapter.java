package com.jcpallavicino.sample.myalbumgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by juan.pallavicino on 21/9/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private List<Album> albumList;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context, List<Album> albumList){
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Adapter has to know your model list
        this.albumList=albumList;
    }

    @Override
    public int getCount() {
        //Return listview item count
        //It is the same with your model list size.
        return albumList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
       /* View view = inflater.inflate(R.layout.listview_item,null,false);
        //Adapter gives position parameter.
        //This parameter helps us to know which item view is wanted by adapter.
        ((TextView)view.findViewById(R.id.album_name)).setText(albumList.get(position).getAlbumName());
        ((TextView)view.findViewById(R.id.artist_name)).setText(albumList.get(position).getArtistName());
        return view;*/
        if(convertView==null){
            convertView=inflater.inflate(R.layout.listview_item,null,false);
            //Create a holder object and bind its views
            ViewHolder viewHolder=new ViewHolder();
            viewHolder.albumName=(TextView)convertView.findViewById(R.id.album_name);
            viewHolder.artistName=(TextView)convertView.findViewById(R.id.artist_name);
            //Attach it to convertView
            convertView.setTag(viewHolder);
        }
        //Get holder object from convertView
        ViewHolder holder = (ViewHolder)convertView.getTag();

        //Adapter gives position parameter.
        //This parameter helps us to know which item view is wanted by adapter.
        holder.albumName.setText(albumList.get(position).getAlbumName());
        holder.artistName.setText(albumList.get(position).getArtistName());
        return convertView;
    }

    public class ViewHolder{
        TextView albumName;
        TextView artistName;
    }
}
