

package com.example.recipeproj;
import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipeproj.Recipe;

import java.io.ByteArrayOutputStream;
import java.security.PrivateKey;
import java.util.List;

public class AdapterRecipe  extends BaseAdapter {
   private Context mContext;
    List<Recipe> recipeList;
    public AdapterRecipe(Context mContext,List<Recipe> listProduct)
    {
        this.mContext = mContext;
        this.recipeList = listProduct;
    }
    @Override
    public int getCount() {
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recipeList.get(position).getIdRecipe();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.activity_recipe,null);
        TextView fullRec = v.findViewById(R.id.txtFull);
        TextView nameRec = v.findViewById(R.id.txtName);
        ImageView imageView = v.findViewById(R.id.imageView2);

        Recipe recipe = recipeList.get(position);

        fullRec.setText(recipe.getFullRecipe());
        nameRec.setText(recipe.getNameRecipe());
        DecodeImage dcd = new DecodeImage(mContext);
        imageView.setImageBitmap(dcd.getUserImage(recipe.getImage()));


        return null;
    }
}





